package com.git.abhijit.dashboard;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("github")
public class GithubProperties {
	
	/**
	 * Github API token ("user: sampletoken")
	 */
		
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
