<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Adicionar Tarefa</title>
	</head>
	<body>
	
		<c:import url="cabecalho.jsp"></c:import>
	
		<h2>Adicionar Tarefa</h2>
		
		<form:errors path="tarefa.descricao"/>	
		<form action="adicionaTarefa" method="post">
			<label for="descricao">Descricao</label><br> 
			<textarea rows="5" cols="100" name="descricao"></textarea>
			<br/><br/>
			<input type="submit" value="Gravar">		
		</form>
		
		<c:import url="rodape.jsp"></c:import>
		
	</body>
</html>