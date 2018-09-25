package com.wtl.DAOService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wtl.DAOService.Entity.T_user;

public interface UserRepository extends JpaRepository<T_user, Long> {

}
