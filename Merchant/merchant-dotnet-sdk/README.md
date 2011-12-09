
PayPal Merchant SDK for .NET
============================

	The PayPal merchant SDK allows .NET developers to invoke "PayPal API's for implementing
solutions such as "Web Payments Pro", "Express Checkout", "Mass Pay" etc. While the API is described
through a publicly available WSDL document and can be invoked directly, this SDK eases the 
development process by handling some of the plumbing code such as authentication, HTTP request 
processing etc.

Contents 
--------

	The SDK download comes as a Visual Studio solution that contains 

		1. the PayPal Merchant SDK project, and 
		2. a sample C# web application that demonstrates use of the SDK. 
	
Please refer to the readme file under the sample project to understand how the sample application
can be run.


Prerequisites
-------------

   1. Microsoft .NET framework 2.0
   2. Microsoft Visual Studio 2005 Standard edition


Using the SDK
-------------

	To use the SDK in your application, you must do the following
	
	1. Create a Business/Personal account as appropriate and obtain API credentials from your
	   account profile.
	2. Add the PayPal_Merchant_SDK.dll file as a reference to your project.	   
	3. Configure the SDK through the Web.Config or App.Config file. You can refer to the config
	   file available in the sample.
	4. Invoke an api method using a similar code snippet
	
		    // Create request object and set request parameters
            DoVoidRequestType request = new DoVoidRequestType();     
            request.AuthorizationID = authorizationId.Value;
            .......            
            DoVoidReq wrapper = new DoVoidReq();
            wrapper.DoVoidRequest = request;
            
            // Invoke the API
            PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
            DoVoidResponseType doVoidResponse = service.DoVoid(wrapper);

			// Check API return status
			if(doVoidResponse.Ack.Equals(AckCodeType.FAILURE))
			{
			   .......
			}