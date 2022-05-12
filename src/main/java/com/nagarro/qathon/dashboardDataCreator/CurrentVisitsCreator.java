package com.nagarro.qathon.dashboardDataCreator;

import com.nagarro.qathon.Utility;
import com.nagarro.qathon.entity.ConversionRates;
import com.nagarro.qathon.entity.CurrentVisits;
import com.nagarro.qathon.entity.User;

public class CurrentVisitsCreator {
    public static CurrentVisits getCurrentVisits(User user){
        return new CurrentVisits(
                (double)Utility.generateIntRandomNumber(9,32),(double)Utility.generateIntRandomNumber(19,30),
                (double)Utility.generateIntRandomNumber(9,32),(double)Utility.generateIntRandomNumber(20,32),
                user
        );
    }
}
