package com.study.spring;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.study.spring.service.async.AsyncService;
import com.study.spring.service.async.User;
import com.study.spring.service.scheduler.JobService;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);
	@Autowired
	private JobService jobService;

	@Autowired
	private AsyncService asynService;

	@Override
	public void run(String... args) throws Exception {
		// jobService.testJob();
		asynService.asyncMethodWithVoidReturnType();

		// Start the clock
		long start = System.currentTimeMillis();

		// Kick of multiple, asynchronous lookups
		CompletableFuture<User> page1 = asynService.findUser("mojombo");
		CompletableFuture<User> page2 = asynService.findUser("defunkt");
		CompletableFuture<User> page3 = asynService.findUser("pjhyett");
		CompletableFuture<User> page4 = asynService.findUser("wycats");
		// Wait until they are all done
		CompletableFuture.allOf(page1, page2, page3, page4).join();

		// Print results, including elapsed time
		logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
		logger.info("--> " + page1.get());
		logger.info("--> " + page2.get());
		logger.info("--> " + page3.get());
		logger.info("--> " + page4.get());

	}
}
