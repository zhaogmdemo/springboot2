<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="./CSS/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="./CSS/font-awesome.min.css" type="text/css">
<style type="text/css">
.divForm {
	width: 300px;
	height: 350px;
	position: absolute;
	text-align: center;
	padding-top: 50px;
	padding-left: 28px;
	background: #FFF;
	margin-left: 40%;
	margin-top: 10%;
}

.form-control {
	width: 250px;
}

body {
	background: #ccc;
	height: 100%;
}

.eye {
	height: 32px;
	width: 37px;
	position: absolute;
	top: 185px;
	left: 80%;
}
</style>
<script type="text/javascript" src="./jquery/jquery.js"></script>
<script type="text/javascript" src="./CSS/bootstrap.min.js"></script>
<script type="text/javascript" src="./jquery/jquery.validate.min.js"></script>
<script type="text/javascript" src="./jquery/messages_zh.js "></script>
<script type="text/javascript">
$(function(){
	$("#form").validate({
		rules:{
			userName:{
				required:true,
				minlength:1,
				maxlength:12
			},
			password:{
				required:true,
				minlength:6,
				maxlength:12
			},
			rePassword:{
				required:true,
				 equalTo:"#password"
			},
			mail:{
				
				email:true
			}
		},
		messages:{
			userName:{
				required:"请输入你的用户名",
				minlength:"请输入长度大于1的用户名"
			},
			password:{
				required:"请输入你的密码",
				minlength:"请输入长度大于6的密码"
			},
			rePassword:{
				required:"请重复输入你的密码",
				 equalTo:"与密码不符"
			},
			mail:{
				
				email:"请输入正确的邮箱"
			}
		}
	});
})
</script>
</head>
<body>
     <!-- 注册窗口 -->
    <div id="register" class="modal fade" tabindex="-1"  >
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">注册新用户</h1>
                </div>
                <div class="modal-body" >
                  
                    <form class="form-group" action="UserLogin.action" id="form">
                            <div class="form-group" >
                                <label for="">用户名</label>
                                <input class="form-control" type="text" placeholder="6-15位字母或数字" name="accounts">
                                <div id="msg"></div>
                            </div>
                            <div class="form-group">
                                <label for="">密码</label>
                                <input class="form-control" type="password" placeholder="至少6位字母或数字" name="password" id="password">
                            </div>
                            <div class="form-group">
                                <label for="">再次输入密码</label>
                                <input class="form-control" type="password" placeholder="至少6位字母或数字" name="rePassword">
                            </div>
                            <div class="form-group">
                                <label for="">邮箱</label>
                                <input class="form-control" type="email" placeholder="例如:123@123.com" name="mail">
                                <button type="button" id="codeBtn" >发送验证码</button>
                            </div>
                            
                             <div class="form-group">
                                <label for="">验证码</label>
                                <input class="form-control" type="text"  id="code">
                                <input type="hidden" id="CodeNow">
                                <div id="codeMsg"></div>
                            </div>
                           
                            <div class="text-right">
                                <button class="btn btn-primary" type="submit">提交</button>
                                <button class="btn btn-danger" data-dismiss="modal">取消</button>
                            </div>
                            <a href="" data-toggle="modal" data-dismiss="modal" data-target="#login">已有账号？点我登录</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- 登录界面 -->
	<div class="divForm" class="form-inline">
		<form action="login.do" method="post" name="forml" id="loginform">
			<table>
				<tr>
					<td><img alt="智游教育" src="images/logo.png" height="55" width="150"></td>
				</tr>
				<tr>
					<td><p style="color: gray">视频登录</p></td>
				</tr>
				<tr>
					<td>
						<div class="form-group">
						
							<input type="text" class="form-control" id="loginEmail"
							value="${uncookie }"	name="accounts">
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="form-group">
							<input type="password" class="form-control"  id="loginPassword"
							value="${pscookie }"	name="password">

						</div>
					</td>
					<td><img src="./images/xian.gif" id="eye" class="eye"
						 title="显示密码"></td>
				</tr>
				<tr>
					<td><img src="images/cang.png" id="check" >记住用户名密码
					 &nbsp; &nbsp; &nbsp; &nbsp;
					 <a href="" data-toggle="modal" data-dismiss="modal" data-target="#register">注册</a>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td><input type="submit" value="登陆"onclick="commitLogin2()" 
						class="btn btn-danger btn-block"></td>
				</tr>
			</table>
		</form>
	</div>

	<c:if test="${msg!=null}">
		<script type="text/javascript">
			alert('${msg}');
		</script>
	</c:if>
