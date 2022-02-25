package com.example.ws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.example.ws.bean.UserResponse;

@Controller
@EnableScheduling
public class SchedulerConfig {

	@Autowired
	SimpMessagingTemplate messagingTemplate;

	@Scheduled(fixedDelay = 5000 )
	public void sendAdhocMessage() {

		messagingTemplate.convertAndSend("/topic/user",
				new UserResponse("Please enter name and click on send if you need"));
	}

}
