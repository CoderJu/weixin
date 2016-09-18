package com.wechat.service;

import java.util.ArrayList;
import java.util.List;

import com.wechat.dao.MessageDao;

public class DeleteService {
	private MessageDao messageDao = new MessageDao();
	
	public void deleteOne(String param){
		int id = Integer.parseInt(param);
		messageDao.deleteOne(id);
	}
	
	public void deleteBatch(String[] param){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0;i<param.length;i++){
			list.add(Integer.parseInt(param[i]));
	}
		messageDao.deleteBatch(list);
	}
}
