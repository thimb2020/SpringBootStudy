package com.study.spring.service.scheduler;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SampleJob extends QuartzJobBean {

	private JobService JobService;

	private String name;

	// Inject "MyService" bean
	public void setMyService(JobService JobService) {

	}

	// Inject the "name" job data property
	public void setName(String name) {

	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
	}
}