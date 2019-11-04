package selenium.automation.psmg.selectors;

import automation.common.selector.SingleElementSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleSelectors {
    public SingleElementSelector searchBar() {
        return new SingleElementSelector(
                By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")
        );
    }

    public SingleElementSelector searchBtn() {
        return new SingleElementSelector(
                By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[2]/div[2]/div/center/input[1]")
        );
    }

    public SingleElementSelector inputPresent() {
        return new SingleElementSelector(
                By.xpath("//*[@id=\"rso\"]/div[3]/div")
        );
    }
}
