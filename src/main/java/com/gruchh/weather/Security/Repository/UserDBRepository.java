package com.gruchh.weather.Security.Repository;

import com.gruchh.weather.Security.Entity.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDBRepository extends JpaRepository<UserDB, Long> {

    Optional<UserDB> findByEmail(String email);
}
