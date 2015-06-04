package com.bean;

import java.util.HashSet;
import java.util.Set;


/**
 * MovicType entity. @author MyEclipse Persistence Tools
 */

public class MovicType  implements java.io.Serializable {


    // Fields    

     private Integer mtOid;
     private String tyoe;
     private Set movicInfos = new HashSet(0);


    // Constructors

    /** default constructor */
    public MovicType() {
    }

	/** minimal constructor */
    public MovicType(String tyoe) {
        this.tyoe = tyoe;
    }
    
    /** full constructor */
    public MovicType(String tyoe, Set movicInfos) {
        this.tyoe = tyoe;
        this.movicInfos = movicInfos;
    }

   
    // Property accessors

    public Integer getMtOid() {
        return this.mtOid;
    }
    
    public void setMtOid(Integer mtOid) {
        this.mtOid = mtOid;
    }

    public String getTyoe() {
        return this.tyoe;
    }
    
    public void setTyoe(String tyoe) {
        this.tyoe = tyoe;
    }

    public Set getMovicInfos() {
        return this.movicInfos;
    }
    
    public void setMovicInfos(Set movicInfos) {
        this.movicInfos = movicInfos;
    }
   








}