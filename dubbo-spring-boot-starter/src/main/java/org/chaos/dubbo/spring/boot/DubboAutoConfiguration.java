package org.chaos.dubbo.spring.boot;

import com.alibaba.spring.context.config.ConfigurationBeanBinder;
import com.alibaba.spring.util.PropertySourcesUtils;
import org.chaos.dubbo.spring.boot.autoconfigure.BinderDubboConfigBinder;
import org.chaos.dubbo.spring.boot.autoconfigure.DelegatingPropertyResolver;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.source.ConfigurationPropertySources;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.*;

import java.util.Map;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * @Author: lijun
 * @Description:
 * @Date: Created in 2020-12-09 10:11
 * @Modified By:
 */
@Configuration
@ConditionalOnProperty(prefix = "dubbo", name = "enabled", matchIfMissing = true)
@AutoConfigureBefore(EnableDubboConfiguration.class)
@EnableConfigurationProperties(DubboProperties.class)
public class DubboAutoConfiguration implements InitializingBean {

    @Bean(name = "dubboScanBasePackagesPropertyResolver")
    public PropertyResolver dubboScanBasePackagesPropertyResolver(ConfigurableEnvironment environment) {
        ConfigurableEnvironment propertyResolver = new AbstractEnvironment() {
            @Override
            protected void customizePropertySources(MutablePropertySources propertySources) {
                System.out.println(environment.getPropertySources());
                Map<String, Object> dubboScanProperties = PropertySourcesUtils.getSubProperties(environment.getPropertySources(), "dubbo.scan.");
                System.out.println(dubboScanProperties);
                propertySources.addLast(new MapPropertySource("dubboScanProperties", dubboScanProperties));
            }
        };
        ConfigurationPropertySources.attach(propertyResolver);
        return new DelegatingPropertyResolver(propertyResolver);
    }

    @ConditionalOnMissingBean(name = "relaxedDubboConfigBinder", value = ConfigurationBeanBinder.class)
    @Bean("relaxedDubboConfigBinder")
    @Scope(scopeName = SCOPE_PROTOTYPE)
    public ConfigurationBeanBinder relaxedDubboConfigBinder() {
        return new BinderDubboConfigBinder();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("DubboAutoConfiguration" );
    }
}
