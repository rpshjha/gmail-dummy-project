package com.rpshjha.gmailproject.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 08/09/21
 * Time: 10:50 AM
 * To change this template use File | Settings | File and Code Templates.
 */
@Data
@Entity
@Table(name = "user_info")
public class User {

    @Id
    private Integer userId;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String dob;
    private String gender;
    private String recoveryemail;
    private String recoveryphone;

}
