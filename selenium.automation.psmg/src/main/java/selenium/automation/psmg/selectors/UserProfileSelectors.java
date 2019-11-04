package selenium.automation.psmg.selectors;

import automation.common.selector.SingleElementSelector;
import org.openqa.selenium.By;

public class UserProfileSelectors {


    public SingleElementSelector userProfile() {
        return new SingleElementSelector(
                By.xpath("//*[@id=\"columns\"]/div[1]/span[2]")
        );
    }

    public SingleElementSelector logoutBtn() {
        return new SingleElementSelector(
                By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
        );
    }
}
