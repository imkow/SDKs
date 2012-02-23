PayPal C# Adaptive Accounts SDK
================================

Prerequisites
-------------

PayPal's C# Adaptive Accounts SDK requires 

 * Visual Studio 2005
 * NUnit 2.5.10.11092 (only for running the test cases) 


Contents
--------

   * PayPal_AdaptiveAccounts_SDK - The SDK library project
   * Samples - Web samples demonstrating SDK usage
   * Unit_Testing - Unit tests


Using the SDK
-------------

To use the SDK, 

 * Copy the SDK DLL file into your project and add a reference.
 * Create a service wrapper object
 * Create a request object as per your project's needs. All the API request and response classes are available in AdaptiveAccountsModel.cs
 * Invoke the appropriate method on the request object.


For example,

	using PayPal.AdaptiveAccounts;
	using PayPal.AdaptiveAccounts.Model;


	CreateAccountRequest req = new CreateAccountRequest();
	req.AddressType = new AddressType();
	......

	AdaptiveAccountsService service = new AdaptiveAccountsService();
	CreateAccountResponse cir = service.CreateAccount(cr);
 
	if(cir.responseEnvelope.ack == AckCode.SUCCESS) {
		// Success
	}
  
 

SDK Configuration
-----------------

The SDK DLL uses the App.Config/Web.Config files. You can use the configuration file to configure

 * (Multiple) API account credentials.
 * Service endpoint and other HTTP connection parameters 


A sample configuration file has been provided with the unit tests. Adding PayPal specific configuration items to the App.Config/Web.Config file involves two steps

 * Adding a configSection to your config file

    &lt;configSections&gt;

      &lt;section name="paypal" type="PayPal.Manager.SDKConfigHandler, PayPal_AdaptiveAccounts_SDK" /&gt;

    &lt;/configSections&gt;

 * Adding the actual configuration 

    &lt;paypal&gt;  

      &lt;settings&gt;...&lt;/settings&gt;

      &lt;accounts&gt;

      &lt;account .../&gt;

      &lt;/accounts&gt;

    &lt;/paypal&gt;



FAQ
---

  * Can the SDK be used in applications configured with Medium trust level?

     To use the SDK in an application that runs in the medium trust level, you will need to configure appropriate WebPermissions to allow outbound 
HTTP connection to PayPal's API servers

    <trust level="Medium" originUrl="https://svcs.sandbox.paypal.com/.*" />

* Why does logging not work in my application ?

     * Ensure log4net configuration is correct in your App/Web.Config file. You can refer to the config file in the sample project.
     * Check that you have write permissions to the target folder. 
     * Ensure that you configure the log4net system. You can do this, for example, by adding the following line to your Global.asax.cs file
		log4net.Config.XmlConfigurator.Configure();

