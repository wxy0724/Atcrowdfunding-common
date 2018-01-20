package com.atguigu.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.Map;

public class BaseController {
	private ThreadLocal<Map<String, Object>> datas = new ThreadLocal<>();

	protected void start() {
		Map<String, Object> resultMap = new HashMap<>();
		datas.set(resultMap);
	}
	
	protected Object end() {
		Map<String, Object> resultMap = datas.get();
		datas.remove();
		return resultMap;
	}
	
	protected void success(boolean flag) {
		Map<String, Object> resultMap = datas.get();
		resultMap.put("success", flag);
	}
	
	protected void param(String key,Object val) {
		Map<String, Object>resultMap = datas.get();
		resultMap.put(key, val);
	}
	
	public void error(String msg) {
		Map<String, Object>resultMap = datas.get();
		resultMap.put("error", msg);
	}

}

