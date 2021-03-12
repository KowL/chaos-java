package org.chaos.dubbo.spring.boot;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: lijun
 * @Description:
 * @Date: Created in 2020-12-09 10:11
 * @Modified By:
 */
@Configuration
public class EnableDubboConfiguration implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("EnableDubboConfiguration" );
    }
}
