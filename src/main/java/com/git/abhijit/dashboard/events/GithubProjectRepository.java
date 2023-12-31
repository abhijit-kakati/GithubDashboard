package com.git.abhijit.dashboard.events;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GithubProjectRepository extends JpaRepository<GithubProject, Long>{

	GithubProject findByRepoName(String repoName);

}