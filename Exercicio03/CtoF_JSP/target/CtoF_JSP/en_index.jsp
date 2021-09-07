<html>
	<head>
		<title>Celsius2Farenheint</title>
		<meta charset="UTF-8">
	</head>
	<body>
		       <a href="index.jsp">
					<input type="button" value="Mudar Lingua Para Portugues Brasileiro">
			   </a>
	
		<form name="Conversion" action="CtoF_JSP.jsp" method="POST">
		     <fieldset>
		       <legend>Celsius - Farenheint Conversion</legend>
		       Minimum Value: <input type="number" name="minVal" /> <br/>
		       Maximum Value: <input type="number" name="maxVal" /> <br/>
		       Increment Value: <input type="number" name="incVal" /> <br/>

		       <input type="submit" name="enviar" value="Request the Conversion" />
	
		     </fieldset>
		 </form>
	</body>
</html>