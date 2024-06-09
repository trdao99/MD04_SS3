package com.ra.md04_ss3_validation.reponsitory;

import com.ra.md04_ss3_validation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReponsitoryUser extends PagingAndSortingRepository<User,Integer>, JpaRepository<User,Integer> {
//    @Query("select acc from Account acc where acc.fullName like concat('%',:name,'%')")
    List<User> findUserByFullNameContains(String name);
    User findUserByUsername(String username);
}