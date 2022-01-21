## Run springboot application from Commandline

1. Get inside the project directory
	Right click on name of project inside "package explorer" in eclipse/sts
	Use "Show In" > Terminal


2. Inside the terminal use following command to validate maven project
    
    ```
   .\mvnw.cmd validate
   ```

3. If validation is SUCCEDED, continue with next
   
   ```
   .\mvnw.cmd clean package
   ```

4. Now, from inside "target" run the app!

    ```
    cd target
    java -jar <Filename.jar>
    ```

## Spring boot application allows, Overridding the 'application.properties'

Sytax : java -jar filename.jar --KEY=VALUE --KEY=VALUE

java -jar demo1-1.0.jar  --server.port=9009


## Context-Root or Root-Context !

Root context http://[HOSTNAME]:[PORT]/

Never use these paths:
 `<img src="http://localhost:8080/assets/back.jpg"/ >`

Always use 'relative path':
 `<img src="assets/back.jpg"/ >`

