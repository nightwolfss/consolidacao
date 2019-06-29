<%
session.setAttribute("msg", null);
if(session.getAttribute("usuario")!=null && session.getAttribute("admin").equals("s")){
%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="persistencia.PessoaDao"%>
<%@page import="entidade.Consolidador"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	Consolidador pd = new PessoaDao().findByCode(request.getParameter("id"));
	int cont = 0;
	Date date = new Date();%>

<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:useBean id="mng" class="controle.Controle" scope="request" />

<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 <link rel="shortcut icon" href="IMG\icone.ico" type="image/x-icon" />
<style>
	th{
		cursor:pointer;
	}
	
	.div1{
		width: 100%;
		padding-left: 2%;
	}
</style>

<title>Consultar Cadastro</title>
</head>
<body>

	<h2>Consulta de Cadastro</h2>
	
	Olá ${usuario}!!
	<br />
	<br />
	
	<table>
		<tr>
		<% String admin = "s";
		if(session.getAttribute("admin")!=admin){ %>
			<td><form action="Controle?cmd=logout" method="post"><button type="submit" class="btn btn-danger btn-sm" title="Sair do Sistema">logoff</button></form></td>
			<td><form action="Controle?cmd=index" method="post"><button type="submit" class="btn btn-warning btn-sm">Início</button></form></td>			
			<td><form action="Controle?cmd=cadastraralmas" method="post"><button type="submit" class="btn btn-warning btn-sm" title="Cadastrar Consolidados">cadastrar almas</button></form></td>
		<%}if(session.getAttribute("admin").equals(admin)){ %>
			<td><form action="Controle?cmd=consultarconsolidadores" method="post"><button type="submit" class="btn btn-warning btn-sm" title="Consultar Lista de Consolidadores">consolidadores</button></form></td>
			<td><form action="Controle?cmd=acessoadmin" method="post"><button type="submit" class="btn btn-warning btn-sm" title="Conceder acesso de Administrador">admin</button></form></td>
		<%} %>
		</tr>
		
	</table>
	
	<div class="div1">
		<table border="1" bgcolor="#8FBC8F" id="tabela1" class="table-sm table-striped table-dark">
				<tr>
					<th scope="col"><b>ID</b></th>
					<th scope="col"><b>Nome</b></th>
					<th scope="col"><b>Tribo</b></th>
					<th scope="col"><b>Telefone</b></th>
					<th scope="col"><b>Alterar</b></th>
				</tr>
				
				<c:forEach items="${mng.lista}" var="linha">
					<tr>
					
						<%cont = cont + 1; %>		
						<td align="center"><input type="hidden" name="id" value="${linha.id}"/>${linha.id}</td>
						<td align="left"><input type="hidden" name="nome" value="${linha.nome}"/><font size="1px">
						<a href="alterarFull.jsp?id=${linha.id}
						&nome=${linha.nome}
						&idade=${linha.idade}
						&aniversario=${linha.aniversario}
						&tribo=${linha.tribo}
						&batizado=${linha.batizado}
						&email=${linha.email}
						&telefone=${linha.telefone}
						&retiro=${linha.retiro}
						&quandoretiro=${linha.quandoRetiro}
						&quantotempoconsolidacao=${linha.quantoTempoConsolidacao}
						&servos=${linha.servos}">${linha.nome}</a></font><br />
							<input type="hidden" name="email" value="${linha.email}"/><font size="1px">${linha.email}</font>
						</td>
						</td>
						
						<td align="center" ><input type="hidden" name="tribo" value="${linha.tribo}"/><font size="2px">${linha.tribo}</font></td>
						<td align="center"><input type="hidden" name="telefone" value="${linha.telefone}"/><font size="1px">${linha.telefone}</font></td>
						<td align="center"><a href="alterar2.jsp?id=${linha.id}
						&nome=${linha.nome}
						&idade=${linha.idade}
						&aniversario=${linha.aniversario}
						&tribo=${linha.tribo}
						&batizado=${linha.batizado}
						&email=${linha.email}
						&telefone=${linha.telefone}
						&retiro=${linha.retiro}
						&quandoretiro=${linha.quandoRetiro}
						&quantotempoconsolidacao=${linha.quantoTempoConsolidacao}
						&servos=${linha.servos}">alterar</a></td>
					</tr>
				</c:forEach>
		</table>
	</div>
		<script>
            $(document).ready(function() 
            { 
                $("#tabela1").tablesorter(); 
            } 
        ); 
        </script>

<% out.print("&nbsp;<font color='gray'><br /> " + cont + " consolidadores encontrados.</font><br /><br />");
%>

</body>
</html>
<%} else{
	request.setAttribute("msg", "Entre em contato com o Administrador para ter acesso ao CADASTRO de CONSOLIDADORES");
	request.getRequestDispatcher("index.jsp").forward(request, response);
}

%>