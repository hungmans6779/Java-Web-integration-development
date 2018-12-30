package com.helloweenvsfei.function;

import java.util.Collection;

public class Function {

	public Function() {
		// TODO Auto-generated constructor stub
	}

	
	public static int length(Object obj){
	
		if(obj==null){
		  return 0;	
		}else if(obj instanceof StringBuffer){
	      // 傳回字串長度
		  return length(((StringBuffer)obj).toString());
		}else if(obj instanceof String){
		  return ((String)obj).getBytes().length;	
		}else if (obj instanceof Collection){
	      return ((Collection)obj).size();
		}else{
		  return 0;
		}
	}
	
	
	
	public static String substring(String str,int byteLength){
		
		if(str==null){return ""; }
		
		StringBuffer buffer=new StringBuffer();
		
		for(int i=0;i<str.length();i++){
	      char ch=str.charAt(i);
	      
	      if(length(buffer.toString()+ch) > byteLength ){
	    	break;  
	      }else{
	    	buffer.append(ch);  
	      }
		} // end for(int i=0;i<str.length();i++){
		
		return buffer.toString();
	}
	
	
	
	
}
