package com.tb.koombea.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tb.koombea.model.Link;
import com.tb.koombea.model.Page;
import com.tb.koombea.repository.LinkRepository;
import com.tb.koombea.repository.PageRepository;

@Service
public class PageService {
	
	
	private final PageRepository pageRepository;
	private final LinkRepository linkRepository;




	public PageService(PageRepository pageRepository, LinkRepository linkRepository) {
		this.pageRepository = pageRepository;
		this.linkRepository = linkRepository;

	}
	


//	public List<Page> getAllPagesForUser(Long userId) {
//
//		// Retrieve all pages for a specific user
//		return pageRepository.findByUserId(userId);
//	}
	

	public org.springframework.data.domain.Page<Page> getAllPagesForUser(Long userId, Pageable pageable) {		
		
		
		return pageRepository.findByUserId(userId, pageable);
	}

	public List<Link> getLinksForPage(Long pageId) {
		// Retrieve all links for a specific page

		return linkRepository.findByPageId(pageId);


	}

	public void addPageAndLinks(Page pageScrape, List<Link> links) {
		// Save page and links to the database

		pageRepository.save(pageScrape);
		linkRepository.saveAll(links);

	}
	

}


