<h4>Configuration</h4>
<p>
	Configuration is stored in the Application.cfc file.  You'll want to customize the 
	following variables.
	<table>
		<thead>
			<tr>
				<th width="150px">variable</th>
				<th>description</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>customTagPath</td>
				<td>Map this to the PayPal lib and services folder for Adaptive Payments<</td>
			</tr>
			<tr>
				<td>PayPal API credentials</td>
				<td>Create an account at <a href="developer.paypal.com">developer.paypal.com</a> and create your Sandbox creidentials
				<p>
					
				<ul>
					<li>X-PAYPAL-SECURITY-USERID</li>
					<li>X-PAYPAL-SECURITY-PASSWORD</li>
					<li>X-PAYPAL-SECURITY-SIGNATURE</li>
				</ul>
				</p>
				</td>
			</tr>
			<tr>
				<td>Application ID</td>
				<td>The X-PAYPAL-APPLICATION-ID is set to the sandbox app id (APP-80W284485P519543T).  You'll need to submit
				your  application for review prior to launching.  Upon approval you'll receive a production
				application id.</td>
			</tr>
			<tr>
				<td>PayPal API URL</td>
				<td>The PAYPAL-API-URL variable point to the sandbox, you'll want to update this when you deploy to the live server.</td>
			</tr>
			<tr>
				<td>PayPal Redirect URL</td>
				<td>The PAYPAL-REDIRECT-URL variable point to the sandbox, you'll want to update this when you deploy to the live server.</td>
			</tr>
			<tr>
				<td>Version</td>
				<td>The PAYPAL-VERSION is currently set to 85</td>
			</tr>
		</tbody>
	</table>
	<ul>

	</ul>
	
</p>
<script src="https://gist.github.com/1677721.js?file=gistfile1.cfm"></script>
