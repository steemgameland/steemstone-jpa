package com.steem.steemstonejpa.repositories;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.steem.steemstonejpa.models.Unit;

public interface UnitRepository extends JpaRepository<Unit, Integer> {
	List<Unit> findByName(String name);
	List<Unit> findByNameIgnoreCase(String name);
	List<Unit> findByLevel(int level);
//	@Query("select u from unit u where u.name = :name or u.kind = :kind")
//	Unit findByLastnameOrFirstname(String name, String kind);
}
