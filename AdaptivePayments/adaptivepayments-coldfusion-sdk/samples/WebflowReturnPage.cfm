<!DOCTYPE html>

<head >
    <title>Paypal Pladform SDK - Webflow Common Return Page</title>
    <link href="Common/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<br/>
<div id="jive-wrapper">
           

<cfinclude template="Common/menu.html" >

<div id="request_form">

<div>
<center><h3><b>Paypal Platform SDK - Webflow Return Page</b></h3></center>
<br/>

<table align="center" width="60%">
	<tr>
		<td colspan="2">
			<center><h5>You are returned here from a web flow</h5></center>
		</td>
	</tr>

	<cfdump var="#URL#" >

</table>
</div>
</div>
</div>
</body>
</html>

