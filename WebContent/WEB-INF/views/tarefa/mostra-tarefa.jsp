<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Atualizar Tarefa</title>
	</head>
	<body>
	
		<c:import url="cabecalho.jsp"></c:import>
	
		<h2>Alteracao da Tarefa ${tarefa.id }</h2>
		
		<form action="alteraTarefa" method="get">
		
			<input type="hidden" name="id" value="${tarefa.id }"/>
		
			<label for="descricao">Descricao</label><br/>
			<textarea rows="5" cols="100" name="descricao">${tarefa.descricao}</textarea>
			<br /><br/>
			Tarefa finalizada?			
			<input type="checkbox" name="finalizado" value="true" ${tarefa.finalizado ? 'checked' : ''}/>
			<br/><br/>
			Data da Finalizacao: 
				<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
			<br /> <br/>
			
			<input type="submit" value="Alterar"/>
				
		</form>
		
		
		
		<c:import url="rodape.jsp"></c:import>
	</body>
</html>