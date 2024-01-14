<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SavePage</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  </head>
  <body>
  <div class="container">
    <h1>Book Info</h1>
    
    <font color=green>
<c:out value="${msg}"></c:out>
</font>

<form action="book" method="post">
<table>
<tr>
<td>Book Name :</td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td>Book Price :</td>
<td><input type="number" name="price"></td>
</tr>
<tr>
<td>Author Name :</td>
<td><input type="text" name="author"></td>
</tr>
<tr>
<td>  </td>
<td><input type="submit" value="submit"  class="btn btn-primary"></td>
</tr>
</table>
<a href="book">View Books</a>

</form>
    
</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>