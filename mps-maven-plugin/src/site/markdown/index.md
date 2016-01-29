# MPS Maven Plugin
The MPS Maven Plugin is used to generate code from [JetBrains MPS](http://www.jetbrains.com/mps/) models created using
MPS language plugins for IntelliJ IDEA. The plugin does not require MPS to be installed on the machine and thus helps
integrate MPS into Maven-based continuous integration builds.

# Goals Overview
The MPS Maven Plugin has a single goal, [`mps:generate-java`](generate-java-mojo.html).

# Prerequisites
The plugin requires MPS deployed in the form of artifacts to a Maven repository. These artifacts can be created and
deployed from a local installation of MPS using [MPS Maven Deployer](https://github.com/JetBrains/mps-maven-deployer).

# Generating Java From MPS Models
1. Deploy MPS artifacts to the Maven repository using
   [MPS Maven Deployer](https://github.com/JetBrains/mps-maven-deployer).
2. Put your models (`*.mps`) into the `src/main/mps` folder.
3. Add the plugin to your `pom.xml` (set `mpsVersion` to the version of MPS artifacts deployed in step 1):

    ```
    <plugin>
       <groupId>org.jetbrains.mps</groupId>
       <artifactId>mps-maven-plugin</artifactId>
       <version>${mps-maven-plugin.version}</version>
       <executions>
           <execution>
               <goals>
                   <goal>generate-java</goal>
               </goals>
               <configuration>
                   <mpsVersion>123.456</mpsVersion>
               </configuration>
           </execution>
       </executions>
    </plugin>
    ```

4. Run `mvn generate-sources`.
