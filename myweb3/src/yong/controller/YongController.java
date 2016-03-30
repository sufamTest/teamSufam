package yong.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.command.*;


public class YongController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userProcess(req, resp);
	}
	
	//awt의 액션퍼폼드한 형식과 비슷
	protected void userProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. HTTP요청받음(awt의 obj반환받음)
		String type = req.getParameter("type");
		
		//2. 요구기능 분석
		//String result = null;
		CommandHandler command = null;
		String goPage = null; //어느페이지로 갈것인지.
		if(type.equals("list")){
			//3. 기능처리
			//result = "글목록보기 기능이 수행됨!";
			//goPage = "/list.jsp";//이동하고자 하는 위치
			command = new ListAction();
		}else if(type.equals("write")){
			//3. 기능처리
			command = new WriteAction();
		}else if(type.equals("content")){
			command = new ContentAction();
		}else if(type.equals("update")){
			command = new UpdateAction();
		}else if(type.equals("delete")){
			command = new DeleteAction();
		}
		//4. 결과 저장
		goPage = command.process(req, resp);
		//5. 이동
		RequestDispatcher dis = 
				req.getRequestDispatcher(goPage);
		dis.forward(req, resp);
	}
	
	
	
}

//서블릿 객체화
/**
 * 생성자 호출!
 * init()
 * service() 1. doGet() 2. doPost() => userProcess() 유저프로세스로 통합
 * destroy() 소멸자
 * */
