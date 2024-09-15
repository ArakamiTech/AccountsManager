/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arakamitech.accountsmanager.logic.dto;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author cristhian
 */
public class ConnectionDto {

    private Connection connection;
    private Statement statement;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    
    public ConnectionDto() {
    }

    public ConnectionDto(Connection connection, Statement statement) {
        this.connection = connection;
        this.statement = statement;
    }

}
