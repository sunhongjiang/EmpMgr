
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>

<title>新增员工</title>

<style>
	.container
		{
			text-align: center;
			position: relative;
			top:100px;
		}
		
</style>

</head>
<body>
	<div id = "container">
		<form action="servlet/addEmp" method="post">
		员工编号 <input type="text" id= "empno" name="empno" placeholder="请输入员工编号" /> <br /> 		
		员工姓名 <input type="text" id="ename" name="ename" placeholder="请输入员工姓名" /> <br />
		员工职务 <input type="text" id="job" name="job" placeholder="请输入员工职务" /><br /> 
		<!--  经理编号 <input type="text" id="mgr" name="mgr" placeholder="请输入经理编号" /><br /> -->
		<!--  雇佣日期 <input type="date" id="hiredate" name="hiredate" placeholder="请输入雇佣日期" /><br /> -->
		每月薪水 <input type="text" id="sal" name="sal" placeholder="请输入每月薪水" /><br />
		<!--  每月提成 <input type="text" id="comm" name="comm" placeholder="请输入每月提成" /> --> <br />
		<!--  部门编号 <input type="text" id="deptno" name="deptno" placeholder="请输入部门编号" /> --> <br /><br />  
		
		<input type="submit" value="确认添加">
	</form>
	</div>
</body>
</html>