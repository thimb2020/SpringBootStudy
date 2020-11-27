package com.study.spring.service.scheduler.Scheduler;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {
	@Scheduled(cron = "0 * * * * *")
	public void printRandom() {
        System.out.println("Mot phut chay 1 lan");
    }

}
