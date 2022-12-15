package com.itsone.igm.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.codec.Hex;

public class TokenUtil {

	  public static final String TOKEN_KEY = "auto_login_token";

	  public static String createToken(String loginCd) {

		  // 인증토크 유효시간.
		  long expires = System.currentTimeMillis() + 1000L * 60 * 10; // 10분 자동 로그인 허용

		  StringBuilder tokenBuilder = new StringBuilder();
		  tokenBuilder.append(loginCd);
		  tokenBuilder.append(":");
		  tokenBuilder.append(expires);
		  tokenBuilder.append(":");
		  tokenBuilder.append(TokenUtil.computeSignature(loginCd, expires));

		  return tokenBuilder.toString();
	  }

	  public static String computeSignature(String loginCd, long expires) {
		  StringBuilder signatureBuilder = new StringBuilder();
		  signatureBuilder.append(loginCd);
		  signatureBuilder.append(":");
		  signatureBuilder.append(expires);
		  signatureBuilder.append(":");
		  signatureBuilder.append(TokenUtil.TOKEN_KEY);

		  MessageDigest digest;
		  try {
			  digest = MessageDigest.getInstance("SHA-256");
		  } catch (NoSuchAlgorithmException e) {
			  throw new IllegalStateException("No SHA-256 algorithm available!");
		  }

		  return new String(Hex.encode(digest.digest(signatureBuilder.toString().getBytes())));
	  }

	  public static String getCompIdFromToken(String authToken) {
		  if (null == authToken) {
			  return null;
		  }

		  String[] parts = authToken.split(":");
		  return parts[0];
	  }
	 
	  public static boolean validateToken(String authToken, String loginCd) {
		  String[] parts = authToken.split(":");
		  long expires = Long.parseLong(parts[1]);
		  String signature = parts[2];

		  if (expires < System.currentTimeMillis()) {
			  return false;
		  }

		  return signature.equals(TokenUtil.computeSignature(loginCd, expires));
	  }
}