/**
 * Mule Maven Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

/**
 * This file was automatically generated by the Mule Cloud Connector Development Kit
 */
package org.mule.module.maven;

import org.apache.maven.cli.MavenCli;
import org.codehaus.plexus.classworlds.ClassWorld;
import org.mule.tools.cloudconnect.annotations.Connector;
import org.mule.tools.cloudconnect.annotations.Operation;
import org.mule.tools.cloudconnect.annotations.Parameter;
import org.mule.tools.cloudconnect.annotations.Property;

import java.util.Map;

@Connector(namespacePrefix = "maven")
public class MavenConnector {
    @Property
    private String directory;

    private ClassWorld classWorld;
    private MavenCli mavenCli;

    public MavenConnector() {
        this.classWorld = new ClassWorld("plexus.core", Thread.currentThread().getContextClassLoader());
        this.mavenCli = new MavenCli(classWorld);
    }

    /**
     * Executes a Maven goal
     * <p/>
     * {@code
     * <maven:execute-goal goal="install">
     * <maven:properties>
     * <maven:property key="maven.test.skip" value="true"/>
     * </maven:properties>
     * </maven:execute-goal>
     * }
     *
     * @param goal              Name of the goal to execute (eg javadoc:javadoc)
     * @param properties        Environment properties
     * @param overrideDirectory Name of the directory containing your pom.xml
     */
    @Operation
    public void executeGoal(String goal, @Parameter(optional = true) Map<String, String> properties, @Parameter(optional = true) String overrideDirectory) {
        try {
            String[] arguments = new String[properties.size() + 1];

            int i = 0;
            for (String key : properties.keySet()) {
                arguments[i] = "-D" + key + "=" + properties.get(key);
                i++;
            }

            arguments[i] = goal;


            mavenCli.doMain(arguments, overrideDirectory, System.out, System.err);
        } catch (Exception e) {
            throw new RuntimeException("Unable to execute goal " + goal, e);
        }

    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
