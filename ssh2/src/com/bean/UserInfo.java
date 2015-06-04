package com.bean;

import java.util.HashSet;
import java.util.Set;


/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo  implements java.io.Serializable {


    // Fields    

     private Integer userOid;
     private UserType userType;
     private String userName;
     private String userPassword;
     private String userDisplayName;
     private String userSex;
     private String userLogo;
     private String userEmail;
     private Set userScoreMovics = new HashSet(0);
     private Set userIntegrals = new HashSet(0);
     private Set movicCommentses = new HashSet(0);
     private Set userSignIns = new HashSet(0);


    // Constructors

    /** default constructor */
    public UserInfo() {
    }

	/** minimal constructor */
    public UserInfo(String userName, String userPassword, String userDisplayName, String userEmail) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userDisplayName = userDisplayName;
        this.userEmail = userEmail;
    }
    
    /** full constructor */
    public UserInfo(UserType userType, String userName, String userPassword, String userDisplayName, String userSex, String userLogo, String userEmail, Set userScoreMovics, Set userIntegrals, Set movicCommentses, Set userSignIns) {
        this.userType = userType;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userDisplayName = userDisplayName;
        this.userSex = userSex;
        this.userLogo = userLogo;
        this.userEmail = userEmail;
        this.userScoreMovics = userScoreMovics;
        this.userIntegrals = userIntegrals;
        this.movicCommentses = movicCommentses;
        this.userSignIns = userSignIns;
    }

   
    // Property accessors

    public Integer getUserOid() {
        return this.userOid;
    }
    
    public void setUserOid(Integer userOid) {
        this.userOid = userOid;
    }

    public UserType getUserType() {
        return this.userType;
    }
    
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return this.userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserDisplayName() {
        return this.userDisplayName;
    }
    
    public void setUserDisplayName(String userDisplayName) {
        this.userDisplayName = userDisplayName;
    }

    public String getUserSex() {
        return this.userSex;
    }
    
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserLogo() {
        return this.userLogo;
    }
    
    public void setUserLogo(String userLogo) {
        this.userLogo = userLogo;
    }

    public String getUserEmail() {
        return this.userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Set getUserScoreMovics() {
        return this.userScoreMovics;
    }
    
    public void setUserScoreMovics(Set userScoreMovics) {
        this.userScoreMovics = userScoreMovics;
    }

    public Set getUserIntegrals() {
        return this.userIntegrals;
    }
    
    public void setUserIntegrals(Set userIntegrals) {
        this.userIntegrals = userIntegrals;
    }

    public Set getMovicCommentses() {
        return this.movicCommentses;
    }
    
    public void setMovicCommentses(Set movicCommentses) {
        this.movicCommentses = movicCommentses;
    }

    public Set getUserSignIns() {
        return this.userSignIns;
    }
    
    public void setUserSignIns(Set userSignIns) {
        this.userSignIns = userSignIns;
    }
   








}