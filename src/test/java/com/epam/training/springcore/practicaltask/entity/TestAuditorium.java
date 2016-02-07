package com.epam.training.springcore.practicaltask.entity;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

public class TestAuditorium {

	@Test(expected = IllegalArgumentException.class)
	public void testCreationNoName() {
		Properties props = new Properties();
		props.put("numberOfSeats", "10");
		new Auditorium(props);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreationNoSeats() {
		Properties props = new Properties();
		props.put("name", "aaa");
		new Auditorium(props);
	}

	@Test
	public void testCreationNoVips() {
		Properties props = new Properties();
		props.put("name", "aaa");
		props.put("numberOfSeats", "10");

		Auditorium a = new Auditorium(props);

		Assert.assertEquals("aaa", a.getName());
		Assert.assertEquals(10, a.getNumberOfSeats());
		Assert.assertNotNull(a.getVipSeats());
		Assert.assertTrue(a.getVipSeats().isEmpty());
	}

	@Test
	public void testCreationVips() {
		Properties props = new Properties();
		props.put("name", "aaa");
		props.put("numberOfSeats", "10");
		props.put("vip", "1,2,3");

		Auditorium a = new Auditorium(props);

		Assert.assertEquals("aaa", a.getName());
		Assert.assertEquals(10, a.getNumberOfSeats());
		Assert.assertNotNull(a.getVipSeats());
		Assert.assertEquals(3, a.getVipSeats().size());
		Assert.assertTrue(a.getVipSeats().contains(1));
		Assert.assertTrue(a.getVipSeats().contains(2));
		Assert.assertTrue(a.getVipSeats().contains(3));
	}

}
