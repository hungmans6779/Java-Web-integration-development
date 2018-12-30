<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"       prefix="sturts" %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"     %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'treeTag.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <sx:head debug="false" />   
    <script type="text/javascript" >
      <!--
      
         // 勾選節點
        function test(){
        
           var node = dojo.widget.byId('root').selector.selectedNode;
           if(!node){
             alert("沒有勾選任何節點");
             return;
           }
           
           // 顯示勾選節點的資訊
          var selNodeInfo  = "勾選了 "+node.title;
                selNodeInfo += "\n父節點："+(node.parent.title?node.parent.title:'');
                selNodeInfo += "\n子節點："+(node.children?node.children.length:0)+" 個.";
           
           alert(selNodeInfo);
         } // end test()
        
        
        
         // 展開
        function expand(){
           var node = dojo.widget.byId('root').selector.selectedNode;
           node.expand();
         } // end  expand()
      
      
      
         // 合起
        function collapse(){
           var node = dojo.widget.byId('root').selector.selectedNode;
           node.collapse(); 
         } // end collapse()
         
      //-->
    </script>
    
  </head>
  
  
  <body>
  
    <sx:tree id="root" 
             label="中國" 
             showGrid="true" 
             showRootGrid="true" 
             toggle="explode" 
             treeSelectedTopic="test" >
             
      <sx:treenode id="child1" label="<b>北京市</b>" />
      <sx:treenode id="child2" label="<b>上海市</b>" />
      <sx:treenode id="child3"  label="山東省" >
        <sx:treenode id="subchild3_1" label="濟南市" />
        <sx:treenode id="subchild3_2" label="青島市" />
        <sx:treenode id="subchild3_3" label="煙台市" />
      </sx:treenode>
      <sx:treenode id="child4" label="浙江省" >
        <sx:treenode id="subchild4_1" label="杭州市" />
        <sx:treenode id="subchild4_2" label="溫州市" />
      </sx:treenode> 
    </sx:tree>
    
    <hr/>
    
    <button onclick="test();" >勾選節點</button>
    <button onclick="expand();" >展開</button>
    <button onclick="collapse();" >合起</button>

  </body>
  
</html>