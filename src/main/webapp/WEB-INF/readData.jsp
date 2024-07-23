<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ユーザーデータ一覧</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>ユーザーデータ一覧</h1>
    <table>
        <tr>
            <th>名前</th>
            <th>パスワード</th>
            <th>性別</th>
            <th>好きな食べ物</th>
            <th>趣味</th>
        </tr>
        <c:forEach var="userData" items="${userDataList}">
            <tr>
                <td>${userData.name}</td>
                <td>${userData.password}</td>
                <td>${userData.gender}</td>
                <td>${userData.food}</td>
                <td>${userData.hobby}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>