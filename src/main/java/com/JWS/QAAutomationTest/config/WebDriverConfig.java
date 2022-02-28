package com.JWS.QAAutomationTest.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverConfig {

	@Bean
	public WebDriver webDriver() {
		WebDriverManager.chromedriver().version("97.0.4692.71").setup();
		return new ChromeDriver();
	}

	@Bean
	public WebDriverWait wait(WebDriver driver) {
		return new WebDriverWait(driver, 30);
	}

}

