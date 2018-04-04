package com.steem.steemstonejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.steem.steemstonejpa.models.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {

}
