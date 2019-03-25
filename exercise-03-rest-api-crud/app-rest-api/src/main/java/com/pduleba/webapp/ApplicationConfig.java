package com.pduleba.webapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.pduleba.webapp.dao", "com.pduleba.webapp.resource"})
@Configuration
public class ApplicationConfig {


}
