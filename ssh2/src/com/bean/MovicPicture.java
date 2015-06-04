package com.bean;



/**
 * MovicPicture entity. @author MyEclipse Persistence Tools
 */

public class MovicPicture  implements java.io.Serializable {


    // Fields    

     private Integer mpOid;
     private MovicInfo movicInfo;
     private String picturePath;


    // Constructors

    /** default constructor */
    public MovicPicture() {
    }

    
    /** full constructor */
    public MovicPicture(MovicInfo movicInfo, String picturePath) {
        this.movicInfo = movicInfo;
        this.picturePath = picturePath;
    }

   
    // Property accessors

    public Integer getMpOid() {
        return this.mpOid;
    }
    
    public void setMpOid(Integer mpOid) {
        this.mpOid = mpOid;
    }

    public MovicInfo getMovicInfo() {
        return this.movicInfo;
    }
    
    public void setMovicInfo(MovicInfo movicInfo) {
        this.movicInfo = movicInfo;
    }

    public String getPicturePath() {
        return this.picturePath;
    }
    
    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
   








}