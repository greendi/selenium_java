package selenium.automation.psmg.validators;

import org.junit.Assert;
import selenium.automation.psmg.selectors.RegisterSelectors;

import java.util.Random;

public class RegisterValidators {
    private RegisterSelectors selectors;

    public void validateInvalidEmail(String message) {
        selectors.errorMessage().getWait().isVisible(null);
        System.out.println(selectors.errorMessage().getText());
        Assert.assertTrue(selectors.errorMessage().getText().contains(message));
    }

    public void generateRandomEmail (){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        selectors.email().sendKeys("didike.work+"+ randomInt +"@gmail.com");
        System.out.println(selectors.email().getText());
        selectors.submit().click();
    }

    public RegisterValidators() {
        this.selectors = new RegisterSelectors();
    }

    public RegisterSelectors getSelectors() {
        return selectors;
    }

    public void setSelectors(RegisterSelectors selectors) {
        this.selectors = selectors;
    }
}

