package com.study.spring;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.study.spring.service.scheduler.JobService;
import com.study.spring.service.scheduler.PrintRandomJob;

@SpringBootApplication
public class StudyApplication {
	@Autowired
	private JobService jobService;
	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
		/*
		 * JobDetail jd =
		 * JobBuilder.newJob(PrintRandomJob.class).withIdentity(JobKey.jobKey("abc")).
		 * storeDurably() .build(); String cronValue = generateCronExpression("30",
		 * "04","16"); TriggerBuilder.newTrigger().forJob(jd)
		 * .withIdentity(TriggerKey.triggerKey("a"))
		 * .withSchedule(CronScheduleBuilder.cronSchedule(cronValue)).build()
		 */;
	}
	
    public static String generateCronExpression(final String seconds, final String minutes, final String hours) {
        return String.format("%1$s %2$s %3$s %4$s %5$s %6$s %7$s", seconds, minutes, hours, "*", "*","?", "*");
    }

}
