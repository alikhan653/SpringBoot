package kz.iitu.spring.SpringBoot.config;

import kz.iitu.spring.SpringBoot.beans.SecondBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public SecondBean secondBean(){
        return new SecondBean();
    }

    @Bean
    public SecondBean theSecondBean(){
        return new SecondBean("Alikhan",31);
    }
}
