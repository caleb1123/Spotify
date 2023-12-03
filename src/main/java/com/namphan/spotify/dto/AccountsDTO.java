package com.namphan.spotify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountsDTO {
    private int  accountId;
    private String userName;
    private String password;
    private int roleId;
    private String email;
    private LocalDate dob;
    private String name;
    private String linkSocial;
    private String linkSocial2;
    private String phone;
    private boolean status;


}
