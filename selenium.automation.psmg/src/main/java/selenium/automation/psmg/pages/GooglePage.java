package selenium.automation.psmg.pages;

import org.openqa.selenium.Keys;
import selenium.automation.psmg.selectors.GoogleSelectors;
import selenium.automation.psmg.validators.GoogleValidators;

import java.awt.event.KeyEvent;
import java.security.Key;

public class GooglePage {
    private GoogleSelectors selectors;
    private GoogleValidators validators;

    public void selectSearch() {
        selectors.searchBar().click();
    }

    public void enterInput(String phrase) {
        selectors.searchBar().sendKeys(phrase);
        selectors.searchBtn().click();
    }

    public void results(String phrase){
        selectors.inputPresent().getText();
    }

    public GooglePage() {
        this.selectors = new GoogleSelectors();
        this.validators = new GoogleValidators();
    }

    public GoogleSelectors getSelectors() {
        return selectors;
    }

    public void setSelectors(GoogleSelectors selectors) {
        this.selectors = selectors;
    }

    public GoogleValidators getValidators() {
        return validators;
    }

    public void setValidators(GoogleValidators validators) {
        this.validators = validators;
    }
}
