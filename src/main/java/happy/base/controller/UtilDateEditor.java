package happy.base.controller;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDateEditor extends PropertyEditorSupport {
	
	/**
	 * 只当页面使用spring绑定标签时才会调用
	 * <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	 * <form:input path="ts"/>
	 */
	public String getAsText() {
		Date value = (Date) getValue();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return value == null ? "" : df.format(value);
	}

	public void setAsText(String text) throws IllegalArgumentException {
		Date value = null;
		if (text != null && !text.equals("")) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				value = df.parse(text);
			} catch (ParseException e) {
				try {
					df = new SimpleDateFormat("yyyy-MM-dd");
					value = df.parse(text);
				} catch (Exception e1) {
					e.printStackTrace();
				}
			}
		}
		setValue(value);
	}
}
