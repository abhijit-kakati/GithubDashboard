package com.git.abhijit.dashboard.events;

import java.util.List;

import com.git.abhijit.dashboard.github.RepositoryEvent;

public class DashboardEntries {

	private final GithubProject project;
	
	public DashboardEntries(GithubProject project, List<RepositoryEvent> events) {
		super();
		this.project = project;
		this.events = events;
	}

	private final List<RepositoryEvent> events;

	public GithubProject getProject() {
		return project;
	}

	public List<RepositoryEvent> getEvents() {
		return events;
	}
	
	
}
