package com.southwind.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.southwind.entity.JsonTest;

public class JsonforTest {
	public static void main(String[] args) {
		//将JSON字符串转化成对象时，会去填充名称相同的属性，对于JSON字符串中有，而Test类没有的属性，会为null；
		//将对象转化成JSON字符串时，对于JSON字符串有，但是Test类没有的，不做任何处理。
		
		 //haha是Test类没有的
		String jsonString = "{name:'hqz',age:'18',sex:'male',haha:'sd'}";
		String jsonString1 ="{'age':'18','name':'hqz','sex':'male'}";
		 /**
         * JSON字符串转化成自己的实体类对象 test
         */
		JsonTest test = JSONObject.parseObject(jsonString1, JsonTest.class);
		System.out.println(test);
//		String jsonStr = JSON.toJSONString(test);
//		System.out.println(jsonStr);
		test = JSONObject.parseObject(test.getName(), JsonTest.class);
		System.out.println(test);
		/**
         * 对象转化成JSON 字符串
         */
		
	}
}
