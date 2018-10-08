package com.bioFish.DAOService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bioFish.DAOService.Entity.T_user;

public interface UserRepository extends JpaRepository<T_user, Long> {

}
