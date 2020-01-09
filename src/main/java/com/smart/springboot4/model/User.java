package com.smart.springboot4.model;

public class User {
    private Integer id;
    private String name;
    private String account_id;
    private String token;
    private Long gtmCreate;
    private Long gtmModified;

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

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGtmCreate() {
        return gtmCreate;
    }

    public void setGtmCreate(Long gtmCreate) {
        this.gtmCreate = gtmCreate;
    }

    public Long getGtmModified() {
        return gtmModified;
    }

    public void setGtmModified(Long gtmModified) {
        this.gtmModified = gtmModified;
    }
}
