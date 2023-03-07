package com.group05.abstractbusiness.group04api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.group05.abstractbusiness.group04api.repository.*")
@SpringBootApplication(exclude = (DataSourceAutoConfiguration.class))
public class Group04ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Group04ApiApplication.class, args);
	}

}
