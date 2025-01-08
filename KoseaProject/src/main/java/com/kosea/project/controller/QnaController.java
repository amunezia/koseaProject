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
import com.kosea.project.vo.QnaReVO;
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
		return "redirect:/qna/qnaList";
	}
	
	@GetMapping(value="/qnaList")
	public void getQnaList(Model model,@RequestParam(value="num",defaultValue="1")int num,
							@RequestParam(value="searchType",required=false,defaultValue="title")String searchType,
							@RequestParam(value="keyword",required=false,defaultValue="")String keyword,
							@RequestParam(value="tag",required=false,defaultValue="")String tag
			) throws Exception{
		QnaVO page=new QnaVO();
		page.setNum(num);
		page.setCount(qnaService.count(keyword,searchType,tag));
		
		page.setKeyword(keyword);
		page.setSearchType(searchType);
		page.setQna_tag(tag);
		
		List<QnaVO> qnaList=null;
		qnaList=qnaService.listPage(page.getNum(),page.getPageNumCnt(),keyword,searchType,tag);
		
		model.addAttribute("page",page);
		model.addAttribute("select",num);
		model.addAttribute("qnaList",qnaList);
	}
	
	@GetMapping(value="/viewQna")
	public void getViewQna(Model model,@RequestParam("qna_no")int qna_no) throws Exception{
		QnaVO qnaView=qnaService.view(qna_no);
		model.addAttribute("qnaView",qnaView);
		
		//QNAコメント
		List<QnaReVO> come=null;
		come=qnaService.replyList(qna_no);
		model.addAttribute("come",come);
	}
	
	@GetMapping(value="/qnaDelete")
	public String getQnaDelete(@RequestParam("qna_no")int qna_no) throws Exception{
		qnaService.delete(qna_no);
		return "redirect:/qna/qnaList";
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
	
	//QNAコメント
	@PostMapping(value="/qnaRe")
	public String postQnaRe(QnaReVO rvo) throws Exception{
		qnaService.writeReply(rvo);
		return "redirect:/qna/viewQna?qna_no="+rvo.getQna_no();
	}
	
	@GetMapping(value="/qnaReModify")
	public void getQnaReModify(Model model,@RequestParam("qna_no")int qna_no,@RequestParam("qna_rno")int qna_rno) throws Exception{
		QnaReVO rvo=new QnaReVO();
		rvo.setQna_no(qna_no);
		rvo.setQna_rno(qna_rno);
		rvo=qnaService.viewReply(rvo);
		model.addAttribute("come",rvo);
	}
	
	@PostMapping(value="/qnaReModify")
	public String postQnaReModify(QnaReVO rvo) throws Exception{
		qnaService.modifyReply(rvo);
		return "redirect:/qna/viewQna?qna_no="+rvo.getQna_no();
	}
	
	@GetMapping(value="/qnaReDelete")
	public String getQnaReDelete(QnaReVO rvo,@RequestParam("qna_no")int qna_no) throws Exception{
		qnaService.deleteReply(rvo);
		return "redirect:/qna/viewQna?qna_no="+qna_no;
	}
}
