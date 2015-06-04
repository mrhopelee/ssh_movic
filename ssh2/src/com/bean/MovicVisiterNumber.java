package com.bean;



/**
 * MovicVisiterNumber entity. @author MyEclipse Persistence Tools
 */

public class MovicVisiterNumber  implements java.io.Serializable {


    // Fields    

     private Integer mvnOid;
     private MovicInfo movicInfo;
     private Integer visiterNumber;


    // Constructors

    /** default constructor */
    public MovicVisiterNumber() {
    }

    
    /** full constructor */
    public MovicVisiterNumber(MovicInfo movicInfo, Integer visiterNumber) {
        this.movicInfo = movicInfo;
        this.visiterNumber = visiterNumber;
    }

   
    // Property accessors

    public Integer getMvnOid() {
        return this.mvnOid;
    }
    
    public void setMvnOid(Integer mvnOid) {
        this.mvnOid = mvnOid;
    }

    public MovicInfo getMovicInfo() {
        return this.movicInfo;
    }
    
    public void setMovicInfo(MovicInfo movicInfo) {
        this.movicInfo = movicInfo;
    }

    public Integer getVisiterNumber() {
        return this.visiterNumber;
    }
    
    public void setVisiterNumber(Integer visiterNumber) {
        this.visiterNumber = visiterNumber;
    }
   








}