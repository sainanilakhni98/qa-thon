package com.nagarro.qathon.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "user_db")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String isAdmin;

    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private UserStatistics userStatistics;

    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private CurrentVisits currentVisits;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<WebsiteVisits> websiteVisits;

    @JsonManagedReference
    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private ConversionRates conversionRates;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<CampaignClicks> campaignClicks;

}
