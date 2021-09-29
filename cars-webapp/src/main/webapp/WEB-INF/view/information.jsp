<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cars Information</title>
    </head>
    <body>
        <a href="list">Back to the car list</a><br />
        <table border="1">
            <tbody>
                <tr>
                    <th>Car: </th>
                    <td>${car.name}</td>
                </tr>
                <tr>
                    <th>Production Data</th>
                    <td><fmt:formatDate pattern="dd.MM.yyyy" value="${car.productionDate}" /></td>
                </tr>
                <tr>
                    <th>Price</th>
                    <td><fmt:formatNumber type="number" minFractionDigits="2"
                    maxFractionDigits="8" value="${car.price}" /> €</td>
                </tr>
                <tr>
                    <th>Engine</th>
                    <td>${car.engine}</td>
                </tr>
            </tbody>
        </table>
        <br />
        <hr />
    </body>
</html>