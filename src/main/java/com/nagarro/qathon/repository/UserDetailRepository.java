package com.nagarro.qathon.repository;

import com.nagarro.qathon.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetails,Long> {

}
