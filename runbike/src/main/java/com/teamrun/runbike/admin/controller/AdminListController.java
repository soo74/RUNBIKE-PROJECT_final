package com.teamrun.runbike.admin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamrun.runbike.admin.domain.ListViewAdmin;
import com.teamrun.runbike.admin.domain.SearchParam;
import com.teamrun.runbike.admin.service.MemberListService;

@Controller
@RequestMapping("/adminpage")
public class AdminListController {

		 	@Autowired 
		 	private MemberListService listService;
					
			@RequestMapping("/managelist")
			public String memberList(Model model,@RequestParam(value = "p", defaultValue = "1") int pageNumber,
												@RequestParam(value = "stype", required = false) String stype,
												@RequestParam(value = "keyword", required = false) String keyword) {
				
				
				SearchParam searchParam = null; 
				
				if(	stype!=null && keyword!=null&& !stype.isEmpty()	&& !keyword.isEmpty()) {
					searchParam = new SearchParam();
					searchParam.setStype(stype);
					searchParam.setKeyword(keyword);
				}

				ListViewAdmin listdata = listService.getListData(pageNumber, searchParam);
				
				model.addAttribute("viewData", listdata);
							
				return "adminpage/managelist";
			}

			
}
