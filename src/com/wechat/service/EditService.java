package com.wechat.service;

import com.wechat.bean.Message;
import com.wechat.dao.MessageDao;

public class EditService {
	private MessageDao messageDao = new MessageDao();
	
	public void edit(Message message){
		messageDao.edit(message);
	}
}
