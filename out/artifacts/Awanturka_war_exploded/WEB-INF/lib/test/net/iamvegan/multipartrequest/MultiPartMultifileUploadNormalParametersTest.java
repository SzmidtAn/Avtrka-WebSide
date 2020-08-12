package net.iamvegan.multipartrequest;

public class MultiPartMultifileUploadNormalParametersTest extends AbstractDumpTestCase {

	protected void setUp() throws Exception {
		setUp("MultiPart_MultifileUpload_NormalParameters_Firefox-2.0.0.4.dump");
	}

	public void testIsMultipart() throws Exception {
		assertTrue("Request is multipart.", multiRequest.isMultipartRequest());
	}
	
	
}
