package com.bean;



/**
 * UserScoreMovic entity. @author MyEclipse Persistence Tools
 */

public class UserScoreMovic  implements java.io.Serializable {


    // Fields    

     private Integer usmOid;
     private UserInfo userInfo;
     private MovicInfo movicInfo;
     private Double score;


    // Constructors

    /** default constructor */
    public UserScoreMovic() {
    }

    
    /** full constructor */
    public UserScoreMovic(UserInfo userInfo, MovicInfo movicInfo, Double score) {
        this.userInfo = userInfo;
        this.movicInfo = movicInfo;
        this.score = score;
    }

   
    // Property accessors

    public Integer getUsmOid() {
        return this.usmOid;
    }
    
    public void setUsmOid(Integer usmOid) {
        this.usmOid = usmOid;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }
    
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public MovicInfo getMovicInfo() {
        return this.movicInfo;
    }
    
    public void setMovicInfo(MovicInfo movicInfo) {
        this.movicInfo = movicInfo;
    }

    public Double getScore() {
        return this.score;
    }
    
    public void setScore(Double score) {
        this.score = score;
    }
   








}