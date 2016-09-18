package com.wechat.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wechat.bean.Message;
import com.wechat.service.QueryService;


@SuppressWarnings("serial")
public class QueryServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//MessageDao messageDao = new MessageDao();
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		req.setAttribute("command", command);
		req.setAttribute("des", description);
		Message message = new Message();
		message.setCommand(command);
		message.setDescription(description);
		QueryService service = new QueryService();
		List<Message> messageList = new ArrayList<Message>();
		try {
			messageList = service.QueryAll(message);
			req.setAttribute("messagelist", messageList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
