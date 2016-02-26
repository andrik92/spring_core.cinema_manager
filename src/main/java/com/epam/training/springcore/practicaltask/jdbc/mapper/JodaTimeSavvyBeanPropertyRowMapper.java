package com.epam.training.springcore.practicaltask.jdbc.mapper;

import org.joda.time.DateTime;
import org.springframework.beans.BeanWrapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.epam.training.springcore.practicaltask.jdbc.util.JodaDateTimeEditor;

public class JodaTimeSavvyBeanPropertyRowMapper<T> extends BeanPropertyRowMapper<T>{
	
	public JodaTimeSavvyBeanPropertyRowMapper(Class<T> mappedClass) {
		initialize(mappedClass);
	}

	@Override
	protected void initBeanWrapper(BeanWrapper bw) {
		bw.registerCustomEditor(DateTime.class, new JodaDateTimeEditor());
	}
}
