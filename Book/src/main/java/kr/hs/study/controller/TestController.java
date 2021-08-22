package kr.hs.study.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.hs.study.model.dto.BookDTO;
import kr.hs.study.model.dto.LoginDTO;

@Controller
public class TestController {
	@Autowired
	SqlSessionTemplate  sessionTemplate;
	
	
	@GetMapping("/book")
	public String book() {
		return "book/book_form";
	}
	
	@PostMapping("/book")
	public String book_re(@ModelAttribute BookDTO dto) {
		sessionTemplate.insert("book.insert_data", dto);
		return "result";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam String title) {
		sessionTemplate.delete("book.delete_data", title);
		return "result";		
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<BookDTO> list = sessionTemplate.selectList("book.list");
		model.addAttribute("list", list);
		return "result2";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam String title, Model model) {
		BookDTO dto = sessionTemplate.selectOne("book.selectOne", title);
		model.addAttribute("dto", dto);
		return "result3";
	}
	
	@PostMapping("/update")
	public String update(BookDTO dto) {
		sessionTemplate.update("book.update", dto);
		System.out.println("dto : " + dto.getAuthor());
		return "result";
	}
}