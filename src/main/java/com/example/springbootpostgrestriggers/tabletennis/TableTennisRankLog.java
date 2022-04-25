package com.example.springbootpostgrestriggers.tabletennis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableTennisRankLog {
    @Id
    @SequenceGenerator(name="ttlog-seq",sequenceName = "TTR_LOG_ID_SEQ",initialValue = 20, allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ttlog-seq")
    private Integer id;
    @Column(nullable = false, columnDefinition = "text")
    private String name;
    @Column(nullable = false, columnDefinition = "text")
    private String clubName;
    @Column(nullable = false, columnDefinition = "int")
    private Integer points;
    @Column(nullable = false)
    private LocalDateTime timestamp;
}
