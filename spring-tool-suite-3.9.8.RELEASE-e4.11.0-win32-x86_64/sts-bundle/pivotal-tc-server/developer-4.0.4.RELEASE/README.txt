Pivotal tc Server Developer Edition
Version: 4.0.4.RELEASE
Build Date: 20181128232625

You have downloaded the tc Server Developer Edition.  This edition of tc Server 
is made up of the following features:

	* The tc Runtime application server.
	* Supporting utilities for creating and starting tc Runtime instances.
	* Templates for creating specific types of tc Runtime server instances,
            such as SSL- or cluster-enabled.
	* Spring Insight, an application that provides you with real-time 
            visibility into the behavior and performance of your applications.

How Do I Get Started?
---------------------
To begin using tc Server, a server instance must be created.  This can be done 
using the tcserver command.  First, identify and create an "instance directory" 
for your instances. Then, for Unix based OSes, the following can be run to 
setup a basic instance that is capable of handling both HTTP and HTTPS:

        * tcserver create --template nio --template nio-ssl \
            --instances-directory <instances-directory> example-instance

This will create a directory in the specified instance directory called 
example-instance. Not specifying the --instances-directory property will create 
the instance in the current working directory, this is not recommended. The 
README.txt in that directory will explain specific details about the instance.  
To start this instance, use tcserver start

        * tcserver start --instances-directory start example-instance

Once the instance has started, the instance will be available at 
http://localhost:8080 or https://localhost:8443.

tc Server has many other templates available to customize the instance creation 
process.  See the "Getting Started with tc Server" Guide for conceptual 
information about tc Server and its different editions (including this 
Developer Edition), as well as installation and usage instructions.

	* tc Server Documentation: 
            http://tcserver.docs.pivotal.io/docs/index.html

Additional Information
-----------------------
See the following links for additional information about the tc Server Standard 
Edition:

	* Product Information: http://pivotal.io/app-suite
	* General tc Server Documentation: 
            http://tcserver.docs.pivotal.io/docs/index.html
	* tc Server Discussion Forum: 
            http://www.stackoverflow.com/questions/tagged/tcserver
