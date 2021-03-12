package org.chaos.dubbo.demo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ProviderApplication.class, args);
    }

//    @Configuration
//    @EnableDubbo(scanBasePackages = "org.apache.dubbo.demo.provider")
//    @PropertySource("classpath:/spring/dubbo-provider.properties")
//    static class ProviderConfiguration {
//        @Bean
//        public RegistryConfig registryConfig() {
//            RegistryConfig registryConfig = new RegistryConfig();
//            registryConfig.setAddress("zookeeper://127.0.0.1:2181");
//            return registryConfig;
//        }
//    }
}
