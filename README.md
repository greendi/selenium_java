## 1.Install Java and Maven:
    https://www.oracle.com/technetwork/java/javase/downloads/
    http://maven.apache.org/install.html
## 2.Configure the system environment variables
    Path: "C:\Program Files\Java\...\bin";
    Path: "C:\...\apache-maven-x.x.x\bin"
## 3.Verify the installation for Java and Maven
    java -version
    mvn - version
## 4.Clone the project
    - clone the repository from Bitbucket
    - add SDK: File / Project Structure / Project SDK
    - add common as a Maven Project from Existing Sources
	- add selenium.automation.psmg as a Maven Module from Existing Project
    - clean and install both Maven modules: expand each maven module then clean and install
## 5.More configurations of the system environment variables
    CONFIG_DIR: C:\[some_path]\Configuration.properties
    RESULTS_DIR: C:\[some_path}\results\
	FILES_DIR: C:\[some_path]\files\    
## 6.Paths for Chromedriver, IE, Firefox:
    6.1 Try to run for the first time RunFeatures.java - should fail
    6.2 Then configure in menu Run -> Edit Configurations -> VM options:
    -Dwebdriver.chrome.driver="C:\\some_path\\chromedriver.exe"
    -Dwebdriver.gecko.driver="C:\\some_path\\firefox.exe"
    -Dwebdriver.ie.driver="C:\\some_path\\IEDriverServer.exe"
    6.3 Try to run again ==> should pass
    
## More detailed info ==> in TestAutomationFramework.docx