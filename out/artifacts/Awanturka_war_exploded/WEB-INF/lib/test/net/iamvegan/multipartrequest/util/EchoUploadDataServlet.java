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

import org.apache.commons.fileupload.util.Streams;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

/**
 * @author Jason Pell
 */
public class EchoUploadDataServlet extends HttpServlet
{
	private static final long serialVersionUID = -6744686032206324942L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	InputStream in = request.getInputStream();
    	OutputStream out = response.getOutputStream();
		
    	String strUserAgent = request.getHeader("user-agent");
    	
    	String fileName = strUserAgent+".dump";
    	
    	//Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.8.1.3) Gecko/20061201 Firefox/2.0.0.3 (Ubuntu-feisty)
    	response.addHeader("Content-disposition", "attachment; filename=\""+fileName+"\"");
    	response.setContentType("application/octet-stream");
  
		Streams.copy(in, out, true);
	}
}

