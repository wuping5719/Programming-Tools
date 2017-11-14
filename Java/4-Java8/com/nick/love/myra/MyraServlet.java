package com.nick.love.myra;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyraServlet extends HttpServlet {

	private static final long serialVersionUID = -1755483935228107660L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.getWriter().println("I love Myra Ma.");
	}
}
