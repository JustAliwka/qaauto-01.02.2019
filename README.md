1. Download Java jdk and install (best v8)
2. Check that it is installed by executing java -version in cmd
3. Download ChromeDriver
4. Extract the file in C:\Windows\System32
5. Go to pom.xml (file with settings) and add selenium settings:
    <dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.141.59</version>
    </dependency>
    </dependencies>
How to setup git
git config --global user.name //will show you user that is already singed in
git config --global user.name "Alina Panchenko"//next step to write your name
git config --global user.email

Add .gitignore file with path to files that should be ignored
/.idea/
/target/
*.iml
