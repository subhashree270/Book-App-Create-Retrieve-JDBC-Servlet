<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>DisplayPage</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  </head>
  <body>
    <h2 class="container">List of Book</h2><br>
<a href="index.jsp">Add new book</a><br>

<table class="table table-bordered" >
<thead>
<tr>
<th>Id</th>
<th>Name</th>
<th>Price</th>
<th>Author</th>
</tr>
</thead>
<tbody>
<c:if test="${books.size()==0 }">
<tr>
<td colspan="4"><c:out value="No Records Found"></c:out> </td>
</tr>
</c:if>
<c:forEach items="${books}" var="book" varStatus="index">
<tr>
<td>${index.count}</td>
<td>${book.bookName}</td>
<td>${book.bookPrice}</td>
<td>${book.bookAuthor}</td>
</tr>
</c:forEach>

</tbody>

</table>
    
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    
 </body>


</html>