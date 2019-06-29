<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1" 
		pageEncoding="ISO-8859-1" session="false"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Alterar Foto</title>
<link rel="shortcut icon" href="IMG\icone.ico" type="image/x-icon" />
</head>
<body>

<form action="Controle?cmd=img" method="post" enctype="multipart/form-data">
 <div>
   Foto: <input type="file" id="file" name="imagem"/><br />
   Email: <input type="text" name="email"/>   
 </div>
 <div>
   <button>Submit</button>
 </div>
</form>

<video width="320" height="240" controls>
  <source src="C:\\Users\\Vitor10\\Downloads\\Formula1.2018.Round19.Mexico.Race.Sportv2HD.720p.x264-Wgs.mkv" type="video/mp4">
  <source src="movie.ogg" type="video/ogg">
Your browser does not support the video tag.
</video>


</body>
</html>
</jsp:root>