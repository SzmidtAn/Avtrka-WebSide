package net.iamvegan.multipartrequest;

public class NoMultipartNormalParametersTest extends AbstractDumpTestCase {
	public void setUp() throws Exception {
		setUp("NoMultipart_NormalParameters_Firefox-2.0.0.3.dump");
	}
	
	public void testIsMultipart() throws Exception {
		assertFalse("Request is not multipart.", multiRequest.isMultipartRequest());
	}
}
