package selenium.automation.psmg.selectors;

import automation.common.selector.SingleElementSelector;
import groovy.json.internal.Chr;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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

    public SingleElementSelector firstName() {
        return new SingleElementSelector(
                By.cssSelector("input[id='customer_firstname']"));
    }

    public SingleElementSelector lastName() {
        return new SingleElementSelector(
                By.cssSelector("input[id='customer_lastname']"));
    }

    public SingleElementSelector passRegister() {
        return new SingleElementSelector(
                By.cssSelector("input[id='passwd']"));
    }

    public SingleElementSelector address() {
        return new SingleElementSelector(
                By.cssSelector("input[id='address1']"));
    }

    public SingleElementSelector city() {
        return new SingleElementSelector(
                By.cssSelector("input[id='city']"));
    }


    public SingleElementSelector state() {
        return new SingleElementSelector(
                By.cssSelector("div[id='uniform-id_state']"));

    }

    public SingleElementSelector zip() {
        return new SingleElementSelector(
                By.cssSelector("input[id='postcode']"));
    }

    public SingleElementSelector mobilePhone() {
        return new SingleElementSelector(
                By.cssSelector("input[id='phone_mobile']"));
    }

    public SingleElementSelector registerBtn() {
        return new SingleElementSelector(
                By.cssSelector("button[id='submitAccount']"));
    }
}
