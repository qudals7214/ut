package com.solo.solo.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("userRepository")
public interface UserRepository extends JpaRepository<UserVO , Long> {
//  JPA : Java <-> Database 간의 자동 번역기 역할을 수행


//    @Query(value = "select * from users order by created_at desc" , nativeQuery = true)
//    public List<UserVO> findAllOrderd();

//    List<UserVO> findAllByOrderByCreatedAt();

//    @Query(value = "select * from solo.users where id = ?1 and pw = ?2", nativeQuery = true)
//    List<UserVO> logCheck(String id, String pw);




    /////////////////////////////////////////카카오
    @Query(value = "insert into solo.users (`id`,`name`,`platform`) values (?1 , ?2 , ?3)" , nativeQuery = true)
    void insertUser(String id , String name , String platform);

    // 정보 확인
    @Query(value = "select * from solo.users where id = ?1 and platform = ?2", nativeQuery = true)
    List<UserVO> findUser(String id , String social);
    /////////////////////////////////////////카카오
}
