PayPal C# Merchant SDK
======================

Prerequisites
-------------

PayPal's C# Merchant SDK requires 

 * Visual Studio 2005
 * NUnit 2.5.10.11092 (only for running the test cases) 
  

Using the SDK
-------------

To use the SDK, 

 * Copy the SDK DLL file into your project and add a reference.
 * Create a service wrapper object
 * Create a request object as per your project's needs. All the API request and response classes are available in PayPalAPIInterfaceServiceStubs.cs
 * Invoke the appropriate method on the request object.


For example,

	using PayPal.PayPalAPIInterfaceService;
	using PayPal.PayPalAPIInterfaceService.Model;


	CreatePayPalAPIInterfaceServiceRequest req = new CreatePayPalAPIInterfaceServiceRequest();
	req.PayPalAPIInterfaceService = new PayPalAPIInterfaceService(..);
	......

	PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
	TransactionSearchResponseType cir = service.TransactionSearch(cr);
 
	if(cir.ack == AckCode.SUCCESS) {
		// Success
	}
  
 

SDK Configuration
-----------------

The SDK DLL uses the Web.Config files. You can use the configuration file to configure

 * (Multiple) API account credentials.
 * Service endpoint and other HTTP connection parameters 


A sample configuration file has been provided with the unit tests. Adding PayPal specific configuration items to the App.Config/Web.Config file involves two steps

 * Adding a configSection to your config file

    &lt;configSections&gt;

      &lt;section name="paypal" type="PayPal.Manager.SDKConfigHandler, PayPal_Merchant_SDK" /&gt;

    &lt;/configSections&gt;

 * Adding the actual configuration 

    &lt;paypal&gt;  

      &lt;settings&gt;...&lt;/settings&gt;

      &lt;accounts&gt;

      &lt;account .../&gt;

      &lt;/accounts&gt;

    &lt;/paypal&gt;