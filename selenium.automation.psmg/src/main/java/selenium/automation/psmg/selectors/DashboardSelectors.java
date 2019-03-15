package selenium.automation.psmg.selectors;

import automation.common.selector.SingleElementSelector;
import org.openqa.selenium.By;

public class DashboardSelectors {
    public SingleElementSelector logo() {
        return new SingleElementSelector(
                By.cssSelector("div[id='header_logo']"));
    }

    public SingleElementSelector registerButton() {
        return new SingleElementSelector(
                By.cssSelector("div[class='header_user_info']"));
    }
}
