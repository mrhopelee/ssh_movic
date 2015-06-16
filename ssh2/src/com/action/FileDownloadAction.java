package com.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String fileName;// 初始的通过param指定的文件名属性   
	 
	 public void setFileName(String fileName) {   
		  
	        this.fileName = fileName;   
	  
	    }   

	  
	    /** 提供转换编码后的供下载用的文件名 */   
	  
	    public String getDownloadFileName() {   
	  
	        String downFileName = fileName;   
	  
	        try {   
	  
	            downFileName = new String(downFileName.getBytes(), "ISO8859-1");   
	  
	        } catch (UnsupportedEncodingException e) {   
	  
	            e.printStackTrace();   
	        }  
	        return downFileName;  
	    }   
	 
	 
	 public InputStream getInputStream() throws Exception {   
		
	        return ServletActionContext.getServletContext().getResourceAsStream(fileName);
	   
	    }   
	 public String execute() throws Exception {   
		 System.out.println("将要下载"+fileName);
		  
	        return SUCCESS;   
	  
	    } 
	
	  
}
