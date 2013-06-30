<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home | Web Design WithIter</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta name="description" content="Home page - withiter.com"/>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/maxheight.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
	var Index = new function(){
		this.init = function(){
			$.ajax({
				type:"GET",
				url:"/IntpubWeb/modulespace/initIndex.action",
				dataType:"JSON",
				data:{},
				success:function(data){
					if(data.moduleState == 'success'){
						
						var $newUl = $("<ul>");
						jQuery.each(data.modules, function(i,module){
							var $newA = $("<a>").attr("href", "javascript:void(0)").attr("onclick", "Index.initSenNav('"+module.moduleCode+"','"+module.moduleName+"')").html("<em><b>"+module.moduleName+"</b></em>");;
							if(i == 0)
							{
								$newA.attr("class","first-current");
								alert("init : " + module.moduleCode+"-"+module.moduleName);
								Index.initSenNav(module.moduleCode,module.moduleName);
								alert("init");
							}
							if(i == data.modules.length)
							{
								$newA.attr("class","last");
							}
							var $newLi = $("<li>");
							$newLi.append($newA);
							$newUl.append($newLi);
							
			            });
						$("#navDiv").append($newUl);
						
					}else if(data.moduleState == 'error'){
						alert("加载错误，请联系管理员!");
					}
				},
				error:function(){
					alert("加载错误，请联系管理员!");
				}
			});
		};

		this.initSenNav = function(moduleCode,moduleName)
		{
			//$("#navDiv>li")
			alert("initSenNav moduleCode : " + moduleCode);
			
			$.ajax({
				type:"GET",
				url:"/IntpubWeb/partspace/initSecondMenu.action",
				dataType:"JSON",
				data:{"selectedModuleCode":moduleCode},
				success:function(data){
					alert("111");
					if(data.partState == 'success'){
						alert("initSenNav SUCCESS : " + moduleCode);
						var $newHr = $("<h2>").attr("id","modules_title").html(moduleName);;
						
						var $newUl = $("<ul>");
						$newUl.attr("class","list1");
						
						jQuery.each(data.parts, function(i,part){
							alert("parts : " + i);
							var $newA = $("<a>").attr("href", "javascript:void(0)").attr("onclick", "Index.queryInfos('"+part.partCode+"','"+part.partName+"')").html(part.partName);
							var $newLi = $("<li>");
							if(i == 0)
							{
								Index.queryInfos(part.partCode);
							}
							$newLi.append($newA);
							$newUl.append($newLi);
							
			            });
						$("#sencondMenu").append($newHr);
						$("#sencondMenu").append($newUl);
						alert("initSenNav end : " + moduleCode);
					}else if(data.moduleState == 'error'){
						alert("加载错误，请联系管理员!");
					}
				},
				error:function(){
					alert("加载错误，请联系管理员!");
				}
			});
		};
		this.queryInfos = function(selectedPartCode,partName)
		{
			$.ajax({
				type:"POST",
				url:"/IntpubWeb/partspace/queryInfosByPartCode.action",
				dataType:"HTML",
				data:{"selectedPartCode":selectedPartCode},
				success:function(data){
					$("#infos").html(data);
				},
				error:function(){
					alert("request error");
				}
			});
		};
	};

	
	
	$(document).ready(function(){
		Index.init();
		
	});
	
//-->
</script>
</head>

