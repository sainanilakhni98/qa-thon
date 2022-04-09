package com.nagarro.qathon.repository;

import com.nagarro.qathon.entity.CurrentVisits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentVisitsRepository extends JpaRepository<CurrentVisits,Long> {

}
