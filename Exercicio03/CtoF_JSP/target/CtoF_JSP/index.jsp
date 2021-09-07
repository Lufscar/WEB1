<html>
	<head>
		<title>Celsius2Farenheint</title>
		<meta charset="UTF-8">
	</head>
	<body>
		       <a href="en_index.jsp">
					<input type="button" value="Change Language to English">
			   </a>
	
		<form name="Conversion" action="CtoF_JSP.jsp" method="POST">
		     <fieldset>
		       <legend>Conversao Celsius - Farenheint</legend>
		       Valor Minimo: <input type="number" name="minVal" /> <br/>
		       Valor Maximo: <input type="number" name="maxVal" /> <br/>
		       Valor de Incremento: <input type="number" name="incVal" /> <br/>

		       <input type="submit" name="enviar" value="Solicita a Conversao" />
	
		     </fieldset>
		 </form>
	</body>
</html>