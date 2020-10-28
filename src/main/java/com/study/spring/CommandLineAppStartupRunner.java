package com.study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.study.spring.service.scheduler.JobService;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
	@Autowired
	private JobService jobService;

	@Override
	public void run(String... args) throws Exception {
		jobService.testJob();

	}
}
