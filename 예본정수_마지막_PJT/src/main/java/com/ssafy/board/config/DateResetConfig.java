//package com.ssafy.board.config;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//@SpringBootApplication
//@EnableScheduling
//public class DateResetConfig {
//public static void main(String[] args) {
//	SpringApplication.run(DateResetConfig.class, args);
//}
//}

//@Component
//class reset{
//	
//	 @Scheduled(cron = "0 0 0 * * SUN")
//	    public void resetData() {
//	        System.out.println("Running data reset task...");
//	        
//	    }
//	 
////	  @Scheduled(fixedRate = 60000) //테스트
////	    public void fixedRateTask() {
////	        System.out.println("Running fixed rate task...");
////	        // 고정된 간격으로 수행할 작업 로직 추가
////	    }
//}