
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>Login</h2>

<form action="Controle?cmd=login" method="post">

<table>
	<tr>
		<td>User</td> <td><input type="text" name="nome"></td>
	</tr>
	
</table>
<br>
<input type="submit" value="Entrar">
</form>
<br>
${msg}

</body>
</html>
