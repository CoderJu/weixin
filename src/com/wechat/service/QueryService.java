package com.wechat.service;

import java.util.List;

import com.wechat.bean.Message;
import com.wechat.dao.MessageDao;

public class QueryService {

	public List<Message> QueryAll(Message message) throws Exception{
		MessageDao messageDao  = new MessageDao();
		List<Message> list = messageDao.queryAll(message);
		return list;
	}
	
	public Message QueryById(String param) throws Exception{
		int id = Integer.parseInt(param);
		MessageDao messageDao  = new MessageDao();
		Message message= messageDao.QueryById(id);
		return message;
	}
}
