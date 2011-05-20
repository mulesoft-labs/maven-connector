Mule Maven Connector
====================

Maven is a tool used for building and managing any Java-based project. This connector will let you
        execute Maven goals.

Installation
------------

The connector can either be installed for all applications running within the Mule instance or can be setup to be used
for a single application.

*All Applications*

Download the connector from the link above and place the resulting jar file in
/lib/user directory of the Mule installation folder.

*Single Application*

To make the connector available only to single application then place it in the
lib directory of the application otherwise if using Maven to compile and deploy
your application the following can be done:

Add the connector's maven repo to your pom.xml:

    <repositories>
        <repository>
            <id>muleforge-releases</id>
            <name>MuleForge Releases Repository</name>
            <url>https://repository.mulesoft.org/releases/</url>
            <layout>default</layout>
        </repsitory>
    </repositories>

Add the connector as a dependency to your project. This can be done by adding
the following under the dependencies element in the pom.xml file of the
application:

    <dependency>
        <groupId>org.mule.modules</groupId>
        <artifactId>mule-module-maven</artifactId>
        <version>1.6-SNAPSHOT</version>
    </dependency>

Configuration
-------------

You can configure the connector as follows:

    <maven:config directory="value"/>

Here is detailed list of all the configuration attributes:

| attribute | description | optional | default value |
|:-----------|:-----------|:---------|:--------------|
|name|Give a name to this configuration so it can be later referenced by config-ref.|yes||
|directory||no|



Execute Goal
------------

Executes a Maven goal
<p/>


    
    <maven:execute-goal goal="install">
    <maven:properties>
    <maven:property key="maven.test.skip" value="true"/>
    </maven:properties>
    </maven:execute-goal>
    

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|goal|              Name of the goal to execute (eg javadoc:javadoc)|no||
|properties|        Environment properties|yes||
|overrideDirectory| Name of the directory containing your pom.xml|yes||















