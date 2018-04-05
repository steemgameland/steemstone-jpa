package com.steem.steemstonejpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.steem.steemstonejpa.models.Notice;

//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
//http://arahansa.github.io/docs_spring/jpa.html

public interface NoticeRepository extends JpaRepository<Notice, Integer> {
	List<Notice> findByNoticeId(int id);
	List<Notice> findByTitle(String title);
	List<Notice> findByContent(String content);
	List<Notice> findByDelYn(String delYn);
	// Sample
//	List<Member> findByNameAndAgeLessThan(String name, int age);
//	
//	@Query("select t from Member t where name=:name and age < :age")
//	List<Member> findByNameAndAgeLessThanSQL(@Param("name") String name, @Param("age") int age);
//	
//	List<Member> findByNameAndAgeLessThanOrderByAgeDesc(String name, int age);
}
