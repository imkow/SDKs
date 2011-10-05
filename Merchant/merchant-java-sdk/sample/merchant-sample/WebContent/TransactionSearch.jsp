<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Calendar"%>
<%@ page language="java"%>

<%
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	Calendar startDate = Calendar.getInstance();
	startDate.add(Calendar.DATE, -1);
	Calendar endDate = Calendar.getInstance();
%>

<html>
<head>
<title>PayPal SDK - GetTransactionDetail</title>
</head>
<body>
<form method="POST">
<center>
<font size=2 color=black face=Verdana><b>Transaction Search</b></font>
<br/><br/>
<table width=500>
	<tr>
		<td align=right><b>Start Date:</b></td>
		<td align=left><input type="text" name="startDateStr"
			value=<%=df.format(startDate.getTime())%>></td>
		<td>(Required)</td>
	</tr>

	<tr>
		<td></td>
		<td>MM/DD/YYYY</td>
	</tr>

	<tr>
		<td align=right><b>End Date:</b></td>
		<td align=left><input type="text" name="endDateStr"
			value=<%=df.format(endDate.getTime())%>></td>
	</tr>

	<tr>
		<td></td>
		<td>MM/DD/YYYY</td>
	</tr>

	<tr>
		<td align=right><b>Transaction ID: </b></td>
		<td align=left><input type="text" name="transactionID"></td>
	</tr>

	<tr>
		<td />
		<td align=left><br>
		<input type="Submit" value="Submit"></td>
	</tr>
</table>
 
 <table align="left"><tr><td>
 <a href='index.html'><b>Home</b></a>
 </td></tr></table>
  
</center>
</form>
</body>
</html>
