package com.teamrun.runbike.qna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamrun.runbike.qna.domain.ListViewTest;
import com.teamrun.runbike.qna.domain.SearchParam;
import com.teamrun.runbike.qna.service.BoardListService2;

@Controller
@RequestMapping("/board")
public class BoardListController {

	@Autowired
	private BoardListService2 board2Service;
		
	@RequestMapping("/boardlist")
	public String boardList(Model model,@RequestParam(value = "p", defaultValue = "1") int pageNumber,
										@RequestParam(value = "stype", required = false) String stype,
										@RequestParam(value = "keyword", required = false) String keyword) {
				
		SearchParam searchParam = null; 
		
		if(	stype!=null && keyword!=null&& !stype.isEmpty()	&& !keyword.isEmpty()) {
			searchParam = new SearchParam();
			searchParam.setStype(stype);
			searchParam.setKeyword(keyword);
		}

		ListViewTest listdata = board2Service.getBoardData(pageNumber, searchParam);
		
		model.addAttribute("boardData", listdata);
					
		return "qnaboard/boardlist";
	}
	
	
	
	
	
	
	
	
}
