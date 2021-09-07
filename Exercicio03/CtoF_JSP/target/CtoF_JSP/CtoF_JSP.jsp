<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>CtoF_JSP</title>
	</head>
	<body>
		<%
			String minVal = request.getParameter("minVal");
			int min = (minVal == null || minVal.isEmpty()) ? -100 : Integer.parseInt(minVal);
		
			String maxVal = request.getParameter("maxVal");
			int max = (maxVal == null || maxVal.isEmpty()) ? 100 : Integer.parseInt(maxVal);
		
			String incVal = request.getParameter("incVal");
			int inc = (incVal == null || incVal.isEmpty()) ? 5 : Integer.parseInt(incVal);
		%>
		
		<table border=1>
			<tr>
				<th>Celsius</th>
				<th>Fahrenheit</th>
			</tr>
			
			<%
				for (int celsius = min; celsius <= max; celsius += inc) {
					double fahr = 1.8 * celsius + 32;
			%>
			<tr>
				<td> <%= celsius %> </td>
				<td> <%= fahr %> </td>
			</tr>
			<% } %>
		</table>
	</body>
</html>