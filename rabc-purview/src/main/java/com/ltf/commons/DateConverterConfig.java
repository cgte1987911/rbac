package com.ltf.commons;

import com.ltf.exception.ParamException;
import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 全局handler前日期统一处理
 */

public class DateConverterConfig implements Converter<String, Date> {

	private static final List<String> FORMARTS = new ArrayList<>(4);
	static {
		FORMARTS.add("yyyy*MM");
		FORMARTS.add("yyyy-MM-dd");
		FORMARTS.add("yyyy-MM-dd hh:mm");
		FORMARTS.add("yyyy-MM-dd hh:mm:ss");
	}

	@Override
	public Date convert(String source) {
		String value = source.trim();
		if ("".equals(value)) {
			return null;
		}

		if (source.matches("^\\d{4}\\*\\d{1,2}$")) {
			return parseDate(source, FORMARTS.get(0));
		} else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
			return parseDate(source, FORMARTS.get(1));
		} else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
			return parseDate(source, FORMARTS.get(2));
		} else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
			return parseDate(source, FORMARTS.get(3));
		} else {
			throw new ParamException("Invalid boolean value '" + source + "'");
		}
	}

	/**
	 * 格式化日期
	 * 
	 * @param dateStr
	 *            String 字符型日期
	 * @param format
	 *            String 格式
	 * @return Date 日期
	 */
	public Date parseDate(String dateStr, String format) {
		Date date = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat(format);
			date = dateFormat.parse(dateStr);
		} catch (Exception e) {

		}
		return date;
	}

}
