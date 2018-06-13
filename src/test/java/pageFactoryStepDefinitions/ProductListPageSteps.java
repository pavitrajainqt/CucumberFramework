package pageFactoryStepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import enums.Context;
import pageObjects.ProductListingPage;

public class ProductListPageSteps {
	
	TestContext testContext;
	ProductListingPage productListPage;
	
	public ProductListPageSteps(TestContext context) {
		testContext = context;
		productListPage = testContext.getPageObjectManager().getProductListingPage();
	}
	
	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() {
		String productName = productListPage.getProductName(0);
		testContext.getScenarioContext().setContext(Context.Product_Name, productName);
		
		productListPage.select_Product(0);
		productListPage.clickOn_AddToCart();
	}

}
