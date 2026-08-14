package com.kristallball.repository;

import com.kristallball.entity.Base;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository extends JpaRepository<Base, Long> {}