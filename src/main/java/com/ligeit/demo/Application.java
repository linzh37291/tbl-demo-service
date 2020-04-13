package com.ligeit.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@ComponentScan("com.ligeit.demo")
@Slf4j
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean("httpClient")
    public RestTemplate httpClientRestTemplate(){
      RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
      return restTemplate;
    }
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("tbl-demo-service 启动成功......");
    }
    
}
