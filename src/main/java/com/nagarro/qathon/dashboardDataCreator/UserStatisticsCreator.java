package com.nagarro.qathon.dashboardDataCreator;

import com.nagarro.qathon.Utility;
import com.nagarro.qathon.entity.User;
import com.nagarro.qathon.entity.UserStatistics;

public class UserStatisticsCreator {
    public static UserStatistics getUserStatistics(User user){
        return new UserStatistics(
                Utility.generateIntRandomNumber(2,20)+Math.random(),Utility.generateIntRandomNumber(714,800)+Math.random(),
                Utility.generateIntRandomNumber(1,16)+Math.random(),Utility.generateIntRandomNumber(100,400)+Math.random(),
                user
        );
    }
}
