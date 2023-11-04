package com.tb.koombea.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tb.koombea.model.Link;

import com.tb.koombea.service.PageService;

@RestController
@RequestMapping("/v1/page")
public class PageController {
	

	
	private final PageService pageService;




	public PageController(PageService pageService) {

		this.pageService = pageService;
	}



	@GetMapping("/{userId}")
	public Page<com.tb.koombea.model.Page> getUserPages(@PathVariable Long userId) {

		Pageable pageable = PageRequest.of(0, 2);
		Page<com.tb.koombea.model.Page> userpages =  pageService.getAllPagesForUser(userId, pageable);

		
		return userpages;

	}
	
	@GetMapping("/links/{pageId}")
	public List<Link> getLinksForPage(@PathVariable Long pageId) {
		return pageService.getLinksForPage(pageId);
	}


}
