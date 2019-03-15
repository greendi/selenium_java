package selenium.automation.psmg.model;

public class SoapAPITemplates {

	public static String soapTemplate = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
			+ "xmlns:hs=\"http://www.holidaywebservice.com/HolidayService_v2/\">\r\n" + " <soapenv:Body>\r\n"
			+ " <hs:GetHolidaysAvailable>\r\n" + " %s\n " + " </hs:GetHolidaysAvailable>\r\n" + " </soapenv:Body>\r\n"
			+ "</soapenv:Envelope>";
	
	public static String soapTemplate1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
			+ "xmlns:hs=\"http://www.holidaywebservice.com/HolidayService_v2/\">\r\n" + " <soapenv:Body>\r\n"
			+ " <hs:GetHolidaysAvailable>\r\n" + "<hs:countryCode>{0}</hs:countryCode>"+ " </hs:GetHolidaysAvailable>\r\n" + " </soapenv:Body>\r\n"
			+ "</soapenv:Envelope>";
}
