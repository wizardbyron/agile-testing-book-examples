package com.example.atm;

import io.cucumber.junit.platform.engine.Cucumber;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Scope;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@SpringBootTest
@Cucumber
@CucumberContextConfiguration
@Scope(SCOPE_CUCUMBER_GLUE)
class AtmServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
