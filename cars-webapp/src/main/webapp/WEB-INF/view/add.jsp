<<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 	<head>
 		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 		<title>Add a car</title>
 	</head>
 	<body>
 		<a href="list">Back to the cars list</a><br />
 		<form method="POST">
 			<table border="1">
 				<tbody>
 					<tr>
 						<th>Name</th>
 						<td><input type="text" name="name" /></td>
 					</tr>
 					<tr>
 						<th>Productions Date</th>
 						<td><input type="text" name="productionDate" /></td>
 					</tr>
 					<tr>
 						<th>Price</th>
 						<td><input type="text" name="price" /></td>
 					</tr>
 					<tr>
 						<th>Engine</th>
 						<td><input type="text" name="engine" /></td>
 					</tr>
 					<tr>
 						<td colspan="2" align="right"><input type="submit" value="Add!" /></td>
 					</tr>
 				</tbody>
 			</table>
 		</form>
 		<br />
 		<hr />
    </body>
 </html>