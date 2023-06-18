package com.cjss.repo;

import com.cjss.entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
    public Optional<Users> findByEmail(String email);
    public Optional<Users> findByEmailAndMobileNum(String email, String mobileNum);

    //select u from users u where u.email = :e and u.city = :c
    @Query(value = "select * FROM users WHERE email = :e and city = :c", nativeQuery = true)
    public List<Users> findUserByEmailAndCity(@Param("e") String email, @Param("c") String city);

    @Transactional
    @Modifying
    @Query("update Users SET userName =:name, email =:e WHERE userId =:id")
    public void updateUserById(@Param("id") Long id, @Param("name") String name, @Param("e") String email);

}
