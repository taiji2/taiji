<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/job/updateJob" method="post">
    <table border="1">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="jobStr"></td>
            <td><input type="text" name="createTime"></td>
            <td><input type="text" name="dayId"></td>

            <input type="submit">
        </tr>


    </table>
</form>
</body>
</html>