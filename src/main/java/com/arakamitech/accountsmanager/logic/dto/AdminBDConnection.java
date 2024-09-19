package com.arakamitech.accountsmanager.logic.dto;

import com.arakamitech.accountsmanager.logic.conection.ManagerConectionBD;

/**
 *
 * @author cristhian
 */
public class AdminBDConnection {

    private ConnectionDto connectionDto;

    public ConnectionDto getConnectionDto() {
        return connectionDto;
    }

    public void setConnectionDto(ConnectionDto connectionDto) {
        this.connectionDto = connectionDto;
    }

}
