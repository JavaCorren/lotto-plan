package com.example.lotto.plan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LottoPlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(LottoPlanApplication.class, args);
	}

//    @Bean
//    public TaskScheduler taskScheduler(){
//        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
//        taskScheduler.setPoolSize(5);
//        taskScheduler.initialize();
//        return taskScheduler;
//    }
}
