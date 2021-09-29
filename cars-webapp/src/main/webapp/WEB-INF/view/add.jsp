<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a car</title>
    </head>
    <body>
        <a href="list">Back to the cars list</a><br />
        <form:form method="POST" modelAttribute="dtoCar">
            <table border="1">
                <tbody>
                    <tr>
                        <th>Name</th>
                        <td><form:input type="text" name="name" />
                        <c:if test="${pageContext.request.methods=='POST'}">
                        <form:errors path="name" /></c:if></td>
                    </tr>
                    <tr>
                        <th>Productions Date</th>
                        <td><form:input type="text" name="productionDate" />
                        <c:if test="${pageContext.request.methods=='POST'}">
                        <form:errors path="productionDate" /></c:if></td>
                    </tr>
                    <tr>
                        <th>Price</th>
                        <td><input type="text" name="price" />
                        <c:if test="${pageContext.request.method=='POST'}">
                        <form:errors path="price" /></c:if></td>
                    </tr>
                    <tr>
                        <th>Engine</th>
                        <td><input type="text" name="engine" />
                        <c:if test="${pageContext.request.method=='POST'}">
                        <form:errors path="engine" /></c:if></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right"><input type="submit" value="Add!" /></td>
                    </tr>
                </tbody>
            </table>
        </form:form>
        <br />
        <hr />
    </body>
 </html>
