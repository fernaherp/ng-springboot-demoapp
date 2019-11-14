package com.dxc.demoapp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * ProductDto
 */
@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "shortname")
    private String shortname;
    @Column(name = "longname")
    private String longname;

}