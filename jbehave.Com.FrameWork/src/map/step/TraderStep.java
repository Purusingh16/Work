package map.step;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.Story;

public class TraderStep
{
	private TradingService service;
	private Stock stock;
	
	@Given("a stock  and a threshold of $threshold")
    public void aStock(double threshold)
	{
        stock = service.newStock("STK", threshold);
    }
 
    @When("the stock is traded at $price")
    public void theStockIsTraded(double price) {
         stock.tradeAt(price);
    }
 
    @Then("the alert status be $status")
    public void theAlertStatusShouldBe(String status) {
        assertThat(stock.getStatus().name(), equalTo(status));
    }

}
