package net.iamvegan.multipartrequest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import net.iamvegan.multipartrequest.util.DumpFile;

import org.apache.commons.fileupload.MockHttpServletRequest;

import junit.framework.TestCase;

public class AbstractDumpTestCase extends TestCase {
	protected HttpServletRequest request;
	protected HttpServletMultipartRequest multiRequest;
	
	public void setUp(String dumpFileName) throws IOException {
		DumpFile dumpFile = new DumpFile(dumpFileName);
	
		request = new MockHttpServletRequest(
				dumpFile.getContent(),
				dumpFile.getContentType());
		
		request = new HttpServletMultipartRequest(request);
		multiRequest = (HttpServletMultipartRequest) request;
	}
}
