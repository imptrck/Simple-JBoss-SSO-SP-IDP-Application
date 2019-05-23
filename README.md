#### JBoss EAP 7 Application with Picketlink SP + IDP Simple Authentication/Authorization 

First, run the 'add-picketlink-security-domains.cli' to JBoss EAP 7 CLI, then create the required 'idp-user.properties' and 'idp-roles.properties' under '${jboss.server.configuration.dir}'.

Use Maven to compile and deploy with the following command with the EAP 7 server started up:

'mvn clean package wildfly:deploy'


#### Testing the application

Access https://<ip>:<port>/sales-post/rest/test, authenticate with the user set up previously and there you go.
  
 
