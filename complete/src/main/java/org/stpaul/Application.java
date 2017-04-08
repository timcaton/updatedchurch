package org.stpaul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@EnableAsync
@EnableAutoConfiguration(exclude = MustacheAutoConfiguration.class)
public class Application extends SpringBootServletInitializer {
    private static boolean EXIT_AFTER_START = false;


    public static void main(String[] args){
        start(args);
    }

    public static ConfigurableApplicationContext start(String[] args){
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        if (EXIT_AFTER_START){
            applicationContext.stop();
        }
        return applicationContext;
    }

}
