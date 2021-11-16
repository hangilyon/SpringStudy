package com.care.root;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class MyScheduler {
	//@Scheduled(cron="*/10 * * * * *")
	public void testsc() {
		System.out.println("실행");
	}
}
