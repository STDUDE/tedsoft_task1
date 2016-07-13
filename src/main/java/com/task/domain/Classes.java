package com.task.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Antony on 10.07.2016.
 */

@Entity
@Table(name = "classes")
public class Classes implements Serializable{

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "classname", nullable = false, length = 45)
    private String classname;

    @Column(name = "status")
    private boolean status;

    public Classes() {

    }
    public Classes(String classname) {
        this.classname = classname;
    }

    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getClassName(){
        return this.classname;
    }
    public void setClassName(String classname) {
        this.classname = classname;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}
