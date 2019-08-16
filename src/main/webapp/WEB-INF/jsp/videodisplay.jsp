<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0084)http://localhost:8080/Voids/user/VideoGo.do?id=218&subjectName=WEB%E5%89%8D%E7%AB%AF -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--<base href="http://localhost:8080/Voids/">--><base href=".">
 
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    
    <!--<base href="http://localhost:8080/Voids/">--><base href=".">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
    <meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
    
<link rel="stylesheet" href="http://localhost:8080/SpringBootVideo/js/base.css">
<link rel="stylesheet" href="http://localhost:8080/SpringBootVideo/js/css.css">
<link rel="icon" href="http://localhost:8080/Voids/static/z/favicon.png" type="image/png">
    <link href="http://localhost:8080/SpringBootVideo/js/video-js.css" rel="stylesheet" type="text/css">
    <title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>

</head>

<body class="w100" style="padding-top: 0px;">




<header>
	<div class="container">
		<span>欢迎来到IT培训的黄埔军校——智游教育！</span>


		
			<div id="userBlock" style="float: right">
			<c:if test="${user2s.accounts!=null }">
				<a
					href="${pageContext.request.contextPath}/UserShow.action?accounts=${user2s.accounts}">${user2s.accounts}
				</a>
			</c:if>
			<c:if test="${user2s.accounts==null }">
				<a href="" data-toggle="modal" data-dismiss="modal"
					data-target="#login">登录</a>
			</c:if>
			<a href="" data-toggle="modal" data-dismiss="modal"
				data-target="#reg">注册</a>
		</div>
			
		
		

		<a onclick="JavaScript:addFavorite2()"><img src="http://localhost:8080/SpringBootVideo/images/sc.png" draggable="false">加入收藏</a>
		
		<a target="_blank"><img src="http://localhost:8080/SpringBootVideo/images/we.png" draggable="false">后台管理</a>
		<a class="color_e4"><img src="http://localhost:8080/SpringBootVideo/images/phone.png" draggable="false"> 0371-88888598　　4006-371-555</a>

	</div>
</header>


    

<div>
    <!--面包屑导航-->
    <div class="container mian-nav">公开课 / WEB前端</div>
    <input id="videoId" value="246" type="hidden">
    <div id="content">




<div class="intro">
	<div class="container">
		<div class="v-intro" >
			<div class="left">
				<video id="videoPlayer" src="http://localhost:8080/SpringBootVideo/mp/1.mp4" class="video-js vjs-default-skin" controls="controls" poster="static/z/02.jpg" data-setup="{}" height="280" width="627">
				</video>
			</div>

			<div class="right">
				<p class="right-title">HTML页面基本结构</p>
				<div class="avatar">
					<span style="background-image: url(${video3s.imageUrl})"></span>
					<h1>${video3s.imageUrl}</h1>
					<p><b>讲师：${ sessionScope.videc3s[0].speaker.speakerName }</b><br><i>${ sessionScope.videc3s[0].speaker.speakerDesc}</i></p>
				</div>
				<p class="video-intro">
					<span>本节内容：</span>${video3s.detail }
				</p>
			</div>
		</div>

		<div class="kcjs">
			<p class="title">课程介绍</p>
			<p class="content"> ${sessionScope.speaker.videc3s[0].courseDesc } </p>
		</div>

	</div>
</div>
<!--目录-->
<div class="catalog">
	<div class="container">
		<p class="title">目录</p>

			<c:forEach items="${ videc3s}" var="i">
			<a href="http://localhost:8080/SpringBootVideo/VideoDisplay2.action?videoId=${i.videoId}&courseId=${i.courseId}"> 
			<div class="chapter">
				<p class="biaoti">${i.title }</p>
				<p class="lecturer">${i.detail }</p>
				<p class="lecturer">讲师:${i.speaker.speakerName }</p>
				<div class="v-info">
					<span class="count"><img src="http://localhost:8080/SpringBootVideo/images/count.png" alt="">${i.playNum }</span>
					<span class="duration"><img src="http://localhost:8080/SpringBootVideo/images/player.png" alt=""> ${i.time } </span>
				</div>
				 </a>
			</div>
			</c:forEach>
			
			

	</div>
