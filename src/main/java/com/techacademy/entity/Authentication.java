package com.techacademy.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="authentication")
public class Authentication {

    @Id
    private String loginUser;
    private String password;
    private Date validDate;

    @OneToOne
    @JoinColumn(name="user_id",referencedColumnName="id")
    private User user;
}

