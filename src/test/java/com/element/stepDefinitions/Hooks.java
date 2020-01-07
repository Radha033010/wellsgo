package com.element.stepDefinitions;

import com.element.utils.CucumberTestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks extends StepDefinitionsBase {



   public Hooks(CucumberTestContext context) throws Throwable {
      super(context);

   }

   @Before
   public void setUp(Scenario scenario) throws Throwable {
      cucumberTestContext.initialize();
      cucumberTestContext.getScenarioContext().setValue("ScenarioName", scenario.getName());
   }

   @After()
   public void tearDown() {
      if (cucumberTestContext == null)
         return;
      cucumberTestContext.tearDown();
   }
}
