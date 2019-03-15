package selenium.automation.psmg.steps;

import automation.common.ConfigFileReader;
import automation.common.Driver;
import cucumber.api.java.en.Given;
import selenium.automation.psmg.pages.DashboardPage;

import java.io.File;
import java.util.Scanner;

public class DashboardSteps {

    public DashboardPage DashboardPage = new DashboardPage();
    public ConfigFileReader ConfigFileReader = new ConfigFileReader();

    @Given("^the register page is accessed$")
    public void the_register_page_is_accessed() throws Throwable {

        Driver.startBrowser(ConfigFileReader.getConfigValue("URL"));

        DashboardPage.getValidators().validateLogoIsVisible();
        DashboardPage.selectRegisterButton();
    }
}
