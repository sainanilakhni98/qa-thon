package com.nagarro.qathon.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "current_visits")
public class CurrentVisits {

    @Id
    @SequenceGenerator(
            name = "CurrentVisits_sequence",
            sequenceName = "CurrentVisits_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CurrentVisits_sequence"
    )
    private Long currentVisitsId;
    private Double asiaPercentage;
    private Double europePercentage;
    private Double africaPercentage;
    private Double americaPercentage;

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

    public CurrentVisits(Double asiaPercentage, Double europePercentage, Double africaPercentage, Double americaPercentage, User user) {
        this.asiaPercentage = asiaPercentage;
        this.europePercentage = europePercentage;
        this.africaPercentage = africaPercentage;
        this.americaPercentage = americaPercentage;
        this.user = user;
    }
}
