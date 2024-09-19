package com.arakamitech.accountsmanager.logic.conection;

import com.arakamitech.accountsmanager.logic.dto.ClavesDto;
import com.arakamitech.accountsmanager.logic.dto.ConnectionDto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author cristhian
 */
public class ManagerConectionBD {

    private static final Logger LOGGER = Logger.getLogger("ManagerConectionBD");

    public ConnectionDto createConectionBD() throws SQLException {
        LOGGER.info("Inicio de la funcion createConectionBD");
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:C:/AccountsManager/data", "sa", "");
            statement = connection.createStatement();
        } catch (SQLException e) {
            LOGGER.info("Error de la funcion createConectionBD" + e);
            throw e;
        }
        LOGGER.info("Fin de la funcion createConectionBD");
        return new ConnectionDto(connection, statement);
    }

    public ConnectionDto closeConectionBD(Connection connection, Statement statement) {
        LOGGER.info("Inicio de la funcion closeConectionBD");
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            LOGGER.info("Error de la funcion closeConectionBD" + e);
            e.printStackTrace();
        }
        LOGGER.info("Fin de la funcion closeConectionBD");
        return new ConnectionDto(connection, statement);
    }

    public void createTable(Connection connection, Statement statement) {
        try {
            LOGGER.info("Inicio de la funcion createTable");
            statement.execute(sqlCreate());
            LOGGER.info("Fin de la funcion createTable");
        } catch (SQLException e) {
            LOGGER.info("Error de la funcion createTable" + e);
            e.printStackTrace();
        }
    }

    public void createRegister(Statement statement, String nameApplication, String user, String email, String password, String description, String group) {
        try {
            LOGGER.info("Inicio de la funcion createRegister");
            statement.execute(sqlInsert(nameApplication, user, email, password, description, group));
            LOGGER.info("Fin de la funcion createRegister");
        } catch (SQLException e) {
            LOGGER.info("Error de la funcion createRegister" + e);
            e.printStackTrace();
        }
    }

    public void editRegister(Statement statement, ClavesDto clavesDto) {
        try {
            LOGGER.info("Inicio de la funcion editRegister");
            statement.execute(sqlUpdate(clavesDto));
            LOGGER.info("Fin de la funcion editRegister");
        } catch (SQLException e) {
            LOGGER.info("Error de la funcion editRegister" + e);
            e.printStackTrace();
        }
    }

    public void deleteRegister(Statement statement, int idClaves) {
        try {
            LOGGER.info("Inicio de la funcion deleteRegister");
            statement.execute(sqlDelete(idClaves));
            LOGGER.info("Fin de la funcion deleteRegister");
        } catch (SQLException e) {
            LOGGER.info("Error de la funcion deleteRegister" + e);
            e.printStackTrace();
        }
    }

    public List<String> getRegisterToMenu(Statement statement) {
        LOGGER.info("Inicio de la funcion getRegisterToMenu");
        List<String> list = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(sqlSelectGroup());

            while (resultSet.next()) {
                list.add(resultSet.getString("group"));
            }
        } catch (SQLException e) {
            LOGGER.info("Error de la funcion getRegisterToMenu" + e);
            e.printStackTrace();
        }
        LOGGER.info("Fin de la funcion getRegisterToMenu");
        return list;
    }

    public List<ClavesDto> getClaves(Connection connectionDto, String group) {
        LOGGER.info("Inicio de la función getClaves");
        List<ClavesDto> clavesDtoList = new ArrayList<>();

        String query = sqlSelectClaves();
        try (PreparedStatement statement = connectionDto.prepareStatement(query)) {
            statement.setString(1, group);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClavesDto clavesDto = new ClavesDto();  // Crear una nueva instancia en cada iteración
                clavesDto.setNameApplication(resultSet.getString("name_application"));
                clavesDto.setUser(resultSet.getString("user"));
                clavesDto.setEmail(resultSet.getString("email"));
                clavesDto.setPassword(resultSet.getString("password"));
                clavesDto.setDescription(resultSet.getString("description"));
                clavesDto.setGroup(resultSet.getString("group"));
                clavesDtoList.add(clavesDto);
            }
        } catch (SQLException e) {
            LOGGER.info("Error en la función getClaves: " + e.getMessage());
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

    private String sqlInsert(String nameApplication, String user, String email, String password, String description, String group) {
        return "INSERT INTO `claves` ("
                + "`name_application`, "
                + "`user`, "
                + "`email`, "
                + "`password`, "
                + "`description`, "
                + "`group`) "
                + "VALUES "
                + "('" + nameApplication + "', '" + user + "', '" + email + "', '" + password + "', '" + description + "', '" + group + "');";
    }

    private String sqlUpdate(ClavesDto clavesDto) {
        return "UPDATE `claves` "
                + "SET `name_application` = '" + clavesDto.getNameApplication() + "', "
                + "`user` = '" + clavesDto.getUser() + "', "
                + "`email` = '" + clavesDto.getEmail() + "', "
                + "`password` = '" + clavesDto.getPassword() + "', "
                + "`description` = '" + clavesDto.getPassword() + "', "
                + "`group` = '" + clavesDto.getGroup() + "' "
                + "WHERE `id_claves` = '" + clavesDto.getIdClaves() + "'";
    }

    private String sqlDelete(int idClaves) {
        return "DELETE FROM `claves` WHERE `id_claves` = '" + idClaves + "'";
    }

    private String sqlSelectGroup() {
        return "SELECT DISTINCT `group` FROM `claves` ORDER BY `group` ASC";
    }

    private String sqlSelectClaves() {
        return "SELECT * FROM `claves` WHERE `group` = ?";
    }

}
