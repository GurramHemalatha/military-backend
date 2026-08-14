package com.kristallball.repository;

import com.kristallball.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findAllByOrderByCreatedAtDesc();
}