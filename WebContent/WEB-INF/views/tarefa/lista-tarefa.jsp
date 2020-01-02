<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Lista de Tarefas</title>
	</head>
	
	<script type="text/javascript" src="resources/js/jquery.js"></script>
	
	<body>
	
		<c:import url="cabecalho.jsp"></c:import>
	
		<h2>Lista de Tarefas - Usuario: ${usuarioLogado.usuario}</h2>		
		<hr />
	
		<a href="novaTarefa">Incluir Nova Tarefa</a><br><br><br>

		
		<table border=1>
			<tr>
				<th>ID</th>
				<th>Descricao</th>
				<th>Tarefa Finalizada?</th>
				<th>Data Finalizacao</th>
			</tr>
			<c:forEach var="lista" items="${lista}">
				<tr id="tarefa_${lista.id}">
					<td>${lista.id}</td>
					<td>${lista.descricao }</td>
					<c:if test="${lista.finalizado eq false}">			
						<td><a href="#" onClick="finalizaTarefa(${lista.id})">Finalizar Tarefa</a></td>
						<td></td>
					</c:if>
					<c:if test="${lista.finalizado eq true }">
						<td>Tarefa FINALIZADA</td>
						<td><fmt:formatDate
								value="${lista.dataFinalizacao.time }"
								pattern="dd/MM/yyyy"/>					
						</td>					
					</c:if>		
					<td><a href="removeTarefa?id=${lista.id}">Excluir</a></td>
					<td><a href="mostraTarefa?id=${lista.id}">Alterar</a> 		
				</tr>
			</c:forEach>		
		</table>		

		<br /><br />		
		<a href="desconectarUsuario">Desconectar Usuario</a>
		
	
		<script type="text/javascript">		
			function finalizaTarefa(id){
				$.post("finalizaTarefa", {'id' : id }, function(resposta){				
					$("#tarefa_" + id).html(resposta)					
				})
			}		
		</script>
		
		<c:import url="rodape.jsp"></c:import>
		
	
	</body>
</html>