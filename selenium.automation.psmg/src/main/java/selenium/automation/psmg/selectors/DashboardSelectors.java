package selenium.automation.psmg.selectors;

import automation.common.selector.SingleElementSelector;
import org.openqa.selenium.By;

public class DashboardSelectors {
    public SingleElementSelector logo() {
        return new SingleElementSelector(
                By.cssSelector("div[id='header_logo']"));
    }

    public SingleElementSelector signInButton() {
        return new SingleElementSelector(
                By.cssSelector(".header_user_info"));
    }

    public SingleElementSelector productName() {
        return new SingleElementSelector(
                By.cssSelector("a.product-name:first-child")
        );
    }

    public SingleElementSelector moreBtn() {
        return new SingleElementSelector(
                By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[2]")
        );
    }

    public SingleElementSelector productDetails() {
        return new SingleElementSelector(
                By.cssSelector("h1")
        );
    }


}
