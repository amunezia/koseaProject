package com.kosea.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosea.project.service.QnaService;
import com.kosea.project.vo.QnaVO;
import com.kosea.project.vo.UsersVO;

@Controller
@RequestMapping("/qna")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@GetMapping(value="/writeQna")
	public void getWriteQna() throws Exception{
	}
	
	@PostMapping(value="/writeQna")
	public String postWriteQna(QnaVO vo,HttpServletRequest req) throws Exception{
		HttpSession session=req.getSession();
		UsersVO userinfo=(UsersVO) session.getAttribute("userinfo");
		vo.setQna_writer(userinfo.getUserId());
		qnaService.write(vo);
		return "redirect:/qna/qna";
	}
	
	@GetMapping(value="/qnaList")
	public void getQnaList(Model model) throws Exception{
		List<QnaVO> qnaList=qnaService.list();
		model.addAttribute("qnaList",qnaList);
	}
	
	@GetMapping(value="/viewQna")
	public void getViewQna(Model model,@RequestParam("qna_no")int qna_no) throws Exception{
		QnaVO qnaView=qnaService.view(qna_no);
		model.addAttribute("qnaView",qnaView);
	}
	
	@GetMapping(value="/qnaDelete")
	public String getQnaDelete(@RequestParam("qna_no")int qna_no) throws Exception{
		qnaService.delete(qna_no);
		return "redirect:/qna/qna";
	}
	
	@GetMapping(value="/qnaModify")
	public void getQnaModify(Model model,@RequestParam("qna_no")int qna_no) throws Exception{
		QnaVO qnaModify=qnaService.view(qna_no);
		model.addAttribute("qnaModify",qnaModify);
	}
	
	@PostMapping(value="/qnaModify")
	public String postQnaModify(QnaVO vo) throws Exception{
		qnaService.modify(vo);
		return "redirect:/qna/qnaList";
	}
}
