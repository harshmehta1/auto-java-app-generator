# Java App Generator

A java project that takes in a canonical json input which describes user requirements and turns it into a java app.

## Working

This project takes in a json file as an input and generates models, repository, services and controllers based on it.

Note: Please use [this link](https://github.com/joelittlejohn/jsonschema2pojo/wiki/Reference) as a reference while creating a json file.

* To start, drop your json file in src/main/resources.
* Go to JsonReader.java class under Services package and rename the jsonFileName String to your filename (exclude the .json extension)
* Change the db url and login details in application.properties in src/main/resources to your details.
* Run the JsonReader main method.

## Detailed working

* The JsonReader main method calls "parseJson" method.
	* The parseJson method uses a library called [JsonSchema2Pojo](https://github.com/joelittlejohn/jsonschema2pojo) to generate a POJO based on the JSON file. It will generate the class, attributes, getters, setters, equals, hashcode, toString and any relationship specified in the JSON file.
	* It also uses a library I created, called [HibernateAnnotator](https://github.com/harshmehta1/HibernateAnnotator). This library annotates the files created by the above library to help with the automated table creation in the database.
* The JsonReader main method then calls a helper method to get the class name from the JsonFile
* It then calls codeGenerator that acts as a templating engine. It takes in:
	* Title - name to be used for variables/classes
	* Template - template to be used for generating code (Note: The templates must be stored in src/main/resources and must use the sample template as a reference)
	* Type - one of three types of code "Repository", "Service", "Controller" - this tells the project where to save the code
* This is called three times for Repository, Service and Controller respectively.
* That's it. The java model, repository, service and controllers are now generated!