package com.solo.solo.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("userRepository")
public interface UserRepository extends JpaRepository<UserVO , String> {
//  JPA : Java <-> Database 간의 자동 번역기 역할을 수행


//    @Query(value = "select * from users order by created_at desc" , nativeQuery = true)
//    public List<UserVO> findAllOrderd();

    List<UserVO> findAllByOrderByCreatedAt();

    @Query(value = "select * from users where id = ?1 and pw = ?2", nativeQuery = true)
    List<UserVO> logCheck(String id, String pw);
}
