package com.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * MovicInfo entity. @author MyEclipse Persistence Tools
 */

public class MovicInfo  implements java.io.Serializable {


    // Fields    

     private Integer movicOid;
     private MovicType movicType;
     private MovicArea movicArea;
     private String movicName;
     private String movicActor;
     private String movicDirector;
     private Double movicImdbScore;
     private Date movicPlayDate;
     private String movicIntroduction;
     private String movicPost;
     private Set userScoreMovics = new HashSet(0);
     private Set movicPictures = new HashSet(0);
     private Set movicVisiterNumbers = new HashSet(0);
     private Set movicCommentses = new HashSet(0);
     private Set movicDownloads = new HashSet(0);


    // Constructors

    /** default constructor */
    public MovicInfo() {
    }

    
    /** full constructor */
    public MovicInfo(MovicType movicType, MovicArea movicArea, String movicName, String movicActor, String movicDirector, Double movicImdbScore, Date movicPlayDate, String movicIntroduction, String movicPost, Set userScoreMovics, Set movicPictures, Set movicVisiterNumbers, Set movicCommentses, Set movicDownloads) {
        this.movicType = movicType;
        this.movicArea = movicArea;
        this.movicName = movicName;
        this.movicActor = movicActor;
        this.movicDirector = movicDirector;
        this.movicImdbScore = movicImdbScore;
        this.movicPlayDate = movicPlayDate;
        this.movicIntroduction = movicIntroduction;
        this.movicPost = movicPost;
        this.userScoreMovics = userScoreMovics;
        this.movicPictures = movicPictures;
        this.movicVisiterNumbers = movicVisiterNumbers;
        this.movicCommentses = movicCommentses;
        this.movicDownloads = movicDownloads;
    }

   
    // Property accessors

    public Integer getMovicOid() {
        return this.movicOid;
    }
    
    public void setMovicOid(Integer movicOid) {
        this.movicOid = movicOid;
    }

    public MovicType getMovicType() {
        return this.movicType;
    }
    
    public void setMovicType(MovicType movicType) {
        this.movicType = movicType;
    }

    public MovicArea getMovicArea() {
        return this.movicArea;
    }
    
    public void setMovicArea(MovicArea movicArea) {
        this.movicArea = movicArea;
    }

    public String getMovicName() {
        return this.movicName;
    }
    
    public void setMovicName(String movicName) {
        this.movicName = movicName;
    }

    public String getMovicActor() {
        return this.movicActor;
    }
    
    public void setMovicActor(String movicActor) {
        this.movicActor = movicActor;
    }

    public String getMovicDirector() {
        return this.movicDirector;
    }
    
    public void setMovicDirector(String movicDirector) {
        this.movicDirector = movicDirector;
    }

    public Double getMovicImdbScore() {
        return this.movicImdbScore;
    }
    
    public void setMovicImdbScore(Double movicImdbScore) {
        this.movicImdbScore = movicImdbScore;
    }

    public Date getMovicPlayDate() {
        return this.movicPlayDate;
    }
    
    public void setMovicPlayDate(Date movicPlayDate) {
        this.movicPlayDate = movicPlayDate;
    }

    public String getMovicIntroduction() {
        return this.movicIntroduction;
    }
    
    public void setMovicIntroduction(String movicIntroduction) {
        this.movicIntroduction = movicIntroduction;
    }

    public String getMovicPost() {
        return this.movicPost;
    }
    
    public void setMovicPost(String movicPost) {
        this.movicPost = movicPost;
    }

    public Set getUserScoreMovics() {
        return this.userScoreMovics;
    }
    
    public void setUserScoreMovics(Set userScoreMovics) {
        this.userScoreMovics = userScoreMovics;
    }

    public Set getMovicPictures() {
        return this.movicPictures;
    }
    
    public void setMovicPictures(Set movicPictures) {
        this.movicPictures = movicPictures;
    }

    public Set getMovicVisiterNumbers() {
        return this.movicVisiterNumbers;
    }
    
    public void setMovicVisiterNumbers(Set movicVisiterNumbers) {
        this.movicVisiterNumbers = movicVisiterNumbers;
    }

    public Set getMovicCommentses() {
        return this.movicCommentses;
    }
    
    public void setMovicCommentses(Set movicCommentses) {
        this.movicCommentses = movicCommentses;
    }

    public Set getMovicDownloads() {
        return this.movicDownloads;
    }
    
    public void setMovicDownloads(Set movicDownloads) {
        this.movicDownloads = movicDownloads;
    }
   








}