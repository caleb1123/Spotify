package com.namphan.spotify.controller;

import com.namphan.spotify.model.dto.AccountsDTO;
import com.namphan.spotify.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;
    @GetMapping("/{userName}")
    public ResponseEntity<AccountsDTO> getAccountByUserName(@PathVariable String userName) {
        AccountsDTO accountsDTO = accountService.getAccountByUserName(userName);
        if (accountsDTO != null) {
            return new ResponseEntity<>(accountsDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
