# Setup Environment

1. Verify your JDK (Current Use: JDK-1.8)
   Recommended version JDK-1.11

2. Download and extract Spring Tool Suite
    https://spring.io/tools

3. Launch Spring tool suite and choose your workspace
    Recommended: a new folder path ex: "c:\myprojects"

4.  Window Menu > Preferences > JRE > Installed JRE
       Add JDK 1.8 Installation path

## Create first web application project

1.  File Menu > New > Other  (Ctrl+N)
2.  Search for "spring" and then select "Spring Starter Project" > NEXT
3.  Now provide following details:
    
    Name | Description | Example
    -----|-------------|----------
    Name | Project name | demo1
    Type | Project Type, either maven or gradle | Maven
    Language | Choose from Java, Kotlin & Groovy | Java
    Packaging | Package type to be BUILT, either Jar or War | jar
    Java Version | Choose Java Compiler version: 8, 11 or 17 | Java 8
    Group | Maven project 'group name' similar to package name | com.mahendra
    Artifact | Final artifact name | demo1
    Version|  Specify the project version | 1.0
    Description | Optional description for current project | EMPTY
    Package : The "base" package name, which is similar to "groupname" | com.mahendra.demo1

> Your final package built will use this format for filename

    {artifactName}-{version}.{packaging}

    demo1-1.0.jar

4. Click Next, choose spring boot version: 2.6.3
    Add "dependency" : "web"

5. Click OK / Create