package com.arakamitech.accountsmanager.logic.dto;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author cristhian
 */
public class ConnectionDto implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private transient Connection connection;
    private transient Statement statement;

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
