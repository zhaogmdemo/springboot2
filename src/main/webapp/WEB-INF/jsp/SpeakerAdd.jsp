<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0047)http://localhost:8080/Voids/Course/addCourse.do -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>   
<!--<base href="http://localhost:8080/Voids/">--><base href=".">


<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>智游教育</title>

<link href="./js/bootstrap.css" rel="stylesheet">

<style type="text/css">
.col-md-1 {
	padding-top: 20px;
}

.a1 {
	color: gray;
}

b {
	float: right;
}
</style>



</head>

<body>

	




<nav class="navbar-inverse">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<a class="navbar-brand">视频管理系统</a>
		</div>

		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
			<ul class="nav navbar-nav">
				<li ><a href="${path}/VideoShow.do">视频管理</a></li>
				<li class="active"><a  href="${path}/SpeakerShow.do">主讲人管理</a></li>
				<li ><a href="${path}/AdminLogin.do">课程管理</a></li>
			</ul>
			<p class="navbar-text navbar-right">
				<span>admin</span> <i class="glyphicon glyphicon-log-in" aria-hidden="true"></i>&nbsp;&nbsp;<a class="navbar-link">退出</a>
			</p>
		</div>

	</div>

</nav>



	<div class="jumbotron" style="padding-top: 15px;padding-bottom: 15px;">
		<div class="container">

			
				<h2>添加课程</h2>
			
			
		</div>
	</div>



	<div class="container" style="margin-top: 20px;">

		<form id="infoForm" action="AddSpeaker.do" class="form-horizontal"  method="post" >

			
			<div class="form-group">
			    <label for="subjectId" class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-10">

			<input class="form-control" name="speakerName" id="speakerName" placeholder="主讲人姓名" type="text">


			    </div>
			  </div>
			
			
			
			<div class="form-group">
				<label for="subjectTitle" class="col-sm-2 control-label">职位</label>
				<div class="col-sm-10">
					<input class="form-control" name="speakerJob" id="speaker_job" placeholder="主讲人职位" type="text">
				</div>
			</div>
			<div class="form-group">
				<label for="courseDesc" class="col-sm-2 control-label">头像地址</label>
				<div class="col-sm-10">
					<input class="form-control" id="pirUrl" placeholder="头像地址" name="pir_url" rows="3"></input>
				</div>
			</div>
			<div class="form-group">
				<label for="courseDesc" class="col-sm-2 control-label">简介</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="speakerDesc" name="speakerDesc" placeholder="简介" rows="3"></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">保存</button>
				</div>
			</div>
		</form>
	<form id="infoForm1" action="SpeakerShow.do" class="form-horizontal"  method="post" >
		<div class="form-group" >
		<div class="col-sm-offset-2 col-sm-10">
				
			<button onclick="back()" class="btn btn-default">返回</button>
			</div>
		</div></div></form>	

	<!-- å¦æIEçæ¬å°äº9ï¼å è½½ä»¥ä¸js,è§£å³ä½çæ¬å¼å®¹é®é¢ -->
<!--[if lt IE 9]>
<script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script src="./js/jquery-1.js.下载"></script>
<script src="./js/bootstrap.js.下载"></script>
<script src="./js/confirm.js.下载"></script>
<script src="./js/jquery.js.下载"></script>
<script src="./js/message_cn.js.下载"></script>
<script src="./JS1/jquery-3.4.1.js"></script>
<script src="./JS1/jquery.validate.min.js"></script>


<script type="text/javascript">

$().ready(function(){
	$("#infoForm").validate({
		
		
		rules:{
			speaker_name:{
				required:true,
				
				
			},
			speaker_job:{
				required:true,
			

			},
			pir_url:{
				required:true,
			
				

			},
			speaker_desc:{
				required:true,
			
				

			}
			
		
		
			
		},
		messages:{
			speaker_name:{
				required:"请输入主讲人",
				
	
			},
			speaker_job:{
				required:"请输入主讲人职位",
			


			},

			
			pir_url:{
				required:"请输入图片地址",
				
			},
			speaker_desc:{
				required:"请输入简介描述",
				
			}
		}
	});
})</script>






<div id="modal-background" class=""></div><div id="confirm-modal" class="modal fade role=" dialog"="" tabindex="-1"><div class="modal-dialog modal-undefined"><div class="modal-content"><div class="modal-header"><button id="modal-upper-close" class="close modal-close" aria-label="Close" type="button"><span aria-hidden="true">×</span></button><h4 id="modal-title" class="modal-title">Modal Title</h4></div><div id="modal-body" class="modal-body"> Modal Message </div><div id="modal-footer" class="modal-footer"></div></div></div></div><div id="modal-background" class=""></div></body></html>