</div></div>



</div>
    
    
<!--页脚-->
<footer>
	<ul>
		<li>
			<img src="./视频播放_files/footer_logo.png" alt="" draggable="false">
		</li>
		<li class="mt25">
			<h3>各校区地址</h3>
			<ul>
				<li>总部地址<br>中国-郑州经济技术开发区河南省通信产业园六层</li>
				<li>郑州校区一<br>中国-郑州经济技术开发区第一大街与经北一路</li>
				<li>郑州校区二<br>中国-郑州经济技术开发区第四大街经开人才市场七楼</li>
				<li>郑州校区三<br>中国-郑州经济技术开发区第八大街河南省留学生创业园九层、十层</li>
				<li>西安分校<br>中国-西安莲湖区　联系人：梁老师 13201570801</li>
			</ul>
		</li>
		<li class="mt25">
			<h3>联系我们</h3>
			<ul id="foo_icon">
				<li>中国-郑州经济技术开发区经北三路河南通信产业园六层</li>
				<li>e-mail:zy@zhiyou100.com</li>
				<li>电话:4006-371-555 0371-88888598</li>
				<li class="erwei">
					<br>
					<div>
						<img class="weixin" src="./视频播放_files/a.png" alt="" draggable="false">
						<img class="weibo" src="./视频播放_files/a_002.png" alt="" draggable="false">
					</div>
				</li>
			</ul>
		</li>
	</ul>
	<div class="record">智游教育 © 豫ICP备17000832号-1 　河南智游臻龙教育科技有限公司</div>
</footer>


<!--登录注册弹出框-->
<div class="mask hidden" id="login">
	<div class="mask_content">
		<div class="mask_content_header">
			<img src="./视频播放_files/logo.png" alt="" class="ma">
		</div>
		<div class="mask_content_body">
			<form id="loginForm" action="http://localhost:8080/Voids/#">
				<h3>快速登录</h3>
				<input id="loginEmail" placeholder="请输入邮箱" name="email" type="email">
				<input id="loginPassword" placeholder="请输入密码" name="password" type="password">
				<div id="forget">
					<a href="http://localhost:8080/video/front/user/forgetPassword.action">忘记密码？</a>
				</div>
				<input onclick="return commitLogin()" value="登　录" type="submit">
			</form>
		</div>
		<div class="mask_content_footer">
			<span id="login_close">关　闭</span>
		</div>
	</div>
</div>
<div class="mask hidden" id="reg">
	<div class="mask_content">
		<div class="mask_content_header">
			<img src="./视频播放_files/logo.png" alt="" class="ma">
		</div>
		<div class="mask_content_body">
			<form id="regForm" action="http://localhost:8080/Voids/user/insertUser.action">
				<h3>新用户注册</h3>
				<input id="regEmail" placeholder="请输入邮箱" name="email" type="email"><span id="emailMsg"></span>
				<input id="regPsw" placeholder="请输入密码" name="password" type="password">
				<input id="regPswAgain" placeholder="请再次输入密码" name="psw_again" type="password"><span id="paSpringBootVideosg"></span>
				<div id="yzm" class="form-inline">
					<input name="yzm" style="width: 45%; display: inline-block;" type="text">
					<div id="v_container" style="width: 45%;height: 40px;float:right;"><canvas id="verifyCanvas" width="100" height="38" style="cursor: pointer;">您的浏览器版本不支持canvas</canvas><canvas id="verifyCanvas" width="100" height="38" style="cursor: pointer;">您的浏览器版本不支持canvas</canvas></div>
				</div>
				<input onclick="return commitRegForm();" value="注　册" type="submit">
			</form>
		</div>
		<div class="mask_content_footer">
			<span id="reg_close">关　闭</span>
		</div>
	</div>
</div>


    
<script src="http://localhost:8080/SpringBootVideo/js/jquery-1.js"></script>
<script src="http://localhost:8080/SpringBootVideo/js/gVerify.js"></script>
<script src="http://localhost:8080/SpringBootVideo/js/index.js"></script>

    <script src="http://localhost:8080/SpringBootVideo/js/video.js"></script>
   



</body></html>