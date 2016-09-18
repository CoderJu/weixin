package com.wechat.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wechat.bean.Message;
import com.wechat.db.DBAccess;

public class MessageDao {

	public List<Message> queryAll_JDBC() throws Exception{
		String classDriver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/weixin";
		String username = "root";
		String password = "123";
		
		Class.forName(classDriver);
		Connection conn =  DriverManager.getConnection(url, username, password);
		StringBuffer sb = new StringBuffer("select ID,COMMAND,DESCRIPTION,CONTENT from message ");
		PreparedStatement state =  conn.prepareStatement(sb.toString());
		ResultSet rs =  state.executeQuery();
		
		List<Message> list =  new ArrayList<Message>();
		while(rs.next()){
			Message message = new Message();
			message.setId(rs.getString("id"));
			message.setDescription(rs.getString("description"));
			message.setContent(rs.getString("content"));
			message.setCommand(rs.getString("command"));
			list.add(message);
		}
		return list;
	}
	
	public List<Message> queryAll_WithoutParam(){
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession session = null;
		
		try {
			session = dbAccess.getSqlSession();
			Message message = new Message();
			messageList = session.selectList("Message.queryAll");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messageList;
	}
	
	public List<Message> queryAll(Message message){
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession session = null;
		
		try {
			session = dbAccess.getSqlSession();
			messageList = session.selectList("Message.queryAll",message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
		return messageList;
	}
	
	public void create(Message message){
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession session = null;
		try {
			session = dbAccess.getSqlSession();
			messageList = session.selectList("Message.create",message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession session = null;
		try {
			session = dbAccess.getSqlSession();
			session.delete("Message.deleteOne",id);
			session.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	public void deleteBatch(List<Integer> list){
		DBAccess dbAccess = new DBAccess();
		SqlSession session = null;
		try {
			session = dbAccess.getSqlSession();
			session.delete("Message.deleteBatch",list);
			session.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
	}

	public Message QueryById(int id) {
		DBAccess dbAccess = new DBAccess();
		Message message = new Message();
		SqlSession session = null;
		try {
			session = dbAccess.getSqlSession();
			//messageList = session.selectOne("Message.QueryById",id);
			message = session.selectOne("Message.QueryById",id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
		return message;
	}
	
	public void edit(Message message){
		DBAccess dbAccess = new DBAccess();
		//Message message = new Message();
		SqlSession session = null;
		try {
			session = dbAccess.getSqlSession();
			//messageList = session.selectOne("Message.QueryById",id);
			int i = session.update("Message.updateById",message);
			//message = session.selectOne("Message.updateById",message);
			System.out.println("i========================"+i);
			session.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}
	
	public Message reply(String command){
		DBAccess dbAccess = new DBAccess();
		Message message = new Message();
		SqlSession session = null;
		try {
			session = dbAccess.getSqlSession();
			//messageList = session.selectOne("Message.QueryById",id);
			message = session.selectOne("Message.replyByCommand",command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
		return message;
	}

	public List<Message> replyAll() {
		DBAccess dbAccess = new DBAccess();
		List<Message> message = new ArrayList<Message>();
		SqlSession session = null;
		try {
			session = dbAccess.getSqlSession();
			//messageList = session.selectOne("Message.QueryById",id);
			message = session.selectList("Message.replyAll");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
		return message;
	}
	
}
