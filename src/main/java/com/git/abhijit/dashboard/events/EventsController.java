package com.git.abhijit.dashboard.events;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.git.abhijit.dashboard.github.GithubClient;
import com.git.abhijit.dashboard.github.RepositoryEvent;

@Controller
public class EventsController {

	private final GithubProjectRepository repository;
	
	private final GithubClient githubClient;		
	
	public EventsController(GithubProjectRepository repository, GithubClient githubClient) {
		super();
		this.repository = repository;
		this.githubClient = githubClient;
	}

	@GetMapping("/events/{repoName}")
	@ResponseBody
	public RepositoryEvent[] fetchEvents(@PathVariable String repoName) {
		GithubProject project = this.repository.findByRepoName(repoName);
		
		return this.githubClient.fetchEvents(project.getOrgName(), project.getRepoName()).getBody();
	}
	
	@GetMapping("/")
	public String dashboard(Model model) {
		
		Iterable<GithubProject> projects = this.repository.findAll();
		
		List<DashboardEntries> entries = StreamSupport.stream(projects.spliterator(), true)
				.map(p -> new DashboardEntries(p, this.githubClient.fetchEventsList(p.getOrgName(), p.getRepoName())))
				.collect(Collectors.toList());
		model.addAttribute("entries", entries);
		
		return "dashboard";
	}

}
