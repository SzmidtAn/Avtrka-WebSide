package net.iamvegan.multipartrequest.util;

/*
	MultipartRequest servlet library
	Copyright (C) 2001-2007 by Jason Pell

	This library is free software; you can redistribute it and/or
	modify it under the terms of the GNU Lesser General Public
	License as published by the Free Software Foundation; either
	version 2.1 of the License, or (at your option) any later version.
	
	This library is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
	Lesser General Public License for more details.
	
	You should have received a copy of the GNU Lesser General Public
	License along with this library; if not, write to the Free Software
	Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
	
	A copy of the Lesser General Public License (lesser.txt) is included in 
	this archive or goto the GNU website http://www.gnu.org/copyleft/lesser.html.
*/

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import net.iamvegan.multipartrequest.HttpServletMultipartRequest;
import net.iamvegan.multipartrequest.ProgressListener;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * @author Jason Pell
 */
public class testupload extends HttpServlet
{
	private static final long serialVersionUID = 8018649683362578024L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		final PrintWriter objOut = response.getWriter();
		
    	response.setContentType("text/html");

    	ProgressListener pl = new ProgressListener() {
    		public void update(long pBytesRead, long pContentLength, int pItems) {
    			objOut.println("<br />Item "+pItems+" (read: "+pBytesRead+") "+(int)(((float)pBytesRead/pContentLength)*100)+"%");
    			objOut.flush();
    		}
    	};
        	
        try
    	{
        	HttpServletMultipartRequest fileRequest = new HttpServletMultipartRequest(
        								request,
        								HttpServletMultipartRequest.MAX_CONTENT_LENGTH,
        								HttpServletMultipartRequest.MAX_CONTENT_MEMORY_THRESHOLD, 
        								HttpServletMultipartRequest.IGNORE_ON_MAX_LENGTH,
        								HttpServletMultipartRequest.DEFAULT_ENCODING,
        								pl);
        	
			objOut.println(fileRequest.toHtmlString());
		}
		catch (Exception e)
		{
			try {
				// we want to gobble up the input stream in this case.
				InputStream in = request.getInputStream();
				while ( in.read() !=-1);
			} catch(Exception e2) { }
			
			e.printStackTrace(objOut);
		}
	}
}