<script type="text/javascript">

function commitLogin2(){
	   
	   var accounts =$("#loginEmail").val();
	   var password =$("#loginPassword").val();
	  
	   if(null!=accounts && accounts!="" && null!=password && password!=""){
		
	      
	        $.ajax({
	        	url:"${pageContext.request.contextPath}/UserLogin.action",
	        	data:{
	        		 accounts:$("#loginEmail").val(),
	        		 password:$("#loginPassword").val(),
	        	},
				success:function(data){
					
					if(data.cs=="1"){			
						$("#emailMsg2").html("账号或密码不正确");
						$("#emailMsg2").attr("style","color:red;");
					
					}else if(data.cs=="2"){
						
						location.href="http://localhost:8080/SpringBootVideo/videodisplay";
						
					}
				}
	        })
	 
	   }
	}
</script>

	<script type="text/javascript">

    $(function() {
     $("#eye").click(function(){
    	 var i = $("#eye").get(0).title;
    	 if (i == "隐藏密码") {
    		 $("#loginPassword").get(0).type="password";
    		 $("#eye").get(0).title = "显示密码";
    		 $("#eye").get(0).src = "./images/xian.gif";

			} else {
				 $("#eye").get(0).title = "隐藏密码";
				 $("#loginPassword").get(0).type= "text";
				 $("#eye").get(0).src = "./images/cang.gif";
			}
     });
    });
   
		var flag = 0;
		$(function () {
			$("#check").click(function () {
				if (flag == 0) {
					var userName = $("#uname").get(0).value;
					var password = $("#ps").get(0).value;
// 					$.cookie('uncookie',userName);
// 					$.cookie('pscookie',password);
					document.cookie = "uncookie="+userName;
					document.cookie = "pscookie="+password;

					$("#check").get(0).src = "./images/check.png";
					
					flag = 1;
				} else {
					$("#check").get(0).src = "./images/normal.png";
					document.cookie = "uncookie=";
					document.cookie = "pscookie=";
//                  $.cookie('uncookie',"");
// 					$.cookie('pscookie',"");
					flag = 0;
				}
			});
		});
		
	
		$(function(){
			$("#codeBtn").click(mailsend);
		});
		function mailsend(){
	       
			$.ajax({
			url:"/CRMDemo01/MailCheck.do",
			type:"post",		
			data:{
				mail:$("input[name='mail']").val()
			},
// 			dataType:"json",
			success:function(msg){
// 				alert(msg);
// 				var newCode=JSON.stringify(msg.Code);
				$("#CodeNow").val(msg);
			}
		});
		}
		
		$(function(){
			$("#code").blur(mailcheck);
		});
		
		function mailcheck() {
			var CodeNow = $("#CodeNow").val();
			var Code=$("#code").val();
// 			alert(Code);
// 			alert(CodeNow);
			if (CodeNow==Code) {
				$("#codeMsg").html("<font color='green'>验证成功!</font>");
			}else{
				$("#codeMsg").html("<font color='red'>验证失败!</font>");
			}
			
		}
		
		
		
		$(function(){
			$("input[name='userName']").blur(usernamerepat);
		});
		function usernamerepat(){
	       
			$.ajax({
			url:"/CRMDemo01/namerepeat.do",
			type:"post",		
			data:{
				username:$("input[name='userName']").val()
			},
			dataType:"json",
			success:function(msg){
				if(msg.isSuccess){
					$("#msg").html("<font color='green'>用户名能够使用!</font>");
				}else{
					$("#msg").html("<font color='red'>用户名重复!</font>");
				    
				}
			}
		});
		}
		
		var count = 60;
		function time(){
			if(count==0){
				$("#codeBtn").attr('disabled',false);
				$("#codeBtn").val("发送验证码");
				var count = 60;
				return;
			}else{
				$("#codeBtn").attr('disabled',true);
				$("#codeBtn").val("重新发送"+count+"s");
			}
			
				
		}
		
	</script>
</body>
</html>