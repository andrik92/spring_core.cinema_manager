package com.epam.training.springcore.practicaltask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.epam.training.springcore.practicaltask.aspect.CounterAspect;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AspectConfig {

	@Bean
	public CounterAspect counterAspect(){
		return new CounterAspect();
	}
}
