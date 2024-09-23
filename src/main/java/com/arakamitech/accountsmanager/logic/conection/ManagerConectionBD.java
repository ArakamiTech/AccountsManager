package com.arakamitech.accountsmanager.logic.conection;

import com.arakamitech.accountsmanager.logic.dto.ClavesDto;
import com.arakamitech.accountsmanager.logic.dto.ConnectionDto;

import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ManagerConectionBD implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger("ManagerConectionBD");

	private static final String UPDATE = "UPDATE `claves` SET `name_application` = ?, `user` = ?, `email` = ?, `password` = ?, `description` = ?, `group` = ? WHERE `id_claves` = ?";
	private static final String INSERT = "INSERT INTO `claves` (`name_application`, `user`, `email`, `password`, `description`, `group`) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String DELETE = "DELETE FROM `claves` WHERE `id_claves` = ?";
	private static final String SELECT_GROUP = "SELECT DISTINCT `group` FROM `claves` ORDER BY `group` ASC";
	private static final String SELECT_CLAVES = "SELECT * FROM `claves` WHERE `group` = ?";
    
    public ConnectionDto createConectionBD() throws SQLException {
        LOGGER.info("Inicio de la funcion createConectionBD");
        try {
            var connection = DriverManager.getConnection("jdbc:h2:C:/AccountsManager/data", "sa", "");
            var statement = connection.createStatement();
            LOGGER.info("Fin de la funcion createConectionBD");
            return new ConnectionDto(connection, statement);
        } catch (SQLException e) {
            LOGGER.severe("Error en la función createConectionBD");
            throw e;
        }
    }

    public void closeConectionBD(ConnectionDto connectionDto) {
        LOGGER.info("Inicio de la función closeConectionBD");
        try {
            if (connectionDto.getStatement() != null) {
                connectionDto.getStatement().close();
            }
            if (connectionDto.getConnection() != null) {
                connectionDto.getConnection().close();
            }
        } catch (SQLException e) {
            LOGGER.severe("Error en la función closeConectionBD: " + e.getMessage());
        }
        LOGGER.info("Fin de la función closeConectionBD");
    }

    public void createTable(ConnectionDto connectionDto) {
        try {
            LOGGER.info("Inicio de la función createTable");
            connectionDto.getStatement().execute(sqlCreate());
            LOGGER.info("Fin de la función createTable");
        } catch (SQLException e) {
            LOGGER.severe("Error en la función createTable: " + e.getMessage());
        }
    }

    public void createRegister(ConnectionDto connectionDto, String nameApplication, String user, String email, String password, String description, String group) {
        LOGGER.info("Inicio de la funcion createRegister");
        try (var statement = connectionDto.getConnection().prepareStatement(INSERT)) {
            statement.setString(1, nameApplication);
            statement.setString(2, user);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setString(5, description);
            statement.setString(6, group);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error en createRegister: " + e.getMessage());
        }
        LOGGER.info("Fin de la funcion createRegister");
    }

    public void editRegister(ConnectionDto connectionDto, ClavesDto clavesDto) {
        LOGGER.info("Inicio de la funcion editRegister");
        try (var statement = connectionDto.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, clavesDto.getNameApplication());
            statement.setString(2, clavesDto.getUser());
            statement.setString(3, clavesDto.getEmail());
            statement.setString(4, clavesDto.getPassword());
            statement.setString(5, clavesDto.getDescription());
            statement.setString(6, clavesDto.getGroup());
            statement.setInt(7, clavesDto.getIdClaves());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error en editRegister: " + e.getMessage());
        }
        LOGGER.info("Fin de la funcion editRegister");
    }

    public void deleteRegister(ConnectionDto connectionDto, int idClaves) {
        LOGGER.info("Inicio de la funcion deleteRegister");
        try (var statement = connectionDto.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, idClaves);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error en deleteRegister: " + e.getMessage());
        }
        LOGGER.info("Fin de la funcion deleteRegister");
    }

    public List<String> getRegisterToMenu(ConnectionDto connectionDto) {
        LOGGER.info("Inicio de la funcion getRegisterToMenu");
        var list = new ArrayList<String>();
        try (var statement = connectionDto.getConnection().prepareStatement(SELECT_GROUP)) {
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString("group"));
            }
        } catch (SQLException e) {
            LOGGER.severe("Error en getRegisterToMenu: " + e.getMessage());
        }
        LOGGER.info("Fin de la funcion getRegisterToMenu");
        return list;
    }

    public List<ClavesDto> getClaves(ConnectionDto connectionDto, String group) {
        LOGGER.info("Inicio de la función getClaves");
        var clavesDtoList = new ArrayList<ClavesDto>();
        try (var statement = connectionDto.getConnection().prepareStatement(SELECT_CLAVES)) {
            statement.setString(1, group);
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                var clavesDto = new ClavesDto();
                clavesDto.setNameApplication(resultSet.getString("name_application"));
                clavesDto.setUser(resultSet.getString("user"));
                clavesDto.setEmail(resultSet.getString("email"));
                clavesDto.setPassword(resultSet.getString("password"));
                clavesDto.setDescription(resultSet.getString("description"));
                clavesDto.setGroup(resultSet.getString("group"));
                clavesDtoList.add(clavesDto);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error en la función getClaves: " + e.getMessage());
        }
        LOGGER.info("Fin de la función getClaves");
        return clavesDtoList;
    }

    private String sqlCreate() {
        return "CREATE TABLE IF NOT EXISTS `claves` ("
                + "  `id_claves` INT NOT NULL AUTO_INCREMENT,"
                + "  `name_application` VARCHAR(45) NOT NULL,"
                + "  `user` VARCHAR(45) NULL,"
                + "  `email` VARCHAR(45) NULL,"
                + "  `password` VARCHAR(45) NOT NULL,"
                + "  `description` VARCHAR(45) NULL,"
                + "  `group` VARCHAR(45) NOT NULL,"
                + "  PRIMARY KEY (`id_claves`),"
                + "  UNIQUE (`id_claves`))";
    }

}
