<%@page import="entidade.EnviarEmail"%>
	
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Enviar Email</title>
    </head>
    <body>
        <h1>Enviar email a todos os consolidadores.</h1>
        <div class="panel-heading">
                Por favor, preencha os campos abaixo:<p>
            </div>
            <div class="panel-body">
            
                <form action="Controle?cmd=email" method="post">
                    <div class="col-lg-12">
						
						<div class="form-group">
                            <label>Destino:</label><br/>
                            <input class="form-control" type="text" name="destino" required tabindex="1"/><br/>
                        </div>
                        
						<div class="form-group">
                            <label>Campo Assunto:</label><br/>
                            <input class="form-control" type="text" name="titulo" required tabindex="1"/><br/>
                        </div>
                        
                        <div class="form-group">
                            <label>Mensagem</label><br/>
                            <textarea rows="5" cols="50" name="texto" tabindex="6"></textarea><br/>
                        </div>
                        
                        <div class="form-group">
                            <label>Quantos emails?</label> <input class="form-control" type="number" name="quantidade" required tabindex="1"/><br/>
                        </div>
                    </div>
                    
                    <div class="col-lg-12">
                        <button class="btn btn-primary btn-sm"> Enviar</button>
                    </div>
                </form>

            </div>
			<%if (request.getAttribute("mensagemUsuario")!= null) {%>
                <div>
                    ${mensagemUsuario}
                </div>
            <%}%>

    </body>
</html>
