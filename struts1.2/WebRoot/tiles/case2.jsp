<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"   prefix="html"   %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"   prefix="bean"   %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"  prefix="logic"  %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles"  prefix="tiles"  %>

<%-- 
   1.《html 標籤函式庫》：用於產生 html 程式碼。  
    
   2.《bean 標籤函式庫》：用於操作 POJO、Cookie、Header 以及Struts 物件等。
  
   3.《logic 標籤函式庫》：由於 bean 標籤經常拋出例外，因此常與 logic 標籤一起使用。
   
   4.《nested 標籤函式庫》：使用 nested 標籤能夠使Struts 把資料直接設置到業務元件 POJO 而不是FormBean。
   
   5.《tiles 標籤函式庫》：原本是一個獨立的軟體產品，後來被融入Apache Struts 中。
                           tiles Apache 官方網站為：http://tiles.apache.org/
                           tiles 在處理網頁佈局以及佈局的再使用性、可維護性上做得非常好，
                           能將頁面或者部份頁面元件化。
                           開發Struts 專案時，結合使用tiles，在處理JSP檔案樣式上會得心應手，簡單明瞭。
       
--%>


<!-- 插入範本檔案 -->
<tiles:insert page="template2.jsp" flush="true" >



  <!-- 設定標題 -->
  <tiles:put name="title" value="讀書頻道 - 紅樓夢 (template - 2)" />




  <!-- 設置導覽列  -->
  <tiles:put name="header" >
     <a href="login.do" >登入</a> | <a href="register.do" >註冊</a>  | <a href="about.do" >關於</a> | <a href="contact.do" >關於我們</a>
  </tiles:put>




  <!-- 設置功能列表(開始) --> 
  <tiles:putList name="menus" >
    <tiles:add><div id="selected" ><a href="" >新聞</a></div></tiles:add>
    <tiles:add><div><a href="" >資源</a></div></tiles:add>
    <tiles:add><div><a href="" >常見問題</a></div></tiles:add>
    <tiles:add><div><a href="" >下載</a></div></tiles:add>
    <tiles:add><div><a href="" >回饋</a></div></tiles:add>
  </tiles:putList>
  <!-- 設置功能列表(結束) --> 




  <!-- 設置內容區域 (開始) -->
  <tiles:put name="main" >
    连载 > 小说总馆 > 古典小说 > 红楼梦 <br/><br/>
     
     <span style="margin-left:2em" ></span>
    《红楼梦》，又称《石头记》，被认为是中国最具文学成就的古典小说，是中国长篇小说创作的巅峰之作。
     本书第一章中说这个故事真正作者已不可考，而由曹雪芹传抄、批阅及增删数次而成，但经过学者的索隐考证后，认为曹雪芹就是本书真正的作者。　
     「滿紙荒唐言，一把心酸淚，都云作者痴，誰解其中味？」打開紅樓夢就看到作者曹雪芹的感慨詩句。就像曹雪芹的一生一樣，紅樓夢裡的賈府由極奢華的富家生活到最後賈府衰敗家道中落，原本一個富有的書香門第為什麼會一代不如一代呢？因為賈府中「上下一心」的享受著榮華富貴，卻沒有一個人肯真正的去籌畫或是處理事務的，雖然外表光鮮亮麗，但是因為不能節省不必要的開銷還有注重排場的壞習慣，賈府當然也就越來越衰敗，而賈母的溺愛導致兒孫們的驕縱成性，養尊處優的結果就是一代不如一代了。
     
     <br><br><br>
    
     <span style="margin-left:2em" ></span>
      雖然紅樓夢一齣悲劇，但是這本書中所用的辭彙卻是優美華麗細緻的，這也是這本書成功的秘訣吧。「寶玉掀簾一邁步進去，先就看見薛寶釵坐在炕上做針線，頭上挽著上髟下贊兒，蜜合色棉襖，玫瑰紫二色金銀鼠比肩褂，蔥黃綾棉裙，一色半新不舊，看去不覺奢華。唇不點而紅，眉不畫而翠；臉若銀盆，眼如水杏。罕言寡語，人謂藏愚；安分隨時，自云守拙。」描寫薛寶釵的這一小段，雖然很短，但是讓讀者未親眼見到卻能夠在腦中依稀出現薛寶釵的身型裝扮還有個性，除了在詞語的修飾上，細緻的文字描述也是成功的原因之一。
      不過看了紅樓夢，卻為了這裡面的人物感到同情，在這麼大的賈府裡，奴婢、丫環都很好命，甚至小姐太太夫人們擁有自己的別院及一輩子也享用不盡的器物珠寶和財富，她們擁有太多令人羨慕嫉妒的物品，但是物質並不是最重要的，他們並不知道他們少了一般人最平凡的自由，連自己的婚姻也無法自己組張，這就是造成賈寶玉和林黛玉最終悲劇的最大原因。
      在賈府這樣奢華的府第裡，她們只能生活在小圈圈裡，過著封閉的奢華生活，自小被寵大的，根本無法適應那一道朱門後的平凡，進而養成了任性驕縱的脾氣，然而他自己又怎麼知道，飛不出牢籠裡的金絲雀終究只有被把玩著供人欣賞的命運，一直要到失去了些什麼，才恍然大悟，原來不是所有東西都可以手到擒來，原來富貴不是享用不盡，原來天下沒有白吃的午餐，原來所有收穫都要靠著努力。
      這樣的人生真的好嗎？在如山一般的財富之中生活下，賈寶玉代表的即是奢華糜爛，因為自己不愁吃穿，所以索性無所事事，整天漫無目的，不過換個方向想，其實賈寶玉的作為顯示他在心態方面的叛逆，因為大家對他的重視導致保護過度，加上他從小在那麼樣的一個環境長大，被寵上天的快樂卻失去自由的痛苦交織，其實賈寶玉不過是隻關在漂亮籠子裡的金絲雀，直到最後，他才稍微看清楚人生最後的目的及光亮，以至於後來選擇出家，避開俗世。
      ”富貴能滿足慾望，卻無法滿足一切慾望。” 「浮生著甚苦奔忙，盛場華筵終散場，悲喜千般同幻滅，古今一夢盡荒唐。漫言紅袖啼痕重，更有情癡抱恨長，字字看來皆是血，十年辛苦不尋常。」生在富貴得家庭不一定好重要的是不能讓自己沉迷在奢華的腐敗氣息裡才能找到自己的幸福。
  </tiles:put>



  <tiles:put name="copyright" type="template" value="copyright.txt" />



</tiles:insert>