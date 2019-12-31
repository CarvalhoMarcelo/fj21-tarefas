<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ attribute name="identificador" required="true" %>
<%@ attribute name="data" %>
<%@ attribute name="completar" %>

<input type="text" 
       name="${identificador}" 
       id="${identificador}"
       value="${data}" 
       autocomplete="${completar}"/>

<script type="text/javascript">
	$("#${identificador}").datepicker({
		changeMonth: true,
		changeYear: true,
		showButtonPanel: true,
		yearRange: "-100+0",		
		dataFormat: 'dd/MM/yyyy'});
</script>
