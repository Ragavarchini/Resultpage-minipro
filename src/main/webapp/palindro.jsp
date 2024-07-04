<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

Boolean booleanValue = (Boolean) request.getAttribute("booleanValue");
if (booleanValue != null) {
	if(booleanValue){
    out.println("Palindrome");
    }
else{
    out.println("Not a palindrome");
}
}

%>

</body>
<style>
	body{
 	text-align: center;
 	padding: 200px;
 	font-size: larger;
 	font-decoration: bold;
 }
</style>

</html>