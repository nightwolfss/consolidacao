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
<link rel="shortcut icon" href="IMG\icone.ico" type="image/x-icon" />

<link rel="stylesheet" type="text/css" href="CSS\estilo.css">
<link href='https://fonts.googleapis.com/css?family=Calligraffitti' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Bad Script' rel='stylesheet'>

<script src="js/jquery-3.2.1.min.js"></script>
	<!--  jquery UI -->
<script src="js/jquery-ui-1.12.1/jquery-ui.min.js" > </script>
	
<link href="js/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" />	

<script>
$(document).ready(function(){
	$("#piscar").fadeOut("slow");
  	$("#piscar").fadeIn("slow");
  	$("#piscar").fadeOut("slow");
  	$("#piscar").fadeIn("slow");
  	$("#piscar").fadeOut("slow");
  	$("#piscar").fadeIn("slow"); 
  	$("#piscar").slideUp();
  	$("#piscar").slideDown();
  	
  	$("#piscar").fadeIn("slow");
  	$("#piscar").fadeOut("slow");
  	$("#piscar").fadeIn("slow");
  	
  	$("#piscar").click(function(){
		$("#piscar").slideUp();
	});
  	
  	$("#lo").hide();
  	$("#but").click(function(){
		$("#lo").fadeIn(1000);
	});
  	
});
</script>

<title>Cadastro</title>
</head>

<body>
	<div class="tudo">
		<div class="cabecalho">
			<div class="form-group has-success col-auto">Cadastre-se Já!! </div>
		</div>

		<table>
			<tr>
				<td class="form-group has-success col-auto">
					<div class="texto"> Preencha o
					formulário e receba dicas diáriamente!! Não perca tempo!!
					</div>
				</td>
			</tr>
		</table>
		<br /> <br />
		
		<form action="Controle?cmd=cademail" method="post">
		
		<table>
			<tr>
				<td class="form-group has-success col-auto">
						<div class="input-group-prepend">
							<span class="input-group-text" id="basic-addon2">Nome</span>
						</div>
				</td>
				<td>
					<input type="text" class="form-control" name="nome" aria-label="Username" aria-describedby="basic-addon1" required="required">
				</td>
			</tr>
			<tr>
				<td class="form-group has-success col-auto">
					  <div class="input-group-append">
					  	<span class="input-group-text" id="basic-addon2">Sobrenome</span>
					  </div>
				</td>
				<td>
					<input type="text" class="form-control" name="sobrenome" aria-label="Sobrenome" aria-describedby="basic-addon2" required="required">
				</td>
			</tr>
			<tr>
				<td class="form-group has-success col-auto">
						<div class="input-group-prepend">
							<span class="input-group-text" id="basic-addon2">Email</span>
						</div>
				</td>
				<td>
						<div class="input-group-append">
						<input type="email" class="form-control" name="email" aria-label="Email" aria-describedby="basic-addon2" required="required">
					</div></td>
			</tr>
		</table>
		
		<br />
		<br />
		<div class="form-group has-success col-auto">
			<button name="Cadast" type="submit" class="btn btn-info btn-sm" id="but">Cadastrar</button>
			<pa><img src="https://loading.io/spinners/coolors/lg.palette-rotating-ring-loader.gif" width="50px" height="50px" id="lo"></pa>
		</div>
		<div align="center">
			<img alt="imagem" src="http://www.brownspiders.com.br/wp-content/uploads/2017/02/logobs-stickymobile-retina.png" width="360px" height="100px">
		</div>
		
		<br/>
		<center><strong><font color = green><span id="piscar">${mensagem}</span></font></strong></center>
		<br/>
		
		</form>
	</div>

	<script>
	$("#button").click(function){
		$("pa").fadeIn();
	}
	</script>


</body>
</html>
