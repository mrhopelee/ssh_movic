package com.bean;



/**
 * UserIntegral entity. @author MyEclipse Persistence Tools
 */

public class UserIntegral  implements java.io.Serializable {


    // Fields    

     private Integer uintegralOid;
     private UserInfo userInfo;
     private Integer userScore;


    // Constructors

    /** default constructor */
    public UserIntegral() {
    }

	/** minimal constructor */
    public UserIntegral(Integer userScore) {
        this.userScore = userScore;
    }
    
    /** full constructor */
    public UserIntegral(UserInfo userInfo, Integer userScore) {
        this.userInfo = userInfo;
        this.userScore = userScore;
    }

   
    // Property accessors

    public Integer getUintegralOid() {
        return this.uintegralOid;
    }
    
    public void setUintegralOid(Integer uintegralOid) {
        this.uintegralOid = uintegralOid;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }
    
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Integer getUserScore() {
        return this.userScore;
    }
    
    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }
   








}