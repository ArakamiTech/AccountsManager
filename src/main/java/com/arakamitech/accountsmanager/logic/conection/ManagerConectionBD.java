package com.arakamitech.accountsmanager.logic.conection;

import com.arakamitech.accountsmanager.logic.dto.ClavesDto;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ManagerConectionBD implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger("ManagerConectionBD");

    private static ManagerConectionBD instance;
    private transient Connection connection;
    private static final String ALERT = "Alerta";
    private static final String UPDATE = "UPDATE `claves` SET `name_application` = ?, `user` = ?, `email` = ?, `password` = ?, `description` = ?, `group` = ?, `key` = ?, `iv` = ? WHERE `id_claves` = ?";
    private static final String INSERT = "INSERT INTO `claves` (`name_application`, `user`, `email`, `password`, `description`, `group`, `key`, `iv`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM `claves` WHERE `id_claves` = ?";
    private static final String SELECT_GROUP = "SELECT DISTINCT `group` FROM `claves` ORDER BY `group` ASC";
    private static final String SELECT_CLAVES = "SELECT * FROM `claves` WHERE `group` = ?";

    private ManagerConectionBD() throws SQLException {
        LOGGER.info("Inicio de la función ManagerConectionBD");
        try {
            this.connection = DriverManager.getConnection("jdbc:h2:C:/AccountsManager/data", "sa", "");
            LOGGER.info("Conexion creada exitosamente");
        } catch (SQLException e) {
            LOGGER.severe("Error en la función ManagerConectionBD");
            JOptionPane.showConfirmDialog(null, "No se pudo conectar a la base de datos", ALERT, 0);
        }
    }

    public static ManagerConectionBD getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new ManagerConectionBD();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        LOGGER.info("Inicio de la funcion closeConnection");
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                LOGGER.info("Conexión cerrada correctamente");
            }
        } catch (SQLException e) {
            LOGGER.severe("Error cerrando la conexión: " + e.getMessage());
            JOptionPane.showConfirmDialog(null, "No se pudo cerrar la conexion a la base de datos", ALERT, 0);
        }
    }

    public void createTable() {
        LOGGER.info("Inicio de la funcion createTable");
        try (var statement = connection.createStatement()) {
            statement.execute(sqlCreate());
            LOGGER.info("Tabla creada correctamente");
        } catch (SQLException e) {
            LOGGER.severe("Error creando la tabla: " + e.getMessage());
            JOptionPane.showConfirmDialog(null, "Error creando la tabla", ALERT, 0);
        }
    }

    public void createRegister(ClavesDto clavesDto) {
        LOGGER.info("Inicio de la función createRegister");
        try (var statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, clavesDto.getNameApplication());
            statement.setString(2, clavesDto.getUser());
            statement.setString(3, clavesDto.getEmail());
            statement.setString(4, clavesDto.getPassword());
            statement.setString(5, clavesDto.getDescription());
            statement.setString(6, clavesDto.getGroup());
            statement.setString(7, clavesDto.getKey());
            statement.setString(8, clavesDto.getIv());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error en createRegister: " + e.getMessage());
            JOptionPane.showConfirmDialog(null, "Error creando el registro", ALERT, 0);
        }
        LOGGER.info("Fin de la función createRegister");
    }

    public void editRegister(ClavesDto clavesDto) {
        LOGGER.info("Inicio de la función editRegister");
        try (var statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, clavesDto.getNameApplication());
            statement.setString(2, clavesDto.getUser());
            statement.setString(3, clavesDto.getEmail());
            statement.setString(4, clavesDto.getPassword());
            statement.setString(5, clavesDto.getDescription());
            statement.setString(6, clavesDto.getGroup());
            statement.setString(7, clavesDto.getKey());
            statement.setString(8, clavesDto.getIv());
            statement.setInt(9, clavesDto.getIdClaves());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error en editRegister: " + e.getMessage());
            JOptionPane.showConfirmDialog(null, "Error editando el registro", ALERT, 0);
        }
        LOGGER.info("Fin de la función editRegister");
    }

    public void deleteRegister(int idClaves) {
        LOGGER.info("Inicio de la función deleteRegister");
        try (var statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, idClaves);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Error en deleteRegister: " + e.getMessage());
            JOptionPane.showConfirmDialog(null, "Error eliminando el registro", ALERT, 0);
        }
        LOGGER.info("Fin de la función deleteRegister");
    }

    public List<String> getRegisterByGroup() {
        LOGGER.info("Inicio de la función getRegisterToMenu");
        var list = new ArrayList<String>();
        try (var statement = connection.prepareStatement(SELECT_GROUP)) {
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString("group"));
            }
        } catch (SQLException e) {
            LOGGER.severe("Error en getRegisterToMenu: " + e.getMessage());
            JOptionPane.showConfirmDialog(null, "Error obteniendo datos por grupo", ALERT, 0);
        }
        LOGGER.info("Fin de la función getRegisterToMenu");
        return list;
    }

    public List<ClavesDto> getClaves(String group) {
        LOGGER.info("Inicio de la función getClaves");
        var clavesDtoList = new ArrayList<ClavesDto>();
        try (var statement = connection.prepareStatement(SELECT_CLAVES)) {
            statement.setString(1, group);
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                var clavesDto = ClavesDto.builder()
                        .nameApplication(resultSet.getString("name_application"))
                        .user(resultSet.getString("user"))
                        .email(resultSet.getString("email"))
                        .password(resultSet.getString("password"))
                        .description(resultSet.getString("description"))
                        .group(resultSet.getString("group"))
                        .key(resultSet.getString("key"))
                        .iv(resultSet.getString("iv"))
                        .build();
                clavesDtoList.add(clavesDto);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error en getClaves: " + e.getMessage());
            JOptionPane.showConfirmDialog(null, "Error obteniendo los registros", ALERT, 0);
        }
        LOGGER.info("Fin de la función getClaves");
        return clavesDtoList;
    }

    private String sqlCreate() {
        return "CREATE TABLE IF NOT EXISTS `claves` (" +
               "  `id_claves` INT NOT NULL AUTO_INCREMENT," +
               "  `name_application` VARCHAR(45) NOT NULL," +
               "  `user` VARCHAR(45) NULL," +
               "  `email` VARCHAR(45) NULL," +
               "  `password` VARCHAR(100) NOT NULL," +
               "  `description` VARCHAR(45) NULL," +
               "  `group` VARCHAR(45) NOT NULL," +
               "  `key` VARCHAR(100) NOT NULL," +
               "  `iv` VARCHAR(100) NOT NULL," +
               "  PRIMARY KEY (`id_claves`)," +
               "  UNIQUE (`id_claves`))";
    }
}
