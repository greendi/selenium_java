package selenium.automation.psmg.selectors;

import automation.common.selector.SingleElementSelector;
import org.openqa.selenium.By;

public class RegisterSelectors {

    public SingleElementSelector email() {
        return new SingleElementSelector(
                By.cssSelector("input[id='email_create']"));
    }

    public SingleElementSelector submit() {
        return new SingleElementSelector(
                By.cssSelector("button[id='SubmitCreate']"));
    }

    public SingleElementSelector errorMessage() {
        return new SingleElementSelector(
                By.cssSelector("div[id='create_account_error']"));
    }
}
