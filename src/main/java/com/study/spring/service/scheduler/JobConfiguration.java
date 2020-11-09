package com.study.spring.service.scheduler;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.context.annotation.Bean;
import com.study.spring.utils.CommonUtils;

//@Configuration
public class JobConfiguration {

	@Bean
	public JobDetail printRandomJobDetail() {
		return JobBuilder.newJob(PrintRandomJob.class).withIdentity(JobKey.jobKey("printRandom")).storeDurably()
				.build();
	}
	@Bean
	public Trigger printRandomJobTrigger() {
		String cronValue = CommonUtils.generateCronExpression("0", "49","14");

		return TriggerBuilder.newTrigger().forJob(printRandomJobDetail())
				.withIdentity(TriggerKey.triggerKey("printRandom"))
				.withSchedule(CronScheduleBuilder.cronSchedule(cronValue)).build();		
	}
}