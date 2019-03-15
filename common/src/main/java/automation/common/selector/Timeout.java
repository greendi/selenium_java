package automation.common.selector;

public class Timeout {
	
	public static long process(Long timeout) {
		return timeout != null ? timeout : 20;
	}

}
