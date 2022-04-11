package com.nagarro.qathon.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "campaign_clicks")
public class CampaignClicks {
    @Id
    @SequenceGenerator(
            name = "CampaignClicks_sequence",
            sequenceName = "CampaignClicks_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CampaignClicks_sequence"
    )
    private Long campaignClicksId;
    private Integer campaignOneClicks;
    private Integer campaignTwoClicks;
    private Integer campaignThreeClicks;
    private String cityName;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    @JsonBackReference
    private User user;

    public CampaignClicks(Integer campaignOneClicks, Integer campaignTwoClicks, Integer campaignThreeClicks, String cityName, User user) {
        this.campaignOneClicks = campaignOneClicks;
        this.campaignTwoClicks = campaignTwoClicks;
        this.campaignThreeClicks = campaignThreeClicks;
        this.cityName = cityName;
        this.user = user;
    }
}
