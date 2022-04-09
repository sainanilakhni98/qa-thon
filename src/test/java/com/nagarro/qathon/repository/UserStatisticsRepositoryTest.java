package com.nagarro.qathon.repository;

import com.nagarro.qathon.entity.User;
import com.nagarro.qathon.entity.UserStatistics;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserStatisticsRepositoryTest {

    @Autowired
    private UserStatisticsRepository userStatisticsRepository;

    @Test
    public void SaveUserStatistics(){
        User user = User.builder()
              .id(2L).
                build();

//        UserStatistics userStatistics = UserStatistics.builder()
//                .creditScore(14.5)
//                .bugReports(11.2)
//                .weeklySales(2.6)
//                .newUsers(1.8)
//                .build();

//        userStatisticsRepository.save(userStatistics);
    }


}