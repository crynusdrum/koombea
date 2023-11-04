package com.tb.koombea.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<com.tb.koombea.model.Page, Long>{
	
	 //List<com.tb.koombea.model.Page> findByUserId(Long userId);
	 
	 Page<com.tb.koombea.model.Page> findByUserId(Long userId, Pageable pageable);

}
