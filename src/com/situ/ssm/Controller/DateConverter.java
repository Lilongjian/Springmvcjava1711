package com.situ.ssm.Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
			 try {
				 if (null != source) {
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				return format.parse(source);
			 }
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		return null;
	}

}
