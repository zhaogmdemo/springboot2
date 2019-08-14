<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0052)http://localhost:8080/Voids/controller/courseShow.do -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<!--<base href="http://localhost:8080/Voids/">--><base href=".">
		
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>智游教育</title>
		
<link href="${pageContext.request.contextPath}/js/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
<script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<script src="${pageContext.request.contextPath}/js/jquery-1.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/confirm.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/message_cn.js"></script>

		<style type="text/css">
		th {
			text-align: center;
		}
		.d{
padding-left: 420px;
display:inline-block;
}
		</style>
	</head>

	<body>
<nav class="navbar-inverse">
	<div class="container">
		
		<div class="navbar-header">
			<a class="navbar-brand"href="index.jsp">视频管理系统</a>
		</div>

		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
			<ul class="nav navbar-nav">
				<li class="active"><a href="${path}/VideoShow.do">视频管理</a></li>
				<li ><a  href="${path}/SpeakerShow.do">主讲人管理</a></li>
				<li ><a href="${path}/AdminLogin1.do">课程管理</a></li>
				<li><a href="${path}/AdminLoginManager.do">管理员管理</a></li>
			</ul>
			<p class="navbar-text navbar-right">
				<span>admin</span> <i class="glyphicon glyphicon-log-in" aria-hidden="true"></i>&nbsp;&nbsp;<a  class="navbar-link" href="${path}/quitAdmin.do">退出</a>
			</p>
		</div>
		<!-- /.navbar-collapse -->


	</div>
	<!-- /.container-fluid -->
