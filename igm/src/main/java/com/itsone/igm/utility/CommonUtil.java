package com.itsone.igm.utility;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultValueProcessor;

public class CommonUtil {
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true; 
		} else if (obj instanceof Date || obj instanceof Integer
				|| obj instanceof Long || obj instanceof Float
				|| obj instanceof Double || obj instanceof Boolean) {
			return false; 
		} else if (obj instanceof String) { 
			return "".equals(((String)obj).trim()) ? true : false;
		} else if(obj instanceof Map) {
			return ((Map)obj).isEmpty(); 
		} else if(obj instanceof List) { 
			for (Object v : ((List)obj)) {
				if(!isEmpty(v)) {return false;}
			}
			return true;
		} else if(obj instanceof Object[]) { 
			for (Object v : ((Object[])obj)) {
				if(!isEmpty(v)) {return false;}
			}
			return true;
		} else {
			Class cls = obj.getClass();
			List<Field> fieldList = new ArrayList<Field>();
			fieldList = getAllFields(cls, fieldList);
			for(Field F : fieldList){
				try {
					if(F.getModifiers() == 1) { if(!isEmpty(F.get(obj))) return false; }
					else if(F.getModifiers() == 2) { if(!isEmpty(getFieldValue(obj, F.getName()))) return false; }
					else if(F.getModifiers() == 18) { if(!isEmpty(getFieldValue(obj, F.getName()))) return false; }
				} catch (Exception e) {}
			}
			return true;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static List<Field> getAllFields(Class cls, List<Field> fields) {
	    fields.addAll(Arrays.asList(cls.getDeclaredFields()));
	    if (cls.getSuperclass() != null) {
	        fields = getAllFields(cls.getSuperclass(), fields);
	    }
	    return fields;
	}
	
	@SuppressWarnings("rawtypes")
	public static Object getFieldValue(Object object, String fieldName) {
		try {
			Class cls = object.getClass();
			HashMap<String, HashMap<String, Object>> classGetterMethods = getClassGetter(cls, null);
			
			if (!CommonUtil.isEmpty(classGetterMethods.get(fieldName.toUpperCase()))) {
				Method method = (Method)classGetterMethods.get(fieldName.toUpperCase()).get("Method");
				method.setAccessible(true);
				Object retObject = method.invoke(object);
				method.setAccessible(false);				
				return retObject; // returnValue != null && returnValue==0)?null:returnValue;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}

	@SuppressWarnings("rawtypes")
	public static HashMap<String, HashMap<String, Object>> getClassGetter(Class cls, HashMap<String, HashMap<String, Object>> methods){
		HashMap<String, HashMap<String, Object>> retMethods = new HashMap<String, HashMap<String, Object>>();
		HashMap<String, Class> fields = new HashMap<String, Class>();
		if (!CommonUtil.isEmpty(methods)) retMethods = methods;
		Method[] methodArr = cls.getMethods();
		Field[] fieldArr = cls.getFields();
		
		for (Field F : fieldArr) { fields.put(F.getName().toUpperCase(), F.getType());}
		for (Method M : methodArr) {
			if (M.getName().startsWith("get")) {
				String FieldName = M.getName().substring(3).toUpperCase();
				HashMap<String, Object> info = new HashMap<String, Object>();
				info.put("Method", M);
				info.put("ParamType", fields.get(FieldName));
				retMethods.put(FieldName, info);
			}
		}
		return retMethods;
	}

	public static HashMap<String, Object> makeParams(Object... objects) {
		
		HashMap<String, Object> params = new HashMap<String, Object>(2);	
		int size = objects.length;
		for (int i = 0; i < size; i += 2) {
			params.put((String)objects[i], CommonUtil.isEmpty(objects[i + 1]) ? null : objects[i + 1]);
		}
		
		return params;
		
	}
	
	public static Map<String, Object> getBrowserInfo(String userAgent) {
		Map<String, Object> map = new HashMap<String, Object>();
		String browserName = "UNKNOWN";
		Integer browserVersion = -1;
		try{
			if (userAgent.indexOf("MSIE") > -1) {
				browserName = "IE";
				String _version = userAgent.substring(userAgent.indexOf("MSIE") + 5);
				_version = _version.substring(0, _version.indexOf("."));
				browserVersion = Integer.valueOf(_version);
			} else {
				if (userAgent.indexOf("Trident") > -1) {
					browserName = "IE";
					String _version = userAgent.substring(userAgent.indexOf("rv:") + 3);
					_version = _version.substring(0, _version.indexOf("."));
					browserVersion = Integer.valueOf(_version);
				} else if(userAgent.indexOf("Opera") > -1) {
					browserName = "Opera";
					String _version = userAgent.substring(userAgent.indexOf("Version") + 8);
					_version = _version.substring(0, _version.indexOf("."));
					browserVersion = Integer.valueOf(_version);
				} else if(userAgent.indexOf("OPR") > -1) {
					browserName = "Opera";
					String _version = userAgent.substring(userAgent.indexOf("OPR") + 4);
					_version = _version.substring(0, _version.indexOf("."));
					browserVersion = Integer.valueOf(_version);
				} else if (userAgent.indexOf("Firefox") > -1) {
					browserName = "Firefox";
					String _version = userAgent.substring(userAgent.indexOf("Firefox") + 8);
					_version = _version.substring(0, _version.indexOf("."));
					browserVersion = Integer.valueOf(_version);
				} else if(userAgent.indexOf("Safari") > -1) {
					if (userAgent.indexOf("Chrome") > -1) {
						browserName = "Chrome";
						String _version = userAgent.substring(userAgent.indexOf("Chrome") + 7);
						_version = _version.substring(0, _version.indexOf("."));
						browserVersion = Integer.valueOf(_version);
					} else {
						browserName = "Safari";
						String _version = userAgent.substring(userAgent.indexOf("Version") + 8);
						_version = _version.substring(0, _version.indexOf("."));
						browserVersion = Integer.valueOf(_version);
					}
				}
			}
			map.put("browserName", browserName);
			map.put("browserVersion", browserVersion);
		} catch(Exception e) {
			System.out.println(userAgent);
			map.put("browserName", "UNKNOWN");
			map.put("browserVersion", -1);
		}
		
		return map;
	}
	
	public static Object parseToJson(Object object) {
		if (object instanceof List || object instanceof Object[]) {
			return JSONArray.fromObject(object, jsonConfig());
		} else {
			return JSONObject.fromObject(object, jsonConfig());
		}
	}
	
	@SuppressWarnings("rawtypes")
	private static JsonConfig jsonConfig() {
		JsonConfig config = new JsonConfig();
		config.registerDefaultValueProcessor(String.class, new DefaultValueProcessor() {
			@Override
			public Object getDefaultValue(Class arg0) {return "";}
		});
		config.registerDefaultValueProcessor(Date.class, new DefaultValueProcessor() {
			@Override
			public Object getDefaultValue(Class arg0) {return "";}
		});
		config.registerDefaultValueProcessor(Integer.class, new DefaultValueProcessor() {
			@Override
			public Object getDefaultValue(Class arg0) {return "";}
		});
		
		return config;
	}
}
