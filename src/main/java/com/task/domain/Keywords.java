package com.task.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.security.Key;

/**
 * Created by Antony on 10.07.2016.
 */

@Entity
@Table(name = "keywords")
public class Keywords implements Serializable{
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "keyword", nullable = false, length = 45)
    private String keyword;

    @ManyToOne
    @JoinColumn(name = "binded_class")
    private Classes binded_class;

    public Keywords() {

    }

    public Keywords(String keyword, Classes binded_class) {
        this.keyword = keyword;
        this.binded_class = binded_class;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getKeyword() {
        return keyword;
    }
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public Classes getBinded_class() {
        return binded_class;
    }
    public void setBinded_class(Classes binded_class) {
        this.binded_class = binded_class;
    }
}
