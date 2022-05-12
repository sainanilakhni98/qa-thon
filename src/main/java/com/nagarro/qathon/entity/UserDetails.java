package com.nagarro.qathon.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "userDetails_sequence",
            sequenceName = "userDetails_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userDetails_sequence"
    )
    private Long id;
    private String name;
    private String company;
    private String role;
    private String verified;
    private String status;

}
