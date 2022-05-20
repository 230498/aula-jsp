<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Tela Principal</title>

<style type="text/css">
body {
	font-family: "Trebuchet MS", Helvetica, sans-serif;
	background: #643d87 url(assets/fundo.jpg) no-repeat top center;
}

 h1 {
	text-align: center;
}

input.submit {
	color: black;
	padding: 5px 20px;
	padding-left: 20px;
	margin-left: 40px;
}

a {
	margin-left: 40px;
}

div{
margin-left: 40px;
margin-right: 40px;
}
</style>


</head>


<body>
	<h1>Tela Principal</h1>

	<form action="ServletLogout" method="post">

		<input class="submit" type="submit" value="Sair">

	</form>
	


	<hr>
	<a style="color: White" href=principal/cadastro.jsp><b>Cadastrar
			um Produto</b></a>|

	<br>
	<br>

	<h2 style="margin-left:40px">Produtos Cadastrados</h2>

	<div>${msg}</div>



</body>
</html>