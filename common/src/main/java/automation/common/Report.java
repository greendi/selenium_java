package automation.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import automation.common.cucumber.ScenarioContext;

public class Report {

	public static void takeScreenshot(WebDriver driver, String path) {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File(path + "_screenshot.png"));
		} catch (IOException e) {
			// TODO: logging - unable to create screenshot
		}
	}

	private static void saveSourceFile(WebDriver driver, String path) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path), true));
		bw.write(driver.getPageSource());
		bw.newLine();
		bw.close();
	}

	public static void createErrorReport(WebDriver driver) throws IOException {
		String fileNameBase = "error_" + ScenarioContext.getInstance().getScenarioName() + "_"
				+ DateTime.now().toString("yyyyMMdd_HHmmss") + " ";

		String resultsDirectory = System.getenv("RESULTS_DIR");
		if (resultsDirectory == null) {
			Path currentRelativePath = Paths.get("");
			resultsDirectory = currentRelativePath.toAbsolutePath().toString() + "/results/";
		}

		String testName = ScenarioContext.getInstance().getScenarioName();

		BufferedWriter stream = new BufferedWriter(
				new FileWriter(new File(resultsDirectory.concat("failures.txt")), true));
		stream.newLine();
		stream.write(testName);
		stream.close();

		String artifactDirectory = resultsDirectory.concat(ScenarioContext.getInstance().getFeatureFileName());
		Files.createDirectories(Paths.get(artifactDirectory));

		String screenshotFilePath = artifactDirectory.concat("\\" + fileNameBase);
		String sourceFilePath = artifactDirectory.concat("\\" + fileNameBase + "_source.html");

		saveSourceFile(driver, sourceFilePath);
		takeScreenshot(driver, screenshotFilePath);
	}
}
