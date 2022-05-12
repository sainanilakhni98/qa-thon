package com.nagarro.qathon.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_statistics")
public class UserStatistics {

    @Id
    @SequenceGenerator(
            name = "UserStatistics_sequence",
            sequenceName = "UserStatistics_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "UserStatistics_sequence"
    )
    private Long userStatisticsId;
    private Double creditScore;
    private Double weeklySales;
    private Double newUsers;
    private Double bugReports;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    @JsonBackReference
    private User user;

    public UserStatistics(Double creditScore, Double weeklySales, Double newUsers, Double bugReports, User user) {
        this.creditScore = creditScore;
        this.weeklySales = weeklySales;
        this.newUsers = newUsers;
        this.bugReports = bugReports;
        this.user = user;
    }


}

