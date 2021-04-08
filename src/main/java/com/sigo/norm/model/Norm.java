package com.sigo.norm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "norms")
public class Norm {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String title;
    private String committee;
    private Date publicationDate;
    private String status;
    private String link;
    private String description;
    private String areaName;
    private Integer areaDepartment;
}
