package selenium.automation.psmg.selectors;

import automation.common.selector.SingleElementSelector;
import org.openqa.selenium.By;

public class LoginSelectors {

    public SingleElementSelector email_login() {
        return new SingleElementSelector(
                By.cssSelector("input[id='email']"));
    }

    public SingleElementSelector pass_login() {
        return new SingleElementSelector(
                By.cssSelector("input[id='passwd']")
        );
    }

    public SingleElementSelector submit_login() {
        return new SingleElementSelector(
                By.cssSelector("button[id='SubmitLogin']"));
    }

}