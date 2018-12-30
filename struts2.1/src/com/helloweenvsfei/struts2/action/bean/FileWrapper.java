package com.helloweenvsfei.struts2.action.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;



public class FileWrapper {

  private File file;
  private List <FileWrapper> children = new ArrayList<FileWrapper>();
  
  
  // 帶參數的建構子
  public FileWrapper(File f){  
	this.file = f;
	File [] files = this.file.listFiles();

	for(int i=0; files != null && i < files.length;i++){
      System.out.println("i = "+i+", file path = "+files[i]);
      
      FileWrapper wrapper = new FileWrapper(files[i]);  // 自己呼叫自己(遞迴)
      children.add(wrapper);
	} // end for(int i=0; files!=null && i<files.length;i++){
	
  } // end public FileWrapper(File f)

  
  
  public File getFile() {
	return file;
  }

  public void setFile(File file) {
	this.file = file;
  }

  public List<FileWrapper> getChildren() {
	return children;
  }

  public void setChildren(List<FileWrapper> children) {
	this.children = children;
  }
   	
}
