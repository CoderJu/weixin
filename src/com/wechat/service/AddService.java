package com.wechat.service;

import com.wechat.bean.Message;
import com.wechat.dao.MessageDao;

public class AddService {

	public void create(Message message){
		MessageDao messageDao = new MessageDao();
		messageDao.create(message);
	}
}
