<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Tarefas - Cabecalho</title>
		
		<style>
			img{
				width: 5%;
				height: 5%;
			}	
			
			.cab{
				display: flex;		
				align-items: center;		
			}
			
			h1{
				padding-left: 35%;
				display: block;
			}			
		</style>		
	</head>
	<body>
		<c:url value="resources/image/Agenda.png" var="logo"/>
		<div class="cab">
			<img alt="agenda" src="${logo}"/>	
			<h1>Projeto: Tarefas</h1>		
		</div>
		<hr />
		<br>
	</body>
</html>