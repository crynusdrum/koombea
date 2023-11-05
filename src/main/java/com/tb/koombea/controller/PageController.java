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

	
	/**
	 *  As a user, I should be able to see a list of all the pages that I have scrapped with the number of links that the scraper found.
	 * @param userId
	 * @return
	 */
	@GetMapping("/{userId}")
	public Page<com.tb.koombea.model.Page> getUserPages(@PathVariable Long userId) {

		Pageable pageable = PageRequest.of(0, 2);
		Page<com.tb.koombea.model.Page> userpages =  pageService.getAllPagesForUser(userId, pageable);

		
		return userpages;

	}
	
	
	/**
	 * As a user, I should be able to see the details of all the links of a particular page,
	 *	that means the url of a link and the “name” of a link.
	 *
	 * Pagination in the list of pages and the list of links
	 * 
	 * As a user, when I see the list of pages, I should be able to see the ones that are
	 *	currently being processed.
	 * 
	 * 
	 * @param pageId
	 * @return
	 */
	@GetMapping("/links/{pageId}")
	public List<Link> getLinksForPage(@PathVariable Long pageId) {
		return pageService.getLinksForPage(pageId);
	}


}
