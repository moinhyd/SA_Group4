package com.counterA.counterA;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class CounterAApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterAApplication.class, args);
	}

	@EventListener
	public void handleContextStart(ApplicationReadyEvent cse) {
		System.out.println("Counter-A is UP.");
	}

	@PreDestroy
	public void handleBeforeExit() throws IOException, TimeoutException {
		System.out.println("Counter A is going down. Informing Customer C.");
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare("messageXtoC",
				true,
				false,
				false,
				null);
		String message = "Counter-A is Down.";
		channel.basicPublish("",
				"messageXtoC",
				null,
				message.getBytes("UTF-8"));
	}


}
