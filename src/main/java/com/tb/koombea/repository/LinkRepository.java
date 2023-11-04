package com.tb.koombea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tb.koombea.model.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long>{
	
	List<Link> findByPageId(Long pageId);

}