<body id="page1" onload="new ElementMaxHeight();">
   <!-- header -->
   <div id="header">
      <div class="container">
         <div class="row-1">
            <div class="logo"><a href="index.html"><img alt="" src="images/logo.jpg" /></a></div>
            <ul class="top-links">
               <li><a href="index.html"><img alt="" src="images/top-icon1.jpg" /></a></li>
               <li><a href="#"><img alt="" src="images/top-icon2.jpg" /></a></li>
               <li><a href="contact-us.html"><img alt="" src="images/top-icon3.jpg" /></a></li>
            </ul>
         </div>
         <div class="row-2">
         	<!-- nav box begin -->
            <div class="nav-box">
            	<div class="left">
               	<div id="navDiv" class="right">
                  	<!-- <ul>
                     	<li><a href="index.html" class="first-current"><em><b>首页</b></em></a></li>
                        <li><a href="#"><em><b>产品</b></em></a></li>
                        <li><a href="#"><em><b>服务</b></em></a></li>
                        <li><a href="#"><em><b>新闻动态</b></em></a></li>
                        <li><a href="#" class="last"><em><b>联系我们</b></em></a></li>
                        <li><a href="#"><em><b>客户留言</b></em></a></li>
                     </ul> -->
                  </div>
               </div>
            </div>
            <!-- nav box end -->
         </div>
      </div>
   </div>
   <!-- content -->
   <div id="content">
      <div class="container">
      	<!-- main-banner-big begin -->
         <div class="main-banner-big">
         	<div class="inner">
            	<h1>Even the biggest success Starts with a first step</h1>
               <a href="#" class="button">Learn More</a>
            </div>
         </div>
         <!-- main-banner-big end -->
         <div class="wrapper">
         	<div class="col-1 maxheight">
            	<!-- box begin -->
               <div class="box maxheight">
                  <div class="border-top maxheight">
                     <div class="border-right maxheight">
                        <div class="border-bot maxheight">
                           <div class="border-left maxheight">
                              <div class="left-top-corner maxheight">
                                 <div class="right-top-corner maxheight">
                                    <div class="right-bot-corner maxheight">
                                       <div class="left-bot-corner maxheight">
                                          <div  id="sencondMenu" class="inner">
                                             <!-- 
                                             <h2 id="modules_title">标题的id为modules_title</h2>
                                             <ul class="list1">
                                             	<li><a href="#">循环这个&lt;li></a></li>
                                             	<li><a href="#">Item1</a></li>
                                             	<li><a href="#">Item1</a></li>
                                             	<li><a href="#">Item1</a></li>
                                             	<li><a href="#">Item1</a></li>
                                             	<li><a href="#">Item1</a></li>
                                             	<li><a href="#">Item1</a></li>
                                             	<li><a href="#">Item1</a></li>
                                             	<li><a href="#">Item1</a></li>
                                             	<li><a href="#">Item1</a></li>
                                             	<li><a href="#">Item1</a></li>
                                             	<li><a href="#">Item1</a></li>
                                             </ul>
                                              -->
                                          </div>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <!-- box end -->
            </div>
            <div class="col-2 maxheight">
            	<!-- box begin -->
               <div class="box maxheight">
                  <div class="border-top maxheight">
                     <div class="border-right maxheight">
                        <div class="border-bot maxheight">
                           <div class="border-left maxheight">
                              <div class="left-top-corner maxheight">
                                 <div class="right-top-corner maxheight">
                                    <div class="right-bot-corner maxheight">
                                       <div class="left-bot-corner maxheight">
                                          <div id="infos" class="inner">
                                             <h2 id="item_list">标题的id为item_list</h2>
                                             <ul class="list2">
                                             	<li>循环这个&lt;li></li>
                                             	<li>President or something</li>
                                             	<li>President or something</li>
                                             	<li>President or something</li>
                                             	<li>President or something</li>
                                             	<li>President or something</li>
                                             	<li>President or something</li>
                                             	<li>President or something</li>
                                             	<li>President or something</li>
                                             	<li>President or something</li>
                                             	<li>President or something</li>
                                             </ul>
                                          </div>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <!-- box end -->
            </div>
         </div>
      </div>
   </div>
   <!-- footer -->
   <!--  -->
   <div id="footer">
   	<div class="container">
         <div class="wrapper">
         	<div class="fleft">Copyright &copy; 2012</div>
            <div class="fright"><a href="http://www.withiter.com">Withiter</a> all rights reserved.</div>
         </div>
      </div>
   </div>
</body>
</html>