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
import java.util.stream.Collectors;

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

        userStatisticsRepository.save(getUserStatistics(user));
        //currentvisits
        currentVisitsRepository.save(CurrentVisitsCreator.getCurrentVisits(user));
        //websitesVisits
        websiteVisitsRepository.saveAll(WebsiteVisitsCreator.getWebsiteVisits(user));
        //conversionRates
        conversionRatesRepository.save(ConversionRatesCreator.getConversionRates(user));
        //campaignClicks
        campaignClicksRepository.saveAll(CampaignClicksCreator.getCampaignClicks(user));

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

    @Override
    public void  deleteRegisteredUsersFromBackend(long userId) {
//        Optional<User> user = this.userRepository.findById(userId);
//        System.out.println(user.get().getFirstName());
//        System.out.println("userid is --" + userId);
//        this.userRepository.delete(user.get());
        List<User> list = getAllRegisteredUsers();
        list = list.stream().filter(user->user.getId()!=userId).collect(Collectors.toList());
        this.userRepository.saveAll(list);
    }

    @Override
    public List<User> findByFirstnameIgnoreCase(String firstname) {
        return this.userRepository.findByFirstNameIgnoreCase(firstname);
    }


    public UserStatistics getUserStatistics(User user){
        UserStatistics userStatistics = new UserStatistics();
        userStatistics.setCreditScore((double)Utility.generateIntRandomNumber(2,20));
        userStatistics.setWeeklySales((double)Utility.generateIntRandomNumber(714,800));
        long totalUsers = this.userRepository.count() + 1;
        userStatistics.setNewUsers((double) totalUsers);
        userStatistics.setBugReports((double)Utility.generateIntRandomNumber(100,400));
        userStatistics.setUser(user);

        return userStatistics;
    }
}
