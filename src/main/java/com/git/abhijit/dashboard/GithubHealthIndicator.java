package com.git.abhijit.dashboard;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.git.abhijit.dashboard.github.GithubClient;
import com.git.abhijit.dashboard.github.RepositoryEvent;

@Component
public class GithubHealthIndicator implements HealthIndicator{

	private final GithubClient githubClient;
	
	public GithubHealthIndicator(GithubClient githubClient) {
		this.githubClient = githubClient;
	}
	
	@Override
	public Health health() {
		try {
			ResponseEntity<RepositoryEvent[]> response = githubClient.fetchEvents("spring-boot", "spring-boot");
			
			if(response.getStatusCode().is2xxSuccessful()) {
				return Health.up().build();
			}
			else {
				return Health.down().build();
			}
		} catch (Exception e) {
			return Health.down(e).build();
		}
	}

}
