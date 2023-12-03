package com.namphan.spotify.converter;

import com.namphan.spotify.dto.AccountsDTO;
import com.namphan.spotify.entity.Account;
import com.namphan.spotify.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountConverter {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleConverter roleConverter;
    public Account toEntity(AccountsDTO accountsDTO) {
        if (accountsDTO == null) {
            return null;
        }

        Account entity = new Account();
        entity.setAccountId(accountsDTO.getAccountId());
        entity.setUserName(accountsDTO.getUserName());
        entity.setPassword(accountsDTO.getPassword());
        entity.setRole(roleRepository.getReferenceById(accountsDTO.getAccountId()));
        entity.setEmail(accountsDTO.getEmail());
        entity.setDob(accountsDTO.getDob());
        entity.setName(accountsDTO.getName());
        entity.setLinkSocial(accountsDTO.getLinkSocial());
        entity.setLinkSocial2(accountsDTO.getLinkSocial2());
        entity.setPhone(accountsDTO.getPhone());
        entity.setStatus(accountsDTO.isStatus());

        return entity;
    }

    public AccountsDTO toDTO(Account account) {
        if (account == null) {
            return null;
        }

        AccountsDTO dto = new AccountsDTO();
        dto.setAccountId(account.getAccountId());
        dto.setUserName(account.getUserName());
        dto.setPassword(account.getPassword());
        dto.setRoleId(roleConverter.toDTO(account.getRole()).getRoleId());
        dto.setEmail(account.getEmail());
        dto.setDob(account.getDob());
        dto.setName(account.getName());
        dto.setLinkSocial(account.getLinkSocial());
        dto.setLinkSocial2(account.getLinkSocial2());
        dto.setPhone(account.getPhone());
        dto.setStatus(account.isStatus());

        return dto;
    }
}
