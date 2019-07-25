<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="http://netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
<title>bbs1</title>
<style>
    label { margin-top: 20px; }
</style>
</head>
<body>
<div class="container">

   <form:form method="post" modelAttribute="comment">

    <table class="table table-bordered">
        <thead>
            <tr>
                <th>${ article.a_title }</th>
                <th>${ article.u_name }</th>
                <th>${ article.timestamp }</th>
                <th>${ article.a_click }</th>
            </tr>
        </thead>
        <tbody>
                <td>${ article.a_content }</td>
            </tr>
        </tbody>
    </table>
    
    <table class="table table-bordered">
            <tbody>
            <c:forEach var="comment" items="${ list }">
                <tr>
                    <td>${ comment.u_name }</td>
                    <td>${ comment.timestamp }</td>
                </tr>
                <tr>   
                    <td>${ comment.c_content }</td>
                </tr>
            </c:forEach>
            </tbody>
    </table>

 	
        <form:input path="c_content" />
        <div>
            <input type="submit" class="btn btn-primary" value="등록" />
        </div>
    
    
     	<div>
            <a href="write.do" class="btn">글쓰기</a>
            <a href="list.do?${ pagination.queryString }" class="btn">목록으로 나가기</a>
    	</div>
   
</form:form>

  <!--  <c:if test="${ not empty error }">
        <div class="alert alert-error">${ error }</div>
    </c:if>
    <c:if test="${ not empty success }">
        <div class="alert alert-success">${ success }</div>
    </c:if>   -->

</div>
</body>
</html>