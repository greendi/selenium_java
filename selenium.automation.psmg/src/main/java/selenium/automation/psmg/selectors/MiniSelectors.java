package selenium.automation.psmg.selectors;

import automation.common.selector.SingleElementSelector;
import org.openqa.selenium.By;

public class MiniSelectors {

    public SingleElementSelector logoMini() {
        return new SingleElementSelector(
                By.xpath("/html/body/header/div[2]/a/div/div"));
    }

    public SingleElementSelector banner() {
        return new SingleElementSelector(
                By.xpath("//*[@id=\"psyma_close_button_link\"]"));
    }

    public SingleElementSelector cookies() {
        return new SingleElementSelector(
                By.xpath("/html/body/section[2]/div/div[1]/section/div[1]/div[3]/a[2]"));
    }

    public SingleElementSelector loginBtn() {
        return new SingleElementSelector(
                By.xpath("/html/body/header/div[3]/ul/li[1]/button")
        );
    }

    public SingleElementSelector chooseLoginBtn() {
        return new SingleElementSelector(
                By.xpath("/html/body/header/div[1]/div/div/div/div[2]/div/div/div[1]/div[1]/div[1]/div/div/div[3]/button[2]")
        );
    }

    public SingleElementSelector miniEmail() {
        return new SingleElementSelector(
                By.xpath("//*[@id=\"loginId\"]")
        );
    }

    public SingleElementSelector miniPass() {
        return new SingleElementSelector(
                By.xpath("//*[@id=\"password\"]")
        );
    }

    public SingleElementSelector submitLogin() {
        return new SingleElementSelector(
                By.xpath("//*[@id=\"login_form\"]/div/fieldset[4]/button[1]")
        );
    }

    public SingleElementSelector username() {
        return new SingleElementSelector(
          By.xpath("/html/body/header/div[1]/div/div/div/div[2]/div/div/div[1]/div[1]/header/ul/li[3]/button/span[2]")
        );
    }
}
