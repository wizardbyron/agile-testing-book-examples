package com.example.atm;

import io.cucumber.junit.platform.engine.Cucumber;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.context.annotation.Scope;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Cucumber
@CucumberContextConfiguration
@Scope(SCOPE_CUCUMBER_GLUE)
public class RunCucumberTest {
}
