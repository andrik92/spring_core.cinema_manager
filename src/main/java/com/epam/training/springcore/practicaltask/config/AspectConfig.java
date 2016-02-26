package com.epam.training.springcore.practicaltask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.epam.training.springcore.practicaltask.aspect.CounterAspect;
import com.epam.training.springcore.practicaltask.aspect.DiscountAspect;
import com.epam.training.springcore.practicaltask.aspect.LuckyWinnerAspect;

@Configuration
@EnableAspectJAutoProxy
//@ComponentScan
public class AspectConfig {

	@Bean
	public CounterAspect counterAspect() {
		return new CounterAspect();
	}

	@Bean
	public DiscountAspect discountAspect() {
		return new DiscountAspect();
	}

	@Bean
	public LuckyWinnerAspect luckyWinnerAspect() {
		return new LuckyWinnerAspect();
	}
}
