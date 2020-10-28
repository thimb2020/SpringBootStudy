package com.study.spring.service.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.quartz.*;
@Service
public class JobService {
	@Autowired
    private Scheduler scheduler;
	
	public void testJob() {
        JobDetail jd =  JobBuilder.newJob(PrintRandomJob.class).withIdentity(JobKey.jobKey("abc")).storeDurably()
                .build();
        String cronValue =	generateCronExpression("0", "58","9");
        Trigger trigger = TriggerBuilder.newTrigger().forJob(jd)
                .withIdentity(TriggerKey.triggerKey("abc"))
                .withSchedule(CronScheduleBuilder.cronSchedule(cronValue)).build();
        try {
			scheduler.scheduleJob(jd,trigger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static String generateCronExpression(final String seconds, final String minutes, final String hours) {
        return String.format("%1$s %2$s %3$s %4$s %5$s %6$s %7$s", seconds, minutes, hours, "*", "*","?", "*");
    }

}
