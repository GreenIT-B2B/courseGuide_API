package com.itsone.igm.contr.err;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.google.gson.JsonObject;

@RestControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(RuntimeException.class)
	public Object handleRuntimeExpectedException(Model model, Exception e) {
		logger.info("RuntimeException : " + e.getMessage());
		
		JsonObject retJson = new JsonObject();
		retJson.addProperty("errCd", ResponseType.ERR_000);
		retJson.addProperty("success", ResponseType.FAIL);
        
		return retJson;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
    public Object handleIllegalArgumentException(Model model, Exception e) {
		logger.info("IllegalArgumentException : " + e.getMessage());
		
		JsonObject retJson = new JsonObject();
		retJson.addProperty("errCd", ResponseType.ERR_000);
		retJson.addProperty("success", ResponseType.FAIL);
        
		return retJson;
    }
	
	@ExceptionHandler(InterruptedException.class)
    public Object handleInterruptedException(Model model, Exception e) {
		logger.info("InterruptedException : " + e.getMessage());
		
		JsonObject retJson = new JsonObject();
		retJson.addProperty("errCd", ResponseType.ERR_000);
		retJson.addProperty("success", ResponseType.FAIL);
        
		return retJson;
    }
	
	@ExceptionHandler(ExpectedException.class)
    public Object handleExpectedException(final ExpectedException error) {
		logger.info(" >>> handleExpectedException >>> error : " + error);

		JsonObject retJson = new JsonObject();
		
		String errInfo = error.toString();
		String[] prefix = null;
		if (errInfo != null && errInfo.isEmpty() == false) {
			prefix = errInfo.split(":");
		}
		
		String[] errs = null;
		if (prefix != null && prefix.length > 0) {
			if (prefix.length == 1) {
				errs = prefix[0].trim().split(",");	
			} else if (prefix.length == 2) {
				errs = prefix[1].trim().split(",");
			}
		}
		
		if (errs != null && errs.length > 0) {
			if (errs.length > 3) {
				setJSonMap(retJson, errs);
			} else {
				setJSonMap(retJson, errs);
			}
		} else {
			retJson.addProperty("success", ResponseType.FAIL);	
		}
		
		return retJson;
    }
	
	@ExceptionHandler(ExceptionMessage.class)
    public void handleExceptionMessage(final ExceptionMessage error) {
		logger.info(" >>> handleExceptionMessage >>> error : ", error);
    }
	
	private void setJSonMap(JsonObject retJson, String[] errs) {
		for (int i = 0; i < errs.length; i++) {
			String[] errSub = errs[i].split("=");
			if (errSub.length == 2) {
				retJson.addProperty(errSub[0], errSub[1]);
			} else {
				retJson.addProperty("success", ResponseType.FAIL);
			}
		}
	}
}