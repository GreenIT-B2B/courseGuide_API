package com.itsone.igm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itsone.igm.helper.SysHelper;

@SpringBootApplication
public class IgmSetAppApplication {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(IgmSetAppApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(IgmSetAppApplication.class, args);
		
		SysHelper.inst().setExeMode();
	}
}