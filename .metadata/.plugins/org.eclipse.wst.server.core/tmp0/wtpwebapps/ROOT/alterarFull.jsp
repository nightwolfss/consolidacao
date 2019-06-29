<%if(session.getAttribute("usuario")!=null && session.getAttribute("admin").equals("s")){%>
<?xml version="1.0" encoding="UTF-8" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<link rel="shortcut icon" href="IMG\icone.ico" type="image/x-icon" />
		
<style type="text/css">
.div1{
	padding: 1%;
	height: auto;
	
}

</style>

<title>Consultar Consolidado</title>
</head>

<body>
	<form action="Controle?cmd=img" method="post" enctype="multipart/form-data">
	<div class="div1">
			<table border="1" class="table-sm table-striped table-dark">
				<tr>
					
				</tr>
				<tr>
					<td colspan="2">
					<center>
							<img alt=""	src='IMG/fotos/p - <%=request.getParameter("email")%>.jpg' width="115px" height="204px" />
					</center>
					</td>
				</tr>
				<tr>
					<td>ID:</td>
					<td><%=request.getParameter("id")%></td>
				</tr>
				<tr>
					<td>Nome:</td>
					<td><%=request.getParameter("nome")%></td>
				</tr>
				<tr>
					<td>Idade:</td>
					<td><%=request.getParameter("idade")%></td>
				</tr>
				<tr>
					<td>Nascimento:</td>
					<td><%=request.getParameter("aniversario")%></td>
				</tr>
				<tr>
					<td>Tribo:</td>
					<td><%=request.getParameter("tribo")%><br />
				</tr>
				<tr>
					<td>Batizado:</td>
					<td><%=request.getParameter("batizado")%></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><%=request.getParameter("email")%></td>
					<td><input type="hidden" name="email" value="<%=request.getParameter("email")%>"/>
				</tr>
				<tr>
					<td>Telefone:</td>
					<td><%=request.getParameter("telefone")%></td>
				</tr>
				<tr>
					<td>Retiro:</td>
					<td><%=request.getParameter("retiro")%></td>
				</tr>
				<tr>
					<td>Quando Retiro</td>
					<td><%=request.getParameter("quandoretiro")%></td>
				</tr>
				<tr>
					<td>Quanto tempo<br />Consolidando:
					</td>
					<td><%=request.getParameter("quantotempoconsolidacao")%></td>
				</tr>
				<tr>
					<td>Servos:</td>
					<td><%=request.getParameter("servos")%></td>
				</tr>
				<tr>
					<td>Foto:</td>
					<td><input type="file" id="file" name="imagem" /></td>
				</tr>
				<tr>
					<td><a href="consultar.jsp"	class="badge badge-info">Voltar</a></td>
					<td><input type="submit" /></td>
				</tr>
			</table>
		</div>
	</form>	
<!-- 	
	<table>
			<tr>
				<th bgcolor="#F5F5DC" align="left">ID:</th>
				<td><input type="text" name="id" value="<%=request.getParameter("id")%>" readonly="readonly"/></td>
			</tr>
			<tr>
				<th bgcolor="#F5F5DC" align="left">Nome:</th>
				<td><input type="text" name="nome"
					placeholder="Digite seu Nome Completo" maxlength="50" size="50"
					required="required" value="<%=request.getParameter("nome")%>"/></td>
			</tr>
			<tr>
				<th bgcolor="#F5F5DC" align="left">Idade:</th>
				<td><input type="number" name="idade" size="50"
					placeholder="ex.: 35" required="required"
					value="<%=request.getParameter("idade")%>"/></td>
			</tr>
			<tr>
				<th bgcolor="#F5F5DC" align="left">Nascimento:</th>
				<td><input type="text" name="aniversario" size="50"
					placeholder="ex.: 01/01/2000" maxlength="10" required="required"
					value="<%=request.getParameter("aniversario")%>"/></td>
			</tr>
			<tr>
				<th bgcolor="#F5F5DC" align="left">Tribo:</th>
				<td><select name="tribo">
						<option name="---">--Selecione--</option>
						<option name="Não é da Rede">Não Sou da Rede</option>
						<option name="Não Tem">Não Tenho</option>
						<option name="Aser">Aser</option>
						<option name="Benjamin">Benjamin</option>
						<option name="Benjamin 2">Benjamin 2</option>
						<option name="Dã">Dã</option>
						<option name="Efraim">Efraim</option>
						<option name="Gade">Gade</option>
						<option name="Gideão">Gideão</option>
						<option name="Issacar">Issacar</option>
						<option name="José">José</option>
						<option name="Judá">Judá</option>
						<option name="Levi">Levi</option>
						<option name="Manassés">Manassés</option>
						<option name="Naftali">Naftali</option>
						<option name="Rúben">Rúben</option>
						<option name="Simeão">Simeão</option>
						<option name="Zebulon">Zebulon</option>
						<option name="Zebulon 2">Zebulon 2</option>

				</select>
				<%=request.getParameter("tribo")%>
				</td>
			</tr>
			<tr>
				<th bgcolor="#F5F5DC" align="left">Batizado?</th>
				<td><select name="batizado">
						<option name="---">--Selecione--</option>
						<option value="SIM">Sim</option>
						<option value="NÃO">Não</option>
				</select>
				<%=request.getParameter("batizado")%>
				</td>
			</tr>
			<tr>
				<th bgcolor="#F5F5DC" align="left">Email:</th>
				<td><input type="email" name="email" size="50"
					placeholder="ex.: consolidar@apascentar.com.br" required="required"
					value="<%=request.getParameter("email")%>"/></td>
			</tr>
			<tr>
				<th bgcolor="#F5F5DC" align="left">Telefone:</th>
				<td><input type="text" name="telefone" size="50"
					placeholder="ex.: 21 98765432" maxlength="12" required="required"
					value="<%=request.getParameter("telefone")%>"/></td>
			</tr>
			<tr>
				<th bgcolor="#F5F5DC" align="left">Já foi ao Retiro?</th>
				<td><select name="retiro">
						<option value="---">--Selecione--</option>
						<option value="SIM">Sim</option>
						<option value="NÃO">Não</option>
				</select>
				<%=request.getParameter("retiro")%>
				</td>
			</tr>
			<tr>
				<th bgcolor="#F5F5DC" align="left">Quando foi ao Retiro?</th>
				<td><select name="quandoretiro">
						<option value="---">--Selecione--</option>
						<option value="Não foi">Não Fui</option>
						<c:forEach begin="1990" end="2017" step="1" var="i">
							<option value="${i}">${i}</option>
						</c:forEach>
				</select>
				<%=request.getParameter("quandoretiro")%>
				</td>
			</tr>
			<tr>
				<th bgcolor="#F5F5DC" align="left">Quando entrou na <br/>Consolidação?
				</th>
				<td><select name="quantotempoconsolidacao">
						<option value="---">--Selecione--</option>
						<c:forEach begin="1990" end="2017" step="1" var="i">
							<option value="${i}">${i}</option>
						</c:forEach>
				</select>
				<%=request.getParameter("quantotempoconsolidacao")%>
				
				</td>
			</tr>
			<tr>
				<th bgcolor="#F5F5DC" align="left">Qual escola de <br/>Servos?
						Faz? </th>
				<td><select name="servos">
						<option value="---">--Selecione--</option>
						<option value="NÃO FEZ">Não Fiz</option>
						<option value="Servos 2">Servos 2</option>
						<option value="Servos 3">Servos 3</option>
						<option value="Servos 4">Servos 4</option>
						<option value="Servos 5">Servos 5</option>
				</select>
				<%=request.getParameter("servos")%>
				</td>
			</tr>		
		</table>
		<input type="submit" value="Atualizar" />
		<br /> 
		 -->
</body>
</html>

<%} else{
	response.sendRedirect("login.jsp");
}

%>