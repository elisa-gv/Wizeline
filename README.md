# Wizeline

The project is organized in Test cases, one for each of the 7 scenarios. 
Additionally, they can be executed at once using testng.xml file, since they are configured as TestNG. The thread-count is set to 2 for 
performance and monitoring purposes. 

This project was done in an Ubuntu machine, so please note that there may be some differences if it wants to be executed in Windows, 
like the format the path of the drivers and the Excel file are written. 

When executed, it will be lunched in multiple browsers as per the requirements, being Chrome and Firefox at the same time.

The next POM dependencies were used to add ExtentReports and to be able to read data from Excel:


		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>3.141.59</version>
		</dependency>
		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>6.10</version>
			<scope>test</scope>
		</dependency>
		<!--  https://mvnrepository.com/artifact/com.aventstack/extentreports  -->
		<dependency>
			<groupId>com.aventstack</groupId>
			<artifactId>extentreports</artifactId>
			<version>3.1.5</version>
		</dependency>
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi</artifactId>
			<version>5.0.0</version>
		</dependency>
<!--  https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml  -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>5.0.0</version>
		</dependency>
</dependencies>

The test results can be seen in html for each test case using ExtentReports. The html files are under test-output folder, alomg with the pom and the testng xmls.

Please reach me out for any questions.

Thanks for the oportunity,

Elisa Gaytan.
