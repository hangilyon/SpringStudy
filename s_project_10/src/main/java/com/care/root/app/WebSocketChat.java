package com.care.root.app;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
@ServerEndpoint(value="/echo.do")
public class WebSocketChat {
	private static final List<Session> sessionList = new ArrayList<Session>();
	private static final Logger logger
	= LoggerFactory.getLogger(WebSocketChat.class);
	public WebSocketChat() {
		System.out.println("웹 소켓 ( 서버 ) 객체생성");
	}
	@OnOpen
	public void onOpen(Session session) {
		logger.info("Open session id:"+session.getId() );
		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText("대화방에 연결 되었습니다.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		sessionList.add(session);
	}
	/*
	 * 모든 사용자에게 메시지를 번달한다
	 * @param self
	 * @param sender
	 * @param message
	 */
	private void sendAllSessionToMessage(
			Session self, String sender, String message) {
		try {
			for(Session session : WebSocketChat.sessionList) {
				if(!self.getId().equals(session.getId())) {
					session.getBasicRemote().sendText(sender+" : "+message);
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
