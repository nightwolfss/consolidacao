<% 
if(session.getAttribute("nome").equals("Vitor")){
%>
<%@page import="com.sun.xml.internal.fastinfoset.sax.SystemIdResolver"%>
<%@page import="java.util.Date"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:useBean id="mng" class="controle.Controle" scope="request" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="refresh" content="10;url=campanhas.jsp">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"	crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"	crossorigin="anonymous"></script>
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"	crossorigin="anonymous"></script>
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="shortcut icon" href="IMG\icone.ico" type="image/x-icon" />
	
<style type="text/css">
	.tudo{
	margin-top: 1%;
	margin-left: 1%;
	
	}
	</style>
<title>Campanhas</title>
</head>
<body>

<div class="tudo">
<h1>Cadastrar Campanhas</h1>
<hr/>
1 campanha por dia será encaminhada para cada email cliente cadastrado.
<hr/>
<div class="container">
<form action="Controle?cmd=enviarcampanhas" method="post">
	<input type="submit" value="Enviar Campanhas">
	<a href="campanhas_cadastro_de_email.jsp">Cadastro</a>
</form>
</div>
${msg}

<form action="Controle?cmd=campanhaGravar" method="post">
<div class="container">
	<table class="table table-borderless table-dark">
		<tr>
			<td valign="top"><input type="text" name="nome" placeholder="Nome campanha" class="form-control"></td>
			<td><textarea name="texto" rows="5" cols="90" placeholder="Escreva o conteúdo do email." class="form-control"></textarea> </td>
			<td><button class="btn btn-success btn-sm">Gravar</button></td>
			
		</tr>
	</table>
</div>
</form>
<div class="container">
<form action="Controle?cmd=campanhaUpdate">
	<table class="table table-bordered table-striped">
		<tr>
			<td>id</td>
			<td>Nome</td>
			<td>Texto</td>
			<td align=center>Ação</td>
			

		</tr>
		<c:forEach items="${mng.lista5}" var="linha">
		<tr style="">
			<td>${linha.id}</td>
			<td>${linha.nome}</td>
			<td>${linha.texto}</td>
			<td align="center" valign="middle">
				<a href="campanhas_atualizar.jsp?id=${linha.id}" title="Atualizar"><i class="material-icons">update</i></a>
				<hr/>
				<a href="deletar_campanha.jsp?id=${linha.id}" title="Deletar"><i class='far fa-trash-alt'></i></a>
			</td>
		</tr>
		</c:forEach>
	</table>
</form> 
</div>
</div>

</body>
</html>
<%}if(session.getAttribute("nome").equals(null)){
	response.sendRedirect("http://google.com");
}else{} %>
