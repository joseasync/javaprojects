<%--
  Created by IntelliJ IDEA.
  User: josericardogcruz
  Date: 14/06/2020
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Registration</title>
    <style>
        .error{
            color:#ff0000;
        }
        .errorblock{
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>


</head>
<body>
<h1>Registration</h1>
<form:form modelAttribute="registration">
    <form:errors path="*" cssClass="errorblock" element="div"/> <%-- * means todos erros--%>
        <table>
            <tr>
                <td>
                    <spring:message code="name"/>:
                </td>
                <td>
                    <form:input path="name"/>
                </td>
                <td>
                    <form:errors path="name" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <spring:message code="save.button" var="submitText"/>
                    <input type="submit" value="${submitText}">
                </td>

            </tr>

        </table>

</form:form>
</body>
</html>
