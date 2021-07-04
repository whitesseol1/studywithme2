package com.commons;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

//양방향암호화 지원하는 클래스
//양방향 암호화처리 클래스는 기본 java api에서 제공하고 있음.
//javax.crypto패키지, java.security패키지에 구성되어있음.


//key관리가 중요함! key는 프로젝트에서 한개만 있어야함.  //resources(driver,sql property)는 ignore처리해서 올리기
public class AESCryptor1 {
	
	private static SecretKey key; //암호화를 위한 키
	private String path;//파일로 저장된 암호화키의 위치
	
	
	public AESCryptor1() {
		//클래스가 인스턴스화될때(생성) 기본설정을 해줘야함.
		//1. key파일이 있으면 key파일에서 SecretKey객체를 불러오고
		//   없으면 SecretKey객체를 생성하여 파일로 저장
		this.path=AESCryptor1.class.getResource("/").getPath();
		System.out.println(path);
		this.path=this.path.substring(0,this.path.indexOf("classes"));
		System.out.println(path);
		File f=new File(this.path+"keyfile");
		//key를 저장하고 있는 파일이름이 bslove.bs -> SecretKey객체가 저장되어 있음
		if(f.exists()) {
			//key를 저장하는 파일이 있으면..?
			try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));){
				
				this.key=(SecretKey)ois.readObject();
				
			}catch(IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
		}else {
			//SecretKey를 생성
			if(key==null) {
				getGenerator();//key값을 생성하는 매소드
			}
		}
		
			
	}//생성자닫기
	
	private void getGenerator() {
		//secretKey를 생성하는 매소드
		SecureRandom ser=new SecureRandom();
		//key를 생성해주는 클래스
		KeyGenerator keygen=null;
		try {
			
			//키생성을 위한 기본값 세팅하기
			//1. 적용할 알고리즘 AES -> 키가 한개, RSA -> 키가 두개 생성(공개키, 개인키)
			keygen=KeyGenerator.getInstance("AES");
			//키값생성 초기화
			keygen.init(128, ser); //비트, sort값
			this.key=keygen.generateKey();
			
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//생성된 키객체를 정해진 경로에 파일로 저장하자.
		File f=new File(this.path+"/keyfile");
		try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));){
			
			oos.writeObject(this.key);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//암호화처리하기
	public static String encrypt(String str) 
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
	               BadPaddingException, IllegalBlockSizeException
	{
		
		//key를 가지고 암호화 처리하는 클래스가 있음
		//Cipher
		Cipher cipher=Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, AESCryptor1.key);
		
		//매개변수로 넘어온 값 암호화처리하기
		byte[] encrypt=str.getBytes(Charset.forName("utf-8"));
		byte[] result=cipher.doFinal(encrypt);
		String resultValue=Base64.getEncoder().encodeToString(result);
		return resultValue;
		
	}
	
	//생성된 키를 가지고 복호화(원본값변경)하는 매소드
	public static String decrypt(String encryptedStr) 
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
	               BadPaddingException, IllegalBlockSizeException
	{
		
		//key를 가지고 암호화 처리하는 클래스가 있음
		//Cipher
		Cipher cipher=Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, AESCryptor1.key);
		
		//매개변수로 넘어온 값 암호화처리하기
	    byte[] decodeStr=Base64.getDecoder().decode(encryptedStr.getBytes(Charset.forName("utf-8")));
	    byte[] oriVal=cipher.doFinal(decodeStr);//복호화됨.
	    
		return new String(oriVal);
		
	}
	

}

