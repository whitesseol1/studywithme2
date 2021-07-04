package com.commons.filter;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class PasswordEncryptWrapper extends HttpServletRequestWrapper {

	
	public PasswordEncryptWrapper(HttpServletRequest request) {
		super(request);
				
	}
	
	//getParameter로 password값을 호출하면 암호화해서 전송하기
	@Override
	public String getParameter(String name) {
		String value="";
		//매개변수 name의 값이 password일때 암호화처리하자
 		if(name.equals("password")||name.equals("password_new")) {
 			//암호화시켜서 반환하자!
 			System.out.println("암호화전 : "+super.getParameter(name));
 			value=getSHA512(super.getParameter(name));
 			System.out.println("암호화후 : "+value);
 			
 		}else {
 			value=super.getParameter(name);
 		}
		
		
		return value;
		
	}
	
	private String getSHA512(String val) {
		
		String encPwd="";
		//암호화처리객체 선언
		MessageDigest md=null;
		try {
			//암호화알고리즘을 선택해서 객체 생성
			md=MessageDigest.getInstance("SHA-512");
			
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//암호화는 bit연산
		
		
			byte[] bytes=val.getBytes(Charset.forName("UTF-8"));
			md.update(bytes);
		
			//bit연산한것을 String값변환을 해야함.
			encPwd=Base64.getEncoder().encodeToString(md.digest());
		    return encPwd;
		
		
		
	}
	
	
	
	
	
}

