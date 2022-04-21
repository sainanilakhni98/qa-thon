package com.nagarro.qathon.service.impl;

import com.nagarro.qathon.Utility;
import com.nagarro.qathon.dashboardDataCreator.*;
import com.nagarro.qathon.entity.*;
import com.nagarro.qathon.repository.*;
import com.nagarro.qathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserStatisticsRepository userStatisticsRepository;

    @Autowired
    private CurrentVisitsRepository currentVisitsRepository;

    @Autowired
    private WebsiteVisitsRepository websiteVisitsRepository;

    @Autowired
    private ConversionRatesRepository conversionRatesRepository;

    @Autowired
    private CampaignClicksRepository campaignClicksRepository;

    @Override
    public User register(User user) {
        user.setPassword(Utility.convertStringToAsciiValue(user.getPassword()));
        user.setEmail(Utility.convertStringToAsciiValue(user.getEmail()));
        //userstatistics
        userStatisticsRepository.save(UserStatisticsCreator.getUserStatistics(user));
        //currentvisits
        currentVisitsRepository.save(CurrentVisitsCreator.getCurrentVisits(user));
        //websitesVisits
        websiteVisitsRepository.saveAll(WebsiteVisitsCreator.getWebsiteVisits(user));
        //conversionRates
        conversionRatesRepository.save(ConversionRatesCreator.getConversionRates(user));
        //campaignClicks
        campaignClicksRepository.saveAll(CampaignClicksCreator.getCampaignClicks(user));
        System.out.println(CampaignClicksCreator.getCampaignClicks(user));
        return userRepository.save(user);
    }
    @Override
    public User login(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User fetchUserByEmailAndPassword(String email, String password) throws Exception {
        return this.userRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public User getUser(String email) throws Exception {
        return this.userRepository.findByEmail(email);
    }


    @Override
    public List<User> getAllRegisteredUsers() {
        return this.userRepository.findAll();
    }
}
