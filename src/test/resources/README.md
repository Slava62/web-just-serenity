Auto-tests web UI in stack Serenity + Selenium Grid + JUnit5 parametrized tests + Java8

Start the Hub
java -jar selenium-server-standalone-3.141.59.jar -role hub
Start the node with config
java "-Dwebdriver.chrome.driver=C:\ChromeDriver\chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -nodeConfig node0.json
Run tests: mvn clean verify
Look through the serenity-report's generated