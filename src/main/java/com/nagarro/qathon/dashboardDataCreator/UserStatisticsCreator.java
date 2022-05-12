package com.nagarro.qathon.dashboardDataCreator;

import com.nagarro.qathon.Utility;
import com.nagarro.qathon.entity.User;
import com.nagarro.qathon.entity.UserStatistics;

public class UserStatisticsCreator {
    public static UserStatistics getUserStatistics(User user){
        return new UserStatistics(
                (double) Utility.generateIntRandomNumber(2,20), (double) Utility.generateIntRandomNumber(714,800),
                (double)Utility.generateIntRandomNumber(1,16)+Math.random(),(double)Utility.generateIntRandomNumber(100,400),
                user
        );
    }
}
