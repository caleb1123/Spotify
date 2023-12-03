package com.namphan.spotify.converter;

import com.namphan.spotify.dto.RoleDTO;
import com.namphan.spotify.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {
    public Role toEntity(RoleDTO roleDTO) {
        if (roleDTO == null) {
            return null;
        }

        Role entity = new Role();
        entity.setRoleId(roleDTO.getRoleId());
        entity.setRoleName(roleDTO.getRoleName());

        return entity;
    }

    public RoleDTO toDTO(Role role) {
        if (role == null) {
            return null;
        }

        RoleDTO dto = new RoleDTO();
        dto.setRoleId(role.getRoleId());
        dto.setRoleName(role.getRoleName());

        return dto;
    }
}