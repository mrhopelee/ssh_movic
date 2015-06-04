package com.bean;

import java.sql.Timestamp;


/**
 * MovicComments entity. @author MyEclipse Persistence Tools
 */

public class MovicComments  implements java.io.Serializable {


    // Fields    

     private Integer mcOid;
     private UserInfo userInfo;
     private MovicInfo movicInfo;
     private Timestamp commentsDate;
     private String commentsInfo;


    // Constructors

    /** default constructor */
    public MovicComments() {
    }

    
    /** full constructor */
    public MovicComments(UserInfo userInfo, MovicInfo movicInfo, Timestamp commentsDate, String commentsInfo) {
        this.userInfo = userInfo;
        this.movicInfo = movicInfo;
        this.commentsDate = commentsDate;
        this.commentsInfo = commentsInfo;
    }

   
    // Property accessors

    public Integer getMcOid() {
        return this.mcOid;
    }
    
    public void setMcOid(Integer mcOid) {
        this.mcOid = mcOid;
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

    public Timestamp getCommentsDate() {
        return this.commentsDate;
    }
    
    public void setCommentsDate(Timestamp commentsDate) {
        this.commentsDate = commentsDate;
    }

    public String getCommentsInfo() {
        return this.commentsInfo;
    }
    
    public void setCommentsInfo(String commentsInfo) {
        this.commentsInfo = commentsInfo;
    }
   








}