package com.nagarro.qathon.repository;

import com.nagarro.qathon.entity.CampaignClicks;
import com.nagarro.qathon.entity.ConversionRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignClicksRepository extends JpaRepository<CampaignClicks,Long> {

}
