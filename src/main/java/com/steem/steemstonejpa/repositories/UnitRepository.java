package com.steem.steemstonejpa.repositories;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.steem.steemstonejpa.models.Unit;

public interface UnitRepository extends JpaRepository<Unit, Integer> {
	@Query("select u from unit u where u.name = :name or u.kind = :kind")
	Unit findByLastnameOrFirstname(String name, String kind);
}
