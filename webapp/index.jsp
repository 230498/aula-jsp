<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">

<title>Aula JSP</title>

<style type="text/css">
body {
	font-family: "Trebuchet MS", Helvetica, sans-serif;
	background: #643d87 url(assets/fundo.jpg) no-repeat top center;
}

input {
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

#container {
	width: 400px;
	height: 300px;
	background-color: rgba(255, 255, 255, 0.3);
	border-radius: 10px;
	margin: 0 auto;
	margin-top: 120px;
	text-align: center;
}

#container img {
	width: 120px;
	height: 120px;
	margin-top: -60px;
	margin-bottom: 30px;
}

div {
	color: black;
	background-color: #f79300;
	padding: 5px 20px;
	height: 45px;
	width: 90%;
}

input.submit {
	color: black;
	background-color: #f79300;
	padding: 5px 20px;
	height: 45px;
	width: 90%;
}
</style>
</head>

<!------------------------------------------------------------------------------------->

<body>


	<div id="container">

		<img src="assets/perfil.png">

		<form action="ServletLogin" method="post">
			<input type="hidden" value="<%=request.getParameter("url")%>"
				name="url">
			<table>
				<tr>
					<td><label>Login</label></td>
					<td><input name="login" type="text"
						placeholder="Digite seu Login"></td>
				</tr>

				<tr>
					<td><label>Senha</label></td>
					<td><input name="senha" type="password"
						placeholder="Digite sua Senha"></td>
				</tr>
				<tr>

					<td />

					<td><input class="submit" type="submit" value="Logar"></td>

				</tr>
			</table>

		</form>
	</div>

	<h4 style="text-align: center;">${msg}</h4>

</body>

</html>