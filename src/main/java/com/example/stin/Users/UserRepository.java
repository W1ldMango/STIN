package com.example.stin.Users;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long> {

        public UserEntity save(UserEntity userEntity);
        @Modifying
        @Query(value = "update users set code = ?1 where email = ?2", nativeQuery = true)
        void insertCodeToUser(Integer code, String email);

        @Query(value = "select code from users where email = ?", nativeQuery = true)
        Integer getCodeByEmail(String email);



        UserEntity findByEmail(String email);

        List<UserEntity> findAll();

        UserEntity findByPassword(String password);




}
