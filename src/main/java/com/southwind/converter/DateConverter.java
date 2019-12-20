package com.southwind.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String,Date> {

	private String pattern;
	
    public DateConverter(String pattern) {
		// TODO Auto-generated constructor stub
    	this.pattern = pattern;
	}
	
	@Override
	public Date convert(String s) {
		// TODO Auto-generated method stub
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = null;	
			try {
				date = simpleDateFormat.parse(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return date;
	}
	
	
}
