package com.arakamitech.accountsmanager.logic.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClavesDto {
    int idClaves;
    String nameApplication;
    String user;
    String email;
    String password;
    String description;
    String group;
    String key;
    String iv;
}