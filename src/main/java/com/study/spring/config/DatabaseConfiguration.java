package com.study.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration
@EnableJpaRepositories("com.study.spring.repository")
public class DatabaseConfiguration {

}
