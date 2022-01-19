package com.green.controller.action;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public interface Action {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
}
