<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="urn.ebay.apis.eBLBaseComponents.ErrorType"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ErrorPage</title>
</head>
<body>
<h4>Error Page</h4>
	<%
		List<ErrorType> errorList = (List<ErrorType>) session
				.getAttribute("Error");
		for (ErrorType e : errorList) {
	%><table>
		<tr>
			<td>ShortMsg:</td>
			<td><%=e.getShortMessage()%>
		</tr>
		<tr>
			<td>LongMsg:</td>
			<td><%=e.getLongMessage()%>
		</tr>
	</table>
	<%
		}
	%>
	<a href="index.html">Home</a>
</body>
</html>