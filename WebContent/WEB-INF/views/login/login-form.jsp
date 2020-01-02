<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
		<c:url value="resources/image/img_avatar2.png" var="login"/>
		
		<style>
			body {font-family: Arial, Helvetica, sans-serif;}
			form {border: 3px solid #f1f1f1;}
			
			input[type=text], input[type=password] {
			  width: 100%;
			  padding: 12px 20px;
			  margin: 8px 0;
			  display: inline-block;
			  border: 1px solid #ccc;
			  box-sizing: border-box;
			}
			
			button {
			  background-color: #4CAF50;
			  color: white;
			  padding: 14px 20px;
			  margin: 8px 0;
			  border: none;
			  cursor: pointer;
			  width: 100%;
			}
	
			.imgcontainer {
			  text-align: center;
			  margin: 24px 0 12px 0;
			}
			
			img.avatar {
/* 			  width: 40%; */
			  border-radius: 50%;
			}
			
			.container {
			  padding: 16px;
			}
			
			span.senha {
			  float: right;
			  padding-top: 16px;
			}			
		</style>			
			
		
		
	</head>
	<body>	
		<c:import url="../tarefa/cabecalho.jsp"></c:import>
	
	
		<h2>Login</h2>
		
		<form:errors path="usuario.usuario"/>
		<form action="loginUsuario" method="post">
		  <div class="imgcontainer">
		    <img src="${login}" alt="Avatar" class="avatar">
		  </div>
		
		  <div class="container">
		    <label for="usuario"><b>Usuario</b></label>
		    <input type="text" placeholder="Digite o usuario" name="usuario">
		
		    <label for="senha"><b>Senha</b></label>
		    <input type="password" placeholder="Digite a sua senha" name="senha" required>
		        
		    <button type="submit">Entrar</button>
	
		  </div>
		</form>	
	
		<c:import url="../tarefa/rodape.jsp"></c:import>
	
	
	</body>
</html>