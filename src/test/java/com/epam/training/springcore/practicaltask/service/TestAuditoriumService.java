package com.epam.training.springcore.practicaltask.service;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.epam.training.springcore.practicaltask.entity.Auditorium;

@ContextConfiguration("classpath:spring.xml")
public class TestAuditoriumService extends AbstractJUnit4SpringContextTests {

	@Test
	public void testAuditoriumServiceIsDefinedAsBean() {
		boolean contains = applicationContext.containsBean("auditoriumService");
		Assert.assertTrue(contains);
	}

	@Test
	public void testSomeAuditoriums() {
		AuditoriumService service = applicationContext
				.getBean(AuditoriumService.class);

		Set<Auditorium> auditoriums = service.getAll();
		Assert.assertNotNull(auditoriums);
		Assert.assertFalse(auditoriums.isEmpty());

		for (Auditorium auditorium : auditoriums) {
			Auditorium a = service.getByName(auditorium.getName());
			Assert.assertNotNull(a);
		}

		Auditorium a = service.getByName("000");
		Assert.assertNull(a);
	}

}