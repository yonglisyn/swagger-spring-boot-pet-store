package com.sample.models;

import java.util.Date;

/**
 * Class created without swagger, for comparision purpose
 */
public class MyStep {
    private Integer id;
    private String name;
    private String createdBy;
    private Date createdOn;

    public MyStep(Integer id, String name, String createdBy, Date createdOn) {
        this.id = id;
        this.name = name;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
