package com.wechat.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wechat.bean.Message;
import com.wechat.service.AutoReplyService;

@SuppressWarnings("serial")
public class AutoReplyServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			AutoReplyService autoReplyService = new AutoReplyService();
			Message message = new Message();
			String command = req.getParameter("content");
			System.out.println("command=="+command);
			if(command.equals("°ïÖú")){
				String Str = autoReplyService.replyAll();
				System.out.println("Str==="+Str);
				out.write(Str);
			}else{
			message = autoReplyService.reply(command);
			System.out.println("messgae==="+message.getCommand()+"||"+message.getContent());
			out.write(message.getContent());
			}
			out.flush();
			out.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}


}
