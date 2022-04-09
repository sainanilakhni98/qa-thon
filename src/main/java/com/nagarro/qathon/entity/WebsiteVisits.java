package com.nagarro.qathon.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "website_visits")
public class WebsiteVisits {

    @Id
    @SequenceGenerator(
            name = "websiteVisits_sequence",
            sequenceName = "websiteVisits_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "websiteVisits_sequence"
    )
    private Long websiteVisitsId;
    private Integer youtubeVisits;
    private Integer googleVisits;
    private Integer facebookVisits;
    private String monthAndYear;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    @JsonBackReference
    private User user;

    public WebsiteVisits(Integer youtubeVisits, Integer googleVisits, Integer facebookVisits, String monthAndYear, User user) {
        this.youtubeVisits = youtubeVisits;
        this.googleVisits = googleVisits;
        this.facebookVisits = facebookVisits;
        this.monthAndYear = monthAndYear;
        this.user = user;
    }
}
