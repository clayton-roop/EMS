package com.nttdata.ems;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Slf4j
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages ="com.nttdata.ems")
public class Application {

	//logging
	static final Logger logger  = LogManager.getLogger(Application.class.getName());
	
	public static void main(String[] args) {
		logger.info("entered application");
		SpringApplication.run(Application.class, args);

	}

}
