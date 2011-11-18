<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http//www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http//www.w3.org/1999/xhtml">
<head id="head1">
<title>PayPal SDK - BillAgreementUpdate</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h3>BillAgreementUpdate</h3>
			<div id="BillAgreementUpdate">
				<p><b>The BAUpdate API operation updates or deletes a billing agreement.</b></p>
			</div>
		</div>
		<form id="form1" method="post">
			<div id="request_form">
				<div class="params">
					<div class="param_name">ReferenceID:(billing agreement ID or a reference transaction ID that is associated with a billing agreement)</div>
					<div class="param_value">
						<input type="text" name="referenceID" value="" />
					</div>
				</div>
				<div class="params">
					<div class="param_name">BillingAgreement Status:</div>
					<div class="param_value">
						<select name="billingAgreementStatus">
							<option value="Active">ACTIVE</option>
							<option value="Canceled">CANCELED</option>
						</select>
					</div>
				</div>
				<div class="params">
					<div class="param_name">BillingAgreement Description:</div>
					<div class="param_value">
						<textarea name="billingAgreementDescription" rows="10" cols="50"></textarea>
					</div>
				</div>
				<div class="submit">
					<input id="Submit1" type="submit" name="submit" value="submit" /><br />
				</div>
				<a href="/merchant-sample/index.html">Home</a>
			</div>
		</form>
		<div id="relatedcalls">
			See also:
			<ul>
			   <li><a href="RT/GetBillingAgreementCustomerDetails"></a>GetBillingAgreementCustomerDetails</li>
			</ul>
		</div>
	</div>
</body>
</html>
