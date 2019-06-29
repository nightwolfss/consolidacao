<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="persistencia.CampanhaDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	CampanhaDao cd = new CampanhaDao();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
		crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
			integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
			integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
			crossorigin="anonymous"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
			integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
			crossorigin="anonymous"></script>

		<style type="text/css">
.tudo {
	margin-top: 1%;
	margin-left: auto;
	margin-right: auto;
	width: 75%;
	height: 500px;
}

.nome {
	width: 30%;
}
</style>

		<title>Atualizar Campanha</title>
</head>
<body>
	<form action="Controle?cmd=campanhaUpdate" method="post">
	<div class="tudo">
		<h2>
			Atualizar "<%=cd.findByCode(Integer.parseInt(request.getParameter("id"))).getNome()%>"
		</h2>
		<br/>
		<input type="hidden" name="id" value="<%=request.getParameter("id")%>"/>
		<input type="submit" value="atualizar"/>
		<a href="campanhas.jsp">Campanhas</a>
		<br />
		<div class="nome">
			Campanha: <input type="text" name="nome" class="form-control"
				value="<%=cd.findByCode(Integer.parseInt(request.getParameter("id"))).getNome()%>" />
		</div>

		<br /> Nova email de campanha: <br />

		<textarea name="texto" rows="35" cols="90"
			placeholder="Escreva o conteúdo do email. Aceita TAGs HTML"
			class="form-control"><%=cd.findByCode(Integer.parseInt(request.getParameter("id"))).getTexto()%></textarea>

	</div>
	</form>
</body>
</html>