package com.wechat.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wechat.bean.Message;
import com.wechat.service.AddService;
import com.wechat.service.EditService;
import com.wechat.service.QueryService;

@SuppressWarnings("serial")
public class EditServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String operation = req.getParameter("operation");
		System.out.println("operation="+operation);
		String id = req.getParameter("id");
		System.out.println("id="+id);
		if(operation.equals("edit")){
			String command = req.getParameter("command");
			String content = req.getParameter("content");
			String desc = req.getParameter("description");
			Message message = new Message();
			message.setCommand(command);
			message.setContent(content);
			message.setDescription(desc);
			message.setId(id);
			EditService editService = new EditService();
			editService.edit(message);
			req.getRequestDispatcher("/WEB-INF/jsp/back/succ.jsp").forward(req, resp);
		}else if(operation.equals("editPage")){
			QueryService queryService = new QueryService();
			Message message = new Message();
			try {
				message = queryService.QueryById(id);
				System.out.println("message=="+message.getCommand());
				System.out.println("message=="+message.getContent());
				System.out.println("message=="+message.getDescription());
				req.setAttribute("message", message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher("/WEB-INF/jsp/back/edit.jsp").forward(req, resp);
		}	
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
