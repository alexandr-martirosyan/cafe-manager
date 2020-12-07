package com.company.cafemanager.dao.user;

import com.company.cafemanager.entity.user.ERole;
import com.company.cafemanager.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleDao extends JpaRepository<Role, ERole> {
}
