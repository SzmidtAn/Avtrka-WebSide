package net.iamvegan.multipartrequest;

import java.io.IOException;

/**
 */
public class EmptyFileNormalParametersTest extends AbstractDumpTestCase {
	public void setUp() throws IOException {
		setUp("Multipart_EmptyFileUpload_NormalParameters_Firefox-2.0.0.3.dump");
	}
	
	public void testIsMultipart() throws Exception {
		assertTrue("Request is multipart.", multiRequest.isMultipartRequest());
	}
	
	public void testNormalParameters() {
		assertEquals("", "Jason", request.getParameter("name"));
		
		String nameValues[] = request.getParameterValues("name");
		assertEquals("There are two name parameters", 2, nameValues.length);
		
		assertEquals("", "Jason", nameValues[0]);
		assertEquals("", "Clair", nameValues[1]);
	
		assertEquals("", "Pell", request.getParameter("surname"));
		
		String surnameValues[] = request.getParameterValues("surname");
		assertEquals("There are two surname parameters", 2, surnameValues.length);
		
		assertEquals("", "Pell", surnameValues[0]);
		assertEquals("", "Harris", surnameValues[1]);
		
		assertEquals("", "Are you going to upload a file.\r\n", request.getParameter("stuff"));
	}
	
	public void testFileParameters() {
		MultipartFile file = multiRequest.getFileParameter("file1");
		assertNull("file1 MultipartFile should not exist!, where file object is empty", file);
		
		MultipartFile file2 = multiRequest.getFileParameter("file2");
		assertNull("file2 MultipartFile should not exist!, where file object is empty", file2);
	}
}
