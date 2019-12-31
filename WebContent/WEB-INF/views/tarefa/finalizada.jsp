<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<td>${tarefa.id}</td>
	<td>${tarefa.descricao }</td>
	<td>Tarefa FINALIZADA</td>
	<td><fmt:formatDate	value="${tarefa.dataFinalizacao.time }"
						pattern="dd/MM/yyyy"/>					
	</td>					
	<td><a href="removeTarefa?id=${tarefa.id}">Excluir</a></td>
	<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a>
 		

