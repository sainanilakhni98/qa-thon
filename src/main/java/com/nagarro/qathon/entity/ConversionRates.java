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
@Table(name = "conversion_rates")
public class ConversionRates {

    @Id
    @SequenceGenerator(
            name = "conversionRates_sequence",
            sequenceName = "conversionRates_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "conversionRates_sequence"
    )
    private Long conversionRatesId;
    private Integer incrementConversionRateCompareToLastYear;
    private Integer italyConversionRate;
    private Integer japanConversionRate;
    private Integer chinaConversionRate;
    private Integer canadaConversionRate;
    private Integer franceConversionRate;
    private Integer germanyConversionRate;
    private Integer southKoreaConversionRate;
    private Integer netherlandsConversionRate;
    private Integer unitedStatesConversionRate;
    private Integer unitedKingdomConversionRate;

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

    public ConversionRates(Integer incrementConversionRateCompareToLastYear, Integer italyConversionRate, Integer japanConversionRate, Integer chinaConversionRate, Integer canadaConversionRate, Integer franceConversionRate, Integer germanyConversionRate, Integer southKoreaConversionRate, Integer netherlandsConversionRate, Integer unitedStatesConversionRate, Integer unitedKingdomConversionRate, User user) {
        this.incrementConversionRateCompareToLastYear = incrementConversionRateCompareToLastYear;
        this.italyConversionRate = italyConversionRate;
        this.japanConversionRate = japanConversionRate;
        this.chinaConversionRate = chinaConversionRate;
        this.canadaConversionRate = canadaConversionRate;
        this.franceConversionRate = franceConversionRate;
        this.germanyConversionRate = germanyConversionRate;
        this.southKoreaConversionRate = southKoreaConversionRate;
        this.netherlandsConversionRate = netherlandsConversionRate;
        this.unitedStatesConversionRate = unitedStatesConversionRate;
        this.unitedKingdomConversionRate = unitedKingdomConversionRate;
        this.user = user;
    }
}
