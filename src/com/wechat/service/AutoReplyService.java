package com.wechat.service;

import java.util.ArrayList;
import java.util.List;

import com.wechat.bean.Message;
import com.wechat.dao.MessageDao;

public class AutoReplyService {

	private MessageDao messageDao = new MessageDao();
	
	public Message reply(String command){
		return  messageDao.reply(command);
	}

	public String replyAll() {
		List<Message> list = new ArrayList<Message>();
		list = messageDao.replyAll();
		String str ="";
		for(int i=0;i<list.size();i++){
			System.out.println("list=="+list.get(i).getCommand());
			str += "回复["+list.get(i).getCommand()+"]可以查看["+list.get(i).getDescription()+"]<br/>";
		}
		return str;
		
	}

}
