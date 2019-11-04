package com.teamrun.runbike.qna.service;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamrun.runbike.qna.dao.BoardDaoInterface;
import com.teamrun.runbike.qna.domain.Message;
import com.teamrun.runbike.qna.domain.RequestMemberWrite;


@Service("writeService")
public class BoardWriteService implements BoardService {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private BoardDaoInterface dao;	
	
	//게시글 입력
	public int write(RequestMemberWrite regRequest) {
				
		dao = template.getMapper(BoardDaoInterface.class);		
		Message message = regRequest.toMessage();		
		System.out.println("문의글 작성 서비스 : "+message);		
		int rCnt = dao.insertBoard(message);	
		return rCnt;	
		
	}
}







