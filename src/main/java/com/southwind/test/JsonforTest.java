package com.southwind.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.southwind.entity.JsonTest;

public class JsonforTest {
	public static void main(String[] args) {
		//��JSON�ַ���ת���ɶ���ʱ����ȥ���������ͬ�����ԣ�����JSON�ַ������У���Test��û�е����ԣ���Ϊnull��
		//������ת����JSON�ַ���ʱ������JSON�ַ����У�����Test��û�еģ������κδ���
		
		 //haha��Test��û�е�
		String jsonString = "{name:'hqz',age:'18',sex:'male',haha:'sd'}";
		String jsonString1 ="{'age':'18','name':'hqz','sex':'male'}";
		 /**
         * JSON�ַ���ת�����Լ���ʵ������� test
         */
		JsonTest test = JSONObject.parseObject(jsonString1, JsonTest.class);
		System.out.println(test);
//		String jsonStr = JSON.toJSONString(test);
//		System.out.println(jsonStr);
		test = JSONObject.parseObject(test.getName(), JsonTest.class);
		System.out.println(test);
		/**
         * ����ת����JSON �ַ���
         */
		
	}
}
