<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Produtos</title>


<style type="text/css">

body {
	font-family: "Trebuchet MS", Helvetica, sans-serif;
	background: #643d87 url(assets/fundo.jpg) no-repeat top center;
}


div {
	color: black;
	background-color: #f79300;
	padding: 5px 20px;
	height: 45px;
	width: 90%;
}
input.submit1 {
	height: 40px;
	width: 80%;
	font-size: 18px;
	margin-bottom: 10px;
	background-color: #fff;
	padding-right: 20px;
	padding-left: 20px;
	border: none;
	background-repeat: no-repeat;
	background-position: 10px;
}

input.submit {
	color: black;
	background-color: #f79300;
	padding: 5px 20px;
	height: 45px;
	width: 90%;
}

#container {
	width: 400px;
	height: 300px;
	background-color: rgba(255, 255, 255, 0.3);
	border-radius: 10px;
	margin: 0 auto;
	margin-top: 120px;
	text-align: center;
}
a{
color:white
}


</style>



</head>

<body>


<div id="container">

	<h1>Cadastro de Produtos</h1>
	
	
	<form action="ServletProdutos" method="post">
		<input type="hidden" value="<%=request.getParameter("url")%>"
			name="url">
			

		<table>
			<tr>
				<td><label>Produto</label></td>
				<td><input class="submit1" name="produto" type="text" placeholder="Digite o nome do produto"></td>
			</tr>

			<tr>
				<td />
				<td><input class ="submit" type="submit" value="Cadastrar"></td>
			</tr>

		</table>
		
	</form>

	<h4>${msg}</h4>
	
</div>
	
</body>
</html>