package com.example.stin.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

        public UserEntity save(UserEntity userEntity);

        UserEntity findByEmail(String email);

        List<UserEntity> findAll();

        UserEntity findByPassword(String password);




}
