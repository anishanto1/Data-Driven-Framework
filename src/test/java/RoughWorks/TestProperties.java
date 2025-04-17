package RoughWorks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {

		//It will populate the path upto - /home/anish/eclipse-workspace/DataDrivenFramework
		//For Achieving generic path eventhough there is a change in the path

		System.out.println(System.getProperty("user.dir"));

		//For calling config property files 
		Properties config = new Properties();

		//For Calling ObjectProperties
		Properties objectRepository = new Properties();

		//Setting Path Config Properties
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//Properties//Config.Properties");
		config.load(fis);
		System.out.println(config.getProperty("browser"));

		//Setting Path ObjectProperties Properties

		fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//Properties//ObjectRepository.Properties");
		objectRepository.load(fis);
		System.out.println(objectRepository.getProperty("BankManagerLoginButton"));
	}
}
