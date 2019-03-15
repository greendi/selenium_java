package automation.common.selector;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.common.Driver;

public class GridElementSelector {
	private String elementLocator;
	private By bodyLocator;

	public GridElementSelector(By bodyLocator, String elementLocator) {
		this.bodyLocator = bodyLocator;
		this.elementLocator = elementLocator;
	}

	/**
	 * Gets the value of a HTML attribute from a specific line and column.
	 * 
	 * @param attributeName The name of the attribute to get the value of.
	 * @param lineIndex     The index of the line.
	 * @param columnIndex   The index of the column.
	 * @return The value of the specified HTML attribute from a specific line and
	 *         column.
	 */
	public String getAttributeBy(String attributeName, String lineIndex, String columnIndex) {
		By locator = By.cssSelector(String.format(elementLocator, lineIndex, columnIndex));
		WebElement element = Driver.browser.findElement(locator);
		return element.getAttribute(attributeName);
	}

	/**
	 * Gets the selector of the element located at a specific line and column.
	 * 
	 * @param lineIndex   The index of the line.
	 * @param columnIndex The index of the column.
	 * @return The selector of the element located at a specific line and column.
	 */
	public SingleElementSelector getElement(String lineIndex, String columnIndex) {
		String formattedLocator = String.format(elementLocator, lineIndex, columnIndex);
		By locator = By.cssSelector(formattedLocator);
		return new SingleElementSelector(locator);
	}

	/**
	 * Gets the index of a line base on its attribute value.
	 * 
	 * @param attributeName  The name of the attribute to get the value of.
	 * @param attributeValue The value of the specified HTML attribute.
	 * @param columnIndex    The index of the column.
	 * @return The index of a line base on its attribute value.
	 */
	public String getLineIndex(String attributeName, String attributeValue, String columnIndex) {
		for (int i = 1; i <= getNumberOfRows(); i++) {
			String formattedLocator = String.format(elementLocator, String.valueOf(i), columnIndex);
			By locator = By.cssSelector(formattedLocator);
			WebElement element = Driver.browser.findElement(locator);
			if (attributeValue.equals(element.getAttribute(attributeName))) {
				return String.valueOf(i);
			}
		}
		return null;
	}
	
	public String getLineIndex(String attributeName, String attributeValue) {
		for (int i = 1; i <= getNumberOfRows(); i++) {
			String formattedLocator = String.format(elementLocator, String.valueOf(i));
			By locator = By.xpath(formattedLocator);
			WebElement element = Driver.browser.findElement(locator);
			if (attributeValue.equals(element.getAttribute(attributeName))) {
				return String.valueOf(i);
			}
		}
		return null;
	}
	
	/**
	 * Gets all the elements from a specific column.
	 * 
	 * @param columnIndex The index of the column.
	 * @return MultipleElementSelector containing all the elements from a specific
	 *         column.
	 */
	public MultipleElementSelector getElementsFromColumn(String columnIndex) {
		List<SingleElementSelector> webElements = new ArrayList<>();
		for (int i = 1; i <= getNumberOfRows(); i++) {
			By locator = By.cssSelector(String.format(elementLocator, String.valueOf(i), columnIndex));
			webElements.add(new SingleElementSelector(locator));
		}
		return new MultipleElementSelector(webElements);
	}

	/**
	 * Gets all the elements from a specific line.
	 * 
	 * @param lineIndex   The index of the line.
	 * @param noOfColumns The number of columns from the grid.
	 * @return MultipleElementSelector containing all the elements from a specific
	 *         line.
	 */
	public MultipleElementSelector getElementsFromLine(String lineIndex, int noOfColumns) {
		List<SingleElementSelector> webElements = new ArrayList<>();
		for (int i = 1; i <= noOfColumns; i++) {
			By locator = By.cssSelector(String.format(elementLocator, lineIndex, String.valueOf(i)));
			webElements.add(new SingleElementSelector(locator));
		}
		return new MultipleElementSelector(webElements);
	}

	/**
	 * Gets the number of the rows from a grid.
	 * 
	 */
	public int getNumberOfRows() {
		List<WebElement> elements = Driver.browser.findElements(bodyLocator);
		return elements.size();
	}
}
