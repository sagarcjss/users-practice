package com.cjss.entity;

import jakarta.persistence.*;

@Entity
public class Users {
    @Id
    @SequenceGenerator(initialValue = 100, name = "userId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userId")
    private Long userId;
    private String userName;
    private String email;
    private String mobileNum;
    private String gender;
    private String city; //hyd pune mumbai

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", mobileNum=" + mobileNum +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}
