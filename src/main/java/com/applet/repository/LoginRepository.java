package com.applet.repository;

import com.applet.entity.SysAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<SysAdmin, Long> {
    SysAdmin findByUsername(String username);
}