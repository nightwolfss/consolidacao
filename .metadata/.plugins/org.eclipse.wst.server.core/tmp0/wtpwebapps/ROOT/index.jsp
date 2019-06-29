<%@page import="java.util.Calendar"%>
<% 
if(session.getAttribute("usuario")!=null){
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<style type="text/css">

.topo{
	background: #EEEED1;
}
.div1{
	padding: 1%;
	height: auto;
	
}


</style>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="shortcut icon" href="IMG\icone.ico" type="image/x-icon" />
 
 <script src="js/jquery-3.2.1.min.js"></script>
	<!--  jquery UI -->
	<script src="js/jquery-ui-1.12.1/jquery-ui.min.js" > </script>
	
<link href="js/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" />	
	<!--  JS code -->

<script>
         $(function() {
        	 $.datepicker.setDefaults(
  			  $.extend(
  			    {"dateFormat":"dd/mm/yy"},
  			    $.datepicker.regional["pt"]
  			  )
  			);        	 
            $( "#nascimento" ).datepicker({
            	changeMonth: true,
                changeYear: true,
                yearRange: '1900:',
                dayNamesMin: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
                monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
                monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro']

            });
           // $( "#nascimento" ).datepicker("show");
            
            $("#form").submit(function(obj){
            	
            	return true
            })
            
         });
</script>
 
<title>Cadastro da Consolidação</title>
</head>

<body>
<%if(session.getAttribute("msg")!=null){%>
<%}else{%>

<div class="topo">
	<marquee>${msg}</marquee>
</div>

<%}%>

<div class="div1">
<h2>Consolidação - Cadastro</h2>

		
Olá <font color="red"><b>${usuario}</b></font>, seja bem-vindo(a).

<table>
		<tr>
		<% String admin = "s";
		if(session.getAttribute("admin")!=admin){ %>
			<td><form action="Controle?cmd=logout" method="post"><button type="submit" class="btn btn-danger btn-sm" title="Sair do Sistema">logoff</button></form></td>
			<td><form action="Controle?cmd=cadastraralmas" method="post"><button type="submit" class="btn btn-warning btn-sm" title="Cadastrar Consolidados">cadastrar almas</button></form></td>
		<%}if(session.getAttribute("admin").equals(admin)){ %>
			<td><form action="Controle?cmd=consultarconsolidadores" method="post"><button type="submit" class="btn btn-warning btn-sm" title="Consultar Lista de Consolidadores">consolidadores</button></form></td>
			<td><form action="Controle?cmd=acessoadmin" method="post"><button type="submit" class="btn btn-warning btn-sm" title="Conceder acesso de Administrador">admin</button></form></td>
		<%} %>
		</tr>
	</table>

	
	
		<h3>Informe seus dados:</h3>

		<form action="Controle?cmd=gravar" method="post" enctype="multipart/form-data">
			<table border="0" bgcolor="#E8E8E8" class="table table-sm table-dark">
				<tr>
					<th align="left"><label for="exampleInputEmail1">Nome</label></th>
					<td><input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="nome"
						placeholder="Digite seu Nome Completo" maxlength="50" required="required"/></td>
				</tr>
				<tr>
					<th align="left">Idade:</th>
					<td><input type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="idade"
						placeholder="ex.: 35" required="required"/></td>
				</tr>
				<tr>
					<th align="left">Nascimento:</th>
					<td><input type="text" class="form-control" id="nascimento" aria-describedby="emailHelp" name="aniversario"
					placeholder="ex.: 01/01/2000" maxlength="10" required="required"/></td>
				</tr>
				<tr>
					<th align="left">Tribo:</th>
					<td><select name="tribo" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
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

					</select></td>
				</tr>
				<tr>
					<th align="left">Batizado?</th>
					<td><select name="batizado" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
							<option name="---">--Selecione--</option>
							<option value="SIM">Sim</option>
							<option value="NÃO">Não</option>
					</select></td>
				</tr>
				<tr>
					<th align="left">Email:</th>
					<td><input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email"
						placeholder="ex.: consolidar@apascentar.com.br"
						required="required"/></td>
				</tr>
				<tr>
					<th align="left">Telefone:</th>
					<td><input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="telefone"
						placeholder="ex.: 21 98765432" maxlength="12" required="required"/></td>
				</tr>
				<tr>
					<th align="left">Já foi ao Retiro?</th>
					<td><select name="retiro" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
							<option value="---">--Selecione--</option>
							<option value="SIM">Sim</option>
							<option value="NÃO">Não</option>
					</select></td>
				</tr>
				
				<%Calendar cal = Calendar.getInstance(); %>
				
				<tr>
					<th align="left">Quando foi ao Retiro?</th>
					<td>						
						<select name="quandoretiro" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
							<option value="---">--Selecione--</option>
							<option value="Não foi">Não Fui</option>
							<c:forEach begin="1990" end="<%=cal.get(Calendar.YEAR)%>" step="1" var="i">
								<option value="${i}">${i}</option>
							</c:forEach>
						</select>
						</td>
				</tr>
				<tr>
					<th align="left">Quando entrou na <br>Consolidação?
					</th>
					<td><select name="quantotempoconsolidacao" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
							<option value="---">--Selecione--</option>
							<c:forEach begin="1990" end="<%=cal.get(Calendar.YEAR)%>" step="1" var="i">
								<option value="${i}">${i}</option>
							</c:forEach>

					</select></td>
				</tr>
				<tr>
					<th align="left">Qual escola de <br>Servos? Faz?</th>
					<td><select name="servos" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
							<option value="---">--Selecione--</option>
							<option value="NÃO FEZ">Não Fiz</option>
							<option value="Servos 2">Servos 2</option>
							<option value="Servos 3">Servos 3</option>
							<option value="Servos 4">Servos 4</option>
							<option value="Servos 5">Servos 5</option>
							<option value="Raízes">Raízes</option>
					</select></td>
				</tr>
				<tr>
					<td>Foto</td><td><input type="file" id="file" accept=".jpg, .jpeg, .png" name="imagem"/>
					</td>
				</tr>
			</table>
			<br> 
			
			<table>
				<tr>
					<td><button type="submit" class="badge badge-dark">apagar</button></td>
					<td><button type="submit" class="badge badge-info">enviar formulário</button></td>
				</tr>
			</table>
		</form>
	
</div>
</body>
</html>

<%} else{
	request.setAttribute("login", "Login inválido!!");
	request.getRequestDispatcher("login.jsp").forward(request, response);
}

%>