package com.dao;

import java.util.ResourceBundle;

public class ResourceBundleReader {
	static ResourceBundle rb = ResourceBundle.getBundle("dbconfig");
	public static String getValue(String key){
		return rb.getString(key);

}
}
