package com.example.springbootpostgrestriggers.tabletennis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableTennisRank {
    @Id
    @SequenceGenerator(name="tt-seq",sequenceName = "TTR_ID_SEQ",initialValue = 20, allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tt-seq")
    private Integer id;
    @Column(nullable = false, columnDefinition = "text")
    private String name;
    @Column(nullable = false, columnDefinition = "text")
    private String clubName;
    @Column(nullable = false, columnDefinition = "int")
    private Integer points;
}
