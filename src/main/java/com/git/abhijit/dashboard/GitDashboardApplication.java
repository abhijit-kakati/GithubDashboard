package com.git.abhijit.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(GithubProperties.class)
public class GitDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitDashboardApplication.class, args);
	}

}
