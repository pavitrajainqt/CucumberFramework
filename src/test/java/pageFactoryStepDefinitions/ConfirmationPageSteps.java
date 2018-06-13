package pageFactoryStepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;
import junit.framework.Assert;
import pageObjects.ConfirmationPage;

public class ConfirmationPageSteps {
	
	TestContext testContext;
	ConfirmationPage confirmationPage;
	
	public ConfirmationPageSteps(TestContext context) {
		testContext = context;
		confirmationPage = testContext.getPageObjectManager().getConfirmationPage();
	}
	
	@SuppressWarnings("deprecation")
	@Then("^verify the order details$")
	public void verify_the_order_details(){
		String productName = (String)testContext.getScenarioContext().getContext(Context.Product_Name);
		Assert.assertTrue(confirmationPage.getProductNames().stream().filter(x -> x.contains(productName)).findFirst().get().length()>0);		
	}

}