</nav>

	
	
		
	
    
    <div class="jumbotron" style="padding-top: 15px;padding-bottom: 15px;">
	  <div class="container">
	          <h2>视频管理</h2>
	  </div>
	</div>
	
	<form action="VideoLikeShow.do" id="Find" method="post">
	<div class="container">
	    <button onclick="showAddPage()" type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		      添加
		</button>
		
		<button onclick="deleteAll()" type="submit" id="btn" class="btn btn-info dropdown-toggle">
		      批量删除
		</button><div class="d">
		<input type="text" placeholder="标题" id="in" name="factor" class="" value="">
			<select name="speaker_id" id="speaker_id" class="btn btn-primary" >
				<option  value="0" selected="selected">请选择老师</option>

						<c:forEach var="speaker" items="${Speaker.data}">
					<%-- 	<c:if test=" ${speaker.id}!=0"></c:if> --%>
							<option value="${speaker.id}">${speaker.speakerName}</option>
						</c:forEach>	
			</select>
			<select name="course_id" id="course_id" class="btn btn-primary">
				<option value="0" selected="selected">请选择课程</option>
				<c:forEach var="course" items="${Course.data}">
							<option value="${course.id}">${course.courseTitle}</option>
						</c:forEach>	
			</select>
			<button id="myFormId" type="submit" onclick="select1()" class="btn btn-info dropdown-toggle">搜索</button>
		</div></div>
	
	<div class="container" id="VideoShowID" style="margin-top: 20px;">
		
		<table class="table table-bordered table-hover" style="text-align: center;table-layout:fixed;">
      <thead>
        <tr class="active">
          <th><input type="checkbox" id="checkall"></th>
          <th>序号</th>
          <th style="width:16%">名称</th>
          <th style="width:36%">介绍</th>
          <th>讲师</th>
          <th>时长</th>
          <th>播放次数</th>
          <th>编辑</th>
          <th>删除</th>
        </tr>
      </thead>
      <tbody>
          <c:forEach items="${Video.data }" var="video">
           <tr>  <td><input type="checkbox"name="bookname" ></td>
							<td>${video.videoId}</td>
							<td>${video.title}</td>
							
							<td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${video.detail}</td>
							<td>${video.speaker.speakerName}</td>
							
							<td>${video.time}</td>
							<td><c:choose>
									<c:when test="${video.playNum==null}">
        								0
   								 </c:when>
									<c:otherwise>
     									  ${video.playNum}
   									 </c:otherwise>
								</c:choose></td>

							<td> <a type="button"  href="${path}/getVideo.do?id=${video.videoId}" class="btn btn-info btn-sm">
                                <span class="" aria-hidden="true"></span>
                                    编辑</a></td>
							    <td>
                               
                                <a type="button"  href="${path}/delVideo.do?id=${video.videoId}" class="btn btn-danger btn-sm">
                                <span class="" aria-hidden="true" ></span>
                                    删除</a>
                            </td>
                        </tr>
                    </c:forEach>
							<!--  <tr>
          <td><input type="checkbox" ></td>
          <td>6</td>
          <td>Web前端入门小项目</td>
          <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">适合无编程基础但想学H5前端开发的同学入门学习，也适合UI、Java、PHP等其他学科学员预习或练习。本课程通过新闻页面、个人主页、个人简历、场景秀等多个项目案例由浅入深以项目实战的方式让同学们体验到前端开发乐趣。本课程突出实战，如果希望深入学习课程中涉及到的知识可报名学习智游前端开发课程。</td>
          <td><a>✎</a></td>
          <td><a onclick="deletee(&#39;6&#39;)" >X</a></td>
          </tr>
        
        <tr>
          <td><input type="checkbox"></td>
          <td>7</td>
          <td>前端开发与Git入门</td>
          <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">Git是一款免费、开源的分布式版本控制系统，用于敏捷高效地处理任何或小或大的项目。经过本章课程学习你将轻松入门，学会使用Git管理自己的源代码，让自己的开发之路井井有条，想进一步学习Git进阶部分的同学可报名智游前端开发课程。</td>
          <td><a>✎</a></td>
          <td><a onclick="deletee(&#39;7&#39;)" >X</a></td>
          </tr>
        
        <tr>
          <td><input type="checkbox"></td>
          <td>8</td>
          <td>每天20分钟轻松入门React</td>
          <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">适合有一定HTML+JS基础、想学习React的同学。本课程循序渐进、浅显易懂，非常适合React入门学习。想进一步学习和使用React进行开发的同学可以报名智游前端开发课程。</td>
          <td><a>✎</a></td>
          <td><a onclick="deletee(&#39;8&#39;)" >X</a></td>
          </tr>
        
        <tr>
          <td><input type="checkbox"></td>
          <td>9</td>
          <td>UI基础入门</td>
          <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">适合无设计基础但想学UI设计的同学学习。本课程零基础入门，扎实的软件基础、高端的图形创意、资深产品经理的面对面授课尽在智游UI设计课程，希望成为全能设计师的你可报名智游UI设计课程。</td>
          <td><a>✎</a></td>
          <td><a onclick="deletee(&#39;9&#39;)" >X</a></td>
          </tr>
        
        <tr>
          <td><input type="checkbox"></td>
          <td>11</td>
          <td>Python编程零基础入门</td>
          <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">适合无编程基础但想学Python的同学学习。本课程完全零基础入门，如果希望深入学习Python开发可报名学习智游Python企业开发课程。</td>
          <td><a>✎</a></td>
          <td><a onclick="deletee(&#39;11&#39;)">X</a></td>
          </tr> -->
        
        <!-- <tr><td colspan="2">
        <font>总共6条,当前第1页</font> -->
	
	 
	
		<!-- <a href=">1</a>&gt;
	
		<a href=">2</a>&gt; -->
	
        </td></tr>
        </tbody>
      </table>
      <hr style="height:1px;border:none;border-top:1px solid #ccc;" />
        <!-- 分页导航栏 -->

        <!-- 分页信息 -->
        <div class="row">
            <!-- 分页文字信息，其中分页信息都封装在pageInfo中 -->
            <div class="col-md-6">
                当前第：${pageInfo.pageNum}页，总共：${pageInfo.pages}页，总共：${pageInfo.total}条记录
            </div>

        <!-- 分页条 -->
            <div class="col-md-6">
                <nav aria-label="Page navigation">
                  <ul class="pagination">
                    <li><a href="${path}/VideoShow.do?pn=1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage }">
                         <li>
                          <a href="${path}/VideoShow.do?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                          </a>
                        </li>
                    </c:if>

                    <c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
                        <c:if test="${page_Num == pageInfo.pageNum }">
                            <li class="active"><a href="${path}/VideoShow.do?pn=${ page_Num}">${ page_Num}</a></li>
                        </c:if>
                        <c:if test="${page_Num != pageInfo.pageNum }">
                            <li><a href="${path}/VideoShow.do?pn=${ page_Num}">${ page_Num}</a></li>
                        </c:if>
                    </c:forEach> 
                    <c:if test="${pageInfo.hasNextPage }">
                        <li>
                          <a href="${path}/VideoShow.do?pn=${pageInfo.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                          </a>
                        </li>
                    </c:if>   
                    <li><a href="${path}/VideoShow.do?pn=${pageInfo.pages}">末页</a></li>
                  </ul>
                </nav>
            </div>
        </div>
    
	</div>
	  </form>
		
	


	<script type="text/javascript">
	$("#checkall").click(function(){
		 //全选按钮check状态，选择全部name为bookname的按钮
		            if(this.checked){
		                $("input[name='bookname']").prop('checked', true);

		            }
		//全部取消选中
		else{
		                $("input[name='bookname']").prop('checked', false);
		            }
		        });
	
	function select1(){
		
	$("#myFormId").attr('action', '/SSM_VIDEO/VideoLikeShow.do').submit();
	}
	
	/* 	function select(){
			$.post({
				type:"post",
				url:"VideoLikeShow.do",
						
					//name:$("#adminPassword1").val()	
					data:{"speaker_id":$("#speaker_id").val(),"course_id":$("#course_id").val()},
					//data: $('#Find').serialize(),//ajax提交表单   
				dataType:"json",
				
				success:function(data){
					//$('#VideoShowID').html(data);
					//return true;
					/* if(data=="1"){
						window.location.reload();
						alert("1");
						//$("#iadminPassword").text("");
						//$("#form").onsubmit="return false"
					}else{
						//$("#iadminPassword").text("您输入的管理员账号密码不对");
						//$("#form").onsubmit="return true"
					}			
				}, 
			}
			});
		}
		 */
	
		function showAddPage(){
			location.href="${path}/addVideo.do";
		}
		function delCourseById(Obj,id,title){

			Confirm.show('温馨提示：', '确定要删除'+title+'么？', {
				'Delete': {
					'primary': true,
					'callback': function() {
						var param={"id":id};
						$.post("admin/course/delCourse.action",param,function(data){
							if(data=='success'){
								Confirm.show('温馨提示：', '删除成功');
								$(Obj).parent().parent().remove();
							}else{
								Confirm.show('温馨提示：', '操作失败');
							}
						});
					}
				}
			});
		}
	</script>
  

<div id="modal-background" class=""></div><div id="confirm-modal" class="modal fade role=" dialog"="" tabindex="-1"><div class="modal-dialog modal-undefined"><div class="modal-content"><div class="modal-header"><button id="modal-upper-close" class="close modal-close" aria-label="Close" type="button"><span aria-hidden="true">×</span></button><h4 id="modal-title" class="modal-title">Modal Title</h4></div><div id="modal-body" class="modal-body"> Modal Message </div><div id="modal-footer" class="modal-footer"></div></div></div></div><div id="modal-background" class=""></div></body></html>