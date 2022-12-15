package com.itsone.igm.helper;

import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

import com.itsone.igm.define.Define;

public class SysHelper {
	private final String TAG = this.getClass().getSimpleName();

	private static volatile SysHelper instance;
	private SysHelper() {}
	public static SysHelper inst() {
		if (instance == null) { instance = new SysHelper(); }
		return instance;
	}
	
//	public int exeMode = Define.Pref.EXE_MODE_LIVE;
//	public int exeMode = Define.Pref.EXE_MODE_QA;
	public int exeMode = Define.Pref.EXE_MODE_DEV;
	
	public boolean isLog = false; // QA
	
	public void setExeMode() {
		switch(exeMode) {
			case Define.Pref.EXE_MODE_DEV:
				break;
			case Define.Pref.EXE_MODE_QA:
				break;
			case Define.Pref.EXE_MODE_EX:
				break;
			case Define.Pref.EXE_MODE_LIVE:
				break;
		}
	}
	
	// 아이피 주소 가져오기
	public String getLocalIpAddr() {
    	InetAddress local;
		try {
		    local = InetAddress.getLocalHost();
		    return local.getHostAddress();
		} catch (UnknownHostException e1) {
		    e1.printStackTrace();
		}
		
		return "";
    }
	
	// 프로퍼티 셋팅 정보 가져오기
	public String getProperties(String key, String defaultValue) {
    	String retVal = null;
        
        try {
            String propFile = new ClassPathResource("globals.properties").getURI().getPath();

            Properties props = new Properties();
            FileInputStream fis = new FileInputStream(propFile);
            props.load(new java.io.BufferedInputStream(fis));           
            
            retVal = props.getProperty(key) ;
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return retVal == null? defaultValue : retVal;
    }
	
	// 확장자 정보 가져오기
	public String getExtension(String fileName) {
    	try {
    		return fileName.substring(fileName.lastIndexOf(".") + 1);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return "";
    }
}
