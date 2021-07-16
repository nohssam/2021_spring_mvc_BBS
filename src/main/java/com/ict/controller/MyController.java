package com.ict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ict.service.MyService;
import com.ict.service.Paging;
import com.ict.vo.BVO;

@Controller
public class MyController {
	@Autowired
	private MyService myService;
	@Autowired
	private Paging paging;
	
	@RequestMapping("list.do")
	public ModelAndView getListCommand(@RequestParam("cPage")String cPage) {
		try {
			ModelAndView mv = new ModelAndView("list");
			// 전체 게시물의 수
			int count = myService.selectCount();
			paging.setTotalRecord(count);
			
			// 전체 페이지의 수
			if(paging.getTotalRecord() <= paging.getNumPerPage()) {
				paging.setTotalPage(1);
			}else {
				paging.setTotalPage(paging.getTotalRecord()/paging.getNumPerPage());
				// 나머지가 존재하면 전체 페이지수에서 1증가 
				if(paging.getTotalRecord()%paging.getNumPerPage() !=0) {
					paging.setTotalPage(paging.getTotalPage()+1);
				}
			}
			
			// 현재 페이지 구하기 
			paging.setNowPage(Integer.parseInt(cPage));
			
			// 시작번호, 끝번호 
			paging.setBegin((paging.getNowPage()-1) * paging.getNumPerPage() + 1);
			paging.setEnd((paging.getBegin()-1) + paging.getNumPerPage());
			
			// 시작블록, 끝블록
			paging.setBeginBlock((int)((paging.getNowPage()-1) / paging.getPagePerBlock()) * paging.getPagePerBlock() +1);
			paging.setEndBlock(paging.getBeginBlock() + paging.getPagePerBlock() - 1);
			
			// 주의사항 : endBlock 이 totalPage 보다 큰 경우 발생 할 수 있다.
			//            이 경우 endBlock를 totalPage에 맞춰야 한다.
			if(paging.getEndBlock() > paging.getTotalPage()) {
				paging.setEndBlock(paging.getTotalPage());
			}
			
			// 시작 번호와 끝번호를 이용해서 list를 구하자
			List<BVO> list = myService.selectBVOList(paging.getBegin(), paging.getEnd());
			
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			return mv;
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("error");
		}
	}
}
