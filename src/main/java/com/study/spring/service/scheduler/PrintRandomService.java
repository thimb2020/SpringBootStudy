package com.study.spring.service.scheduler;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

@Service
public class PrintRandomService {

    
	public void printRandom() {
        System.out.println(ThreadLocalRandom.current().nextInt());
    }
}