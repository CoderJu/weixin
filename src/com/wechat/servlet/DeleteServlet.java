package com.wechat.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wechat.bean.Message;
import com.wechat.service.DeleteService;
import com.wechat.service.QueryService;

@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet {

	private DeleteService deleteService = new DeleteService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//MessageDao messageDao = new MessageDao();
		String operation = req.getParameter("operation");
		System.out.println("operation==="+operation);
		if(operation.equals("deleteone")){
			String id = req.getParameter("id");
			System.out.println("id==="+id);
			deleteService.deleteOne(id);
			//delete操作时，一定要commit
			req.getRequestDispatcher("/WEB-INF/jsp/back/succ.jsp").forward(req, resp);
		}
		if(operation.equals("deleteBatch")){
			String[] ids = req.getParameterValues("id");
			/*for(int i = 0;i<ids.length;i++){
				System.out.println("id["+i+"]="+ids[i]);
			}*/
			deleteService.deleteBatch(ids);
			req.getRequestDispatcher("/WEB-INF/jsp/back/succ.jsp").forward(req, resp);
		}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
