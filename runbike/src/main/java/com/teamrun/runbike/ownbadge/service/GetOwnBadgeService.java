package com.teamrun.runbike.ownbadge.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamrun.runbike.ownbadge.dao.OwnBadgeDao;
import com.teamrun.runbike.ownbadge.domain.Badge;
import com.teamrun.runbike.ownbadge.domain.MyBadge;
import com.teamrun.runbike.user.domain.LoginInfo;

@Service("GetOwnBadgeService")
public class GetOwnBadgeService {

	@Autowired
	private SqlSessionTemplate template;
	
	private OwnBadgeDao dao;
	
	//모든 뱃지 소환
	public List<Badge> getAllBadge() {
		
		dao = template.getMapper(OwnBadgeDao.class);
		
		//전체 스탬프 리스트	
		List<Badge> allBadgeList = null; 
		allBadgeList = dao.selectAllBadge();
		 
		return allBadgeList;
	}
	
	//나의 뱃지 소환
	public List<MyBadge> selectMyBadge(HttpServletRequest request){
		
		dao = template.getMapper(OwnBadgeDao.class);
		
		List<MyBadge> myBadgeList = null;
		
		//세션에서 로그인 정보 받아오기
		LoginInfo loginInfo = (LoginInfo)request.getSession(false).getAttribute("loginInfo");
				
		int u_idx = loginInfo.getU_idx();
		
		myBadgeList = dao.selectMyBadge(u_idx);
		
		return myBadgeList;
	}
}
