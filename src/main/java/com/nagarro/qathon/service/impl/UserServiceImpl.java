package com.nagarro.qathon.service.impl;

import com.nagarro.qathon.Utility;
import com.nagarro.qathon.dashboardDataCreator.ConversionRatesCreator;
import com.nagarro.qathon.dashboardDataCreator.CurrentVisitsCreator;
import com.nagarro.qathon.dashboardDataCreator.UserStatisticsCreator;
import com.nagarro.qathon.dashboardDataCreator.WebsiteVisitsCreator;
import com.nagarro.qathon.entity.*;
import com.nagarro.qathon.repository.*;
import com.nagarro.qathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
