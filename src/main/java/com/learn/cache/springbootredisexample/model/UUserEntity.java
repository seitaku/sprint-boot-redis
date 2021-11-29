package com.learn.cache.springbootredisexample.model;

import javax.persistence.*;

@Entity
@Table(name="u_user")
public class UUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer userId;

    @Column(name = "name")
    private String userName;

    @Column(name = "nick")
    private String nickName;

    @Column(name = "type")
    private Integer userType;

    public UUserEntity() {}

    public UUserEntity(Integer userId, String userName, String nickName, Integer userType) {
        this.userId = userId;
        this.userName = userName;
        this.nickName = nickName;
        this.userType = userType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
