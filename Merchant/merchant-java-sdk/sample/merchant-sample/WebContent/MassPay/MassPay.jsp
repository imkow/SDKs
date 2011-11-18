<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PayPal SDK - MassPay</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h3>MassPay</h3>
			<div id="apidetails">MassPay API operation makes a payment to
				one or more PayPal account holders.</div>
		</div>
		<form method="POST">
			<div class="params">
				<div id="request_form">
					<table class="params">
						<tr>
							<th class="param_name">Mail</th>
							<th class="param_name">Amount</th>
						</tr>
						<tr>
							<td class="param_value"><input type="text" name="mail1"
								value="enduser_biz@gmail.com" size="25" maxlength="260" /></td>
							<td class="param_value"><input type="text" name="amount1"
								value="3.00" size="25" maxlength="260" /></td>
							<td class="param_value"><input type="text"
								name="currencyCode1" value="USD" size="25" maxlength="260" /></td>
						</tr>
						<tr>
							<td class="param_value"><input type="text" name="mail2"
								value="sdk-three@paypal.com" size="25" maxlength="260" /></td>
							<td class="param_value"><input type="text" name="amount2"
								value="3.00" size="25" maxlength="260" /></td>
							<td class="param_value"><input type="text"
								name="currencyCode2" value="USD" size="25" maxlength="260" /></td>
						</tr>
						<tr>
							<td class="param_value"><input type="text" name="mail3"
								value="jb-us-seller@paypal.com" size="25" maxlength="260" /></td>
							<td class="param_value"><input type="text" name="amount3"
								value="3.00" size="25" maxlength="260" /></td>
							<td class="param_value"><input type="text"
								name="currencyCode3" value="USD" size="25" maxlength="260" /></td>
						</tr>
					</table>
					<input type="submit" name="MassPayBtn" value="MassPay" /><br />
				</div>
				<a href="index.html">Home</a>
			</div>
		</form>
		<div id="relatedcalls">
			See also
			<ul>
				<li></li>
			</ul>
		</div>
	</div>
</body>
</html>