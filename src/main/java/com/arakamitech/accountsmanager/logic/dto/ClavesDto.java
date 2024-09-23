package com.arakamitech.accountsmanager.logic.dto;

/**
 *
 * @author cristhian
 */
public class ClavesDto {

    private int idClaves;
    private String nameApplication;
    private String user;
    private String email;
    private String password;
    private String description;
    private String group;
    
    public ClavesDto() {
    }

    public ClavesDto(int idClaves, String nameApplication, String user, String email, String password, String description, String group) {
        this.idClaves = idClaves;
        this.nameApplication = nameApplication;
        this.user = user;
        this.email = email;
        this.password = password;
        this.description = description;
        this.group = group;
    }

    public int getIdClaves() {
        return idClaves;
    }

    public void setIdClaves(int idClaves) {
        this.idClaves = idClaves;
    }

    public String getNameApplication() {
        return nameApplication;
    }

    public void setNameApplication(String nameApplication) {
        this.nameApplication = nameApplication;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
