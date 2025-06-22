package com.pingan.dispatcherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class DispatcherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DispatcherServiceApplication.class, args);

    }

}
