package com.wechat.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wechat.bean.Message;
import com.wechat.service.AddService;

@SuppressWarnings("serial")
public class AddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String operation = req.getParameter("operation");
		System.out.println("operation="+operation);
		if(operation.equals("transfer")){
		//req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/WEB-INF/jsp/back/detial.jsp").forward(req, resp);
		}else if(operation.equals("clean")) {
			req.setCharacterEncoding("UTF-8");
			Message message = new Message();
			message.setCommand("");
			message.setContent("");
			message.setDescription("");
			req.setAttribute("message", message);
			req.getRequestDispatcher("/WEB-INF/jsp/back/detial.jsp").forward(req, resp);
			System.out.println("clean");
		}else if(operation.equals("add")) {
			req.setCharacterEncoding("UTF-8");
			Message message = new Message();
			String command = req.getParameter("command");
			String description = req.getParameter("description");
			String content = req.getParameter("content");
			System.out.println("command="+command+"description="+description+"content="+content);
			message.setCommand(command);
			message.setContent(content);
			message.setDescription(description);
			AddService addservice = new AddService();
			addservice.create(message);
			//错误处理
			//Cause: java.sql.SQLException: Field 'ID' doesn't have a default value
			//解决方式：
			//数据库运行：
			//alter table tablename modify column id int NOT NULL AUTO_INCREMENT;
			req.getRequestDispatcher("/WEB-INF/jsp/back/succ.jsp").forward(req, resp);
			
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		this.doGet(request, response);
	}

}
