package com.element.stepDefinitions;

        import com.element.utils.CucumberTestContext;
        import com.element.utils.PageObjectManager;
        import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.Logger;

public class StepDefinitionsBase {

   protected CucumberTestContext cucumberTestContext;
   protected static Logger logger;
   public static int value;

   public StepDefinitionsBase(CucumberTestContext context) throws Throwable {
      cucumberTestContext = context;
      logger = LogManager.getLogger(this);
      logger.info("Initialised");
   }

   protected PageObjectManager Pages() {
      return cucumberTestContext.getPageObjectManager();
   }

   public CucumberTestContext getCucumberTestContext() {
      return cucumberTestContext;
   }
}

