package com.narratage.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonUtils {
	
	public static void ajaxResponse(HttpServletRequest request, HttpServletResponse response, Object msg, String charset) {
		PrintWriter out = null;
		try {
			response.setContentType("text/html; charset=" + charset);
			request.setCharacterEncoding(charset);
			response.setHeader("Cache-Control", "no-cache");

			out = response.getWriter();
		} catch (UnsupportedEncodingException e1) {
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.print(msg);
		out.flush();
		out.close();
	}

	/**
	 * Ajax response.
	 *
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param msg Object
	 */
	public static void ajaxResponse(HttpServletRequest request, HttpServletResponse response, Object msg) {
		ajaxResponse(request, response, msg, "utf-8");
	}

}
