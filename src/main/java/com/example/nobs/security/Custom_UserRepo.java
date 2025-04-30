package com.example.nobs.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Custom_UserRepo extends JpaRepository<Custom_User,String> {
}
