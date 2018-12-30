<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"         prefix="struts"   %>
<%@ taglib uri="/struts-dojo-tags"    prefix="sx"       %>

<%@ page import="java.io.File" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>

<%@ page import="org.apache.struts2.json.JSONUtil" %>

<%

  System.out.println("testttt");
  
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");
  
  out.clear();  // 清空所有輸出

  // 將傳送的資料反序列化
  @SuppressWarnings("all")
  Map<String,Object> map = (Map<String,Object>) JSONUtil.deserialize("data");
  System.out.println("map size = "+map.size());
  
  
  @SuppressWarnings("all")
  String objectId = (String)((Map<String,Object>)map.get("node")).get("objectId"); 
  System.out.println("objectId = "+objectId);
  
  
  
  File file = new File(objectId);      // 要展開的檔案
  File [] children = file.listFiles(); // 所有子檔案
  
  
  // 查詢結果
  List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
  
  
  // 先列出資料夾
  for(int i = 0; children != null && i < children.length; i++){
  
    if(children[i].isFile()){ continue; }     // 如果是檔案，則跳過
    
    Map<String,Object> entry = new HashMap<String,Object>();
    entry.put("title",children[i].getName());
    entry.put("isFolder",children[i].isDirectory());
    entry.put("id",children[i].getName());
    entry.put("objectId",children[i].getAbsolutePath());
    
    result.add(entry);  // 放到查詢結果中
  } // end for(int i = 0; children != null && i < children.length; i++){




  // 先列出檔案
  for(int i = 0; children != null && i < children.length; i++){
  
    if(children[i].isDirectory()){ continue; }  // 如果是資料夾，則跳過
    
    Map<String,Object> entry = new HashMap<String,Object>();
    entry.put("title",children[i].getName());
    entry.put("isFolder",children[i].isDirectory());
    entry.put("id",children[i].getName());
    entry.put("objectId",children[i].getAbsolutePath());
    
    result.add(entry);  // 放到查詢結果中
  } // end for(int i = 0; children != null && i < children.length; i++){
  
  
  
  out.println(JSONUtil.serialize(result));
  
  
  System.out.println();
  System.out.println(JSONUtil.serialize(result));
  System.out.println();

%>