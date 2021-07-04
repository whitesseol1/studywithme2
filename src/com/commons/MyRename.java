package com.commons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyRename implements FileRenamePolicy{

	@Override
	public  File rename(File oldFile) {
		
		File newFile=null;
		do  {
			//리네임 규칙설정하기!
			//절대로 중복되지 않는 값으로 설정
			long currentTime=System.currentTimeMillis();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			int rndNum=(int)(Math.random()*1000+1);
			String oriName=oldFile.getName();//확장자를 포함한 파일명을 반환
			//파일명에서 확장자 빼내오기
			String ext="";
			int dot=oriName.lastIndexOf(".");
			if(dot!=-1) {
				ext=oriName.substring(dot);
			}
			//새이름으로 설정하기
			String newName=sdf.format(new Date(currentTime))+"_"+rndNum+ext;
			newFile=new File(oldFile.getParent(),newName);
						
		}while(!createNewFile(newFile));
		
		return newFile;
		
		
	}
	private boolean createNewFile(File newFile) {
		
		try {
			return newFile.createNewFile();
			
		}catch(IOException e) {
			return false;
		}
		
	}
	
	
	
}
