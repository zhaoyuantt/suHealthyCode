<%--
  Created by Eclipse.
  User: zhaoyuan
  Date: 2020/05/01
  Time: 1:28 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>fill in a form and submit</title>
    <link rel="shortcut icon"
          href="${pageContext.request.contextPath}/images/shortcut.ico">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/jQuery/jquery-1.8.3.js"></script>
    <style type="text/css">
        .main{
            height: 80vh;
            width: 75vw;
            margin: 7em 2em 0em 3em;
            /*border-style: solid;
            border-width: 1px;
            border-color: #0C0C0C;*/
        }

        span{
            margin-left: 1.5em;
            font-family: "Courier New";
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="main">
        <span>姓名：${tdataj.name}</span></br>
        <span>身份证号：${tdataj.idCard}</span></br>
        <span>联系方式：${tdataj.phoneNumber}</span></br>
        <span>户籍：${tdataj.householdRegister}</span></br>
        <span>提交时间：${tdataj.created}</span></br>
        <img src="" alt="">
    </div>
<script type="text/javascript">
    $(function(){
        console.log("${tdataj.idCard}");
        $("img").attr("src","${pageContext.request.contextPath}/code/${tdataj.idCard}");
    });

</script>
</body>
</html>