package automation.common.selector;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.common.Driver;

public class MultipleElementSelector {

	private List<SingleElementSelector> selectors;
	private By locator;

	public MultipleElementSelector(By locator) {
		this.locator = locator;
		// TODO: Improve this implementation and test afterwards drop-down
		this.selectors = getWebElements().stream().filter(Objects::nonNull)
				.map(w -> new SingleElementSelector(this.locator)).collect(Collectors.toList());
	}

	public MultipleElementSelector(List<SingleElementSelector> selectors) {
		this.selectors = selectors;
	}

	public WebDriverWait conditionalWait(Long timeout) {
		return new WebDriverWait(Driver.browser, Timeout.process(timeout));
	}

	/**
	 * Clicks an element that satisfies the specified condition.
	 * 
	 * @param condition Condition to wrap.
	 */
	public void click(Function<SingleElementSelector, Boolean> condition, Long timeout) {
		SingleElementSelector selector = findSelector(condition, timeout);
		if (selector != null) {
			selector.click();
		}
	}

	public void click(Function<SingleElementSelector, Boolean> condition) {
		click(condition, null);
	}

	/**
	 * Wraps the specified condition call in a try-catch for stale elements and
	 * retries to get the element if it got stale for up to 10 times.
	 * 
	 * @param condition Condition to wrap.
	 * @param selector  The selector to pass into the specified function.
	 * @return True when the specified function did not raise an exception and false
	 *         when it did.
	 */
	private Boolean retry(Function<SingleElementSelector, Boolean> condition, SingleElementSelector selector) {
		for (int i = 0; i < 10; i++) {
			try {
				return condition.apply(selector);
			} catch (StaleElementReferenceException e) {
				continue;
			}
		}
		throw new StaleElementReferenceException(null);
	}

	/**
	 * Finds a selector returned by this selector that satisfies the specified
	 * condition.
	 * 
	 * @param condition Condition to wrap.
	 * @param timeout   The maximum amount of time to keep looking for a selector
	 *                  that satisfies the condition.
	 * @return The selector that matched the specified condition.
	 */
	public SingleElementSelector findSelector(Function<SingleElementSelector, Boolean> condition, Long timeout) {
		return this.conditionalWait(timeout).until((ExpectedCondition<SingleElementSelector>) cond -> {
			for (SingleElementSelector selector : this.selectors) {
				if (retry(condition, selector)) {
					return selector;
				}
			}
			return null;
		});
	}

	/**
	 * Validates that all elements have a specified attribute value
	 * 
	 * @param attributeName  The name of the attribute to get the value of.
	 * @param attributeValue The value of the specified HTML attribute.
	 * @return True when all the elements have a specified attribute value and false
	 *         if not
	 */
	public boolean validateAttributeForAllElements(String attributeName, String attributeValue) {
		for (SingleElementSelector selector : this.selectors) {
			if (!attributeValue.equals(selector.getAttribute(attributeName).trim()))
				return false;
		}
		return true;
	}

	public List<WebElement> getWebElements() {
		for (int i = 0; i < 10; i++) {
			try {
				return Driver.browser.findElements(this.locator);
			} catch (StaleElementReferenceException e) {
				continue;
			}
		}
		throw new StaleElementReferenceException(null);
	}

	public List<SingleElementSelector> getSelectors() {
		return selectors;
	}

	public void setSelectors(List<SingleElementSelector> selectors) {
		this.selectors = selectors;
	}

	public By getLocator() {
		return locator;
	}

	public void setLocator(By locator) {
		this.locator = locator;
	}

}
