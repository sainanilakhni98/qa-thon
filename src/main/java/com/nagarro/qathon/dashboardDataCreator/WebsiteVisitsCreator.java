package com.nagarro.qathon.dashboardDataCreator;

import com.nagarro.qathon.Utility;
import com.nagarro.qathon.entity.User;
import com.nagarro.qathon.entity.UserStatistics;
import com.nagarro.qathon.entity.WebsiteVisits;

import java.util.ArrayList;
import java.util.List;

public class WebsiteVisitsCreator {
    public static List<WebsiteVisits> getWebsiteVisits(User user){
        List<WebsiteVisits> listOfwebsiteVisits = new ArrayList<>();

        WebsiteVisits janWebsiteVisits = new WebsiteVisits();
        janWebsiteVisits.setUser(user);
        janWebsiteVisits.setFacebookVisits(Utility.generateIntRandomNumber(30,40));
        janWebsiteVisits.setYoutubeVisits(Utility.generateIntRandomNumber(20,40));
        janWebsiteVisits.setGoogleVisits(Utility.generateIntRandomNumber(10,40));
        janWebsiteVisits.setMonthAndYear("January 2021");
        listOfwebsiteVisits.add(janWebsiteVisits);

        WebsiteVisits febWebsiteVisits = new WebsiteVisits();
        febWebsiteVisits.setUser(user);
        febWebsiteVisits.setGoogleVisits(Utility.generateIntRandomNumber(10,40));
        febWebsiteVisits.setFacebookVisits(Utility.generateIntRandomNumber(10,40));
        febWebsiteVisits.setYoutubeVisits(Utility.generateIntRandomNumber(10,40));
        febWebsiteVisits.setMonthAndYear("February 2021");
        listOfwebsiteVisits.add(febWebsiteVisits);

        WebsiteVisits marchWebsiteVisits = new WebsiteVisits();
        marchWebsiteVisits.setUser(user);
        marchWebsiteVisits.setGoogleVisits(Utility.generateIntRandomNumber(10,40));
        marchWebsiteVisits.setFacebookVisits(Utility.generateIntRandomNumber(30,60));
        marchWebsiteVisits.setYoutubeVisits(Utility.generateIntRandomNumber(50,70));
        marchWebsiteVisits.setMonthAndYear("March 2021");
        listOfwebsiteVisits.add(marchWebsiteVisits);

        WebsiteVisits aprilWebsiteVisits = new WebsiteVisits();
        aprilWebsiteVisits.setUser(user);
        aprilWebsiteVisits.setGoogleVisits(Utility.generateIntRandomNumber(20,80));
        aprilWebsiteVisits.setFacebookVisits(Utility.generateIntRandomNumber(10,60));
        aprilWebsiteVisits.setYoutubeVisits(Utility.generateIntRandomNumber(30,40));
        aprilWebsiteVisits.setMonthAndYear("April 2021");
        listOfwebsiteVisits.add(aprilWebsiteVisits);

        WebsiteVisits mayWebsiteVisits = new WebsiteVisits();
        mayWebsiteVisits.setUser(user);
        mayWebsiteVisits.setGoogleVisits(Utility.generateIntRandomNumber(60,90));
        mayWebsiteVisits.setFacebookVisits(Utility.generateIntRandomNumber(40,60));
        mayWebsiteVisits.setYoutubeVisits(Utility.generateIntRandomNumber(10,40));
        mayWebsiteVisits.setMonthAndYear("May 2021");
        listOfwebsiteVisits.add(mayWebsiteVisits);

        WebsiteVisits juneWebsiteVisits = new WebsiteVisits();
        juneWebsiteVisits.setUser(user);
        juneWebsiteVisits.setGoogleVisits(Utility.generateIntRandomNumber(60,90));
        juneWebsiteVisits.setFacebookVisits(Utility.generateIntRandomNumber(40,60));
        juneWebsiteVisits.setYoutubeVisits(Utility.generateIntRandomNumber(10,40));
        juneWebsiteVisits.setMonthAndYear("June 2021");
        listOfwebsiteVisits.add(juneWebsiteVisits);

        WebsiteVisits julyWebsiteVisits = new WebsiteVisits();
        julyWebsiteVisits.setUser(user);
        julyWebsiteVisits.setGoogleVisits(Utility.generateIntRandomNumber(10,40));
        julyWebsiteVisits.setFacebookVisits(Utility.generateIntRandomNumber(30,60));
        julyWebsiteVisits.setYoutubeVisits(Utility.generateIntRandomNumber(50,70));
        julyWebsiteVisits.setMonthAndYear("July 2021");
        listOfwebsiteVisits.add(julyWebsiteVisits);

        WebsiteVisits augWebsiteVisits = new WebsiteVisits();
        augWebsiteVisits.setUser(user);
        augWebsiteVisits.setGoogleVisits(Utility.generateIntRandomNumber(10,40));
        augWebsiteVisits.setFacebookVisits(Utility.generateIntRandomNumber(10,40));
        augWebsiteVisits.setYoutubeVisits(Utility.generateIntRandomNumber(10,40));
        augWebsiteVisits.setMonthAndYear("August 2021");
        listOfwebsiteVisits.add(augWebsiteVisits);

        WebsiteVisits sepWebsiteVisits = new WebsiteVisits();
        sepWebsiteVisits.setUser(user);
        sepWebsiteVisits.setGoogleVisits(Utility.generateIntRandomNumber(60,90));
        sepWebsiteVisits.setFacebookVisits(Utility.generateIntRandomNumber(40,60));
        sepWebsiteVisits.setYoutubeVisits(Utility.generateIntRandomNumber(10,40));
        sepWebsiteVisits.setMonthAndYear("September 2021");
        listOfwebsiteVisits.add(sepWebsiteVisits);

        WebsiteVisits octWebsiteVisits = new WebsiteVisits();
        octWebsiteVisits.setUser(user);
        octWebsiteVisits.setGoogleVisits(Utility.generateIntRandomNumber(10,40));
        octWebsiteVisits.setFacebookVisits(Utility.generateIntRandomNumber(30,60));
        octWebsiteVisits.setYoutubeVisits(Utility.generateIntRandomNumber(50,70));
        octWebsiteVisits.setMonthAndYear("October 2021");
        listOfwebsiteVisits.add(octWebsiteVisits);

        WebsiteVisits novWebsiteVisits = new WebsiteVisits();
        novWebsiteVisits.setUser(user);
        novWebsiteVisits.setGoogleVisits(Utility.generateIntRandomNumber(10,40));
        novWebsiteVisits.setFacebookVisits(Utility.generateIntRandomNumber(30,60));
        novWebsiteVisits.setYoutubeVisits(Utility.generateIntRandomNumber(50,70));
        novWebsiteVisits.setMonthAndYear("November 2021");
        listOfwebsiteVisits.add(novWebsiteVisits);

        WebsiteVisits decWebsiteVisits = new WebsiteVisits();
        decWebsiteVisits.setUser(user);
        decWebsiteVisits.setGoogleVisits(Utility.generateIntRandomNumber(60,90));
        decWebsiteVisits.setFacebookVisits(Utility.generateIntRandomNumber(40,60));
        decWebsiteVisits.setYoutubeVisits(Utility.generateIntRandomNumber(10,40));
        decWebsiteVisits.setMonthAndYear("December 2021");
        listOfwebsiteVisits.add(decWebsiteVisits);


        return listOfwebsiteVisits;
    }
}
