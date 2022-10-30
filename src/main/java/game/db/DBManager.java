package game.db;

import game.logic.Player;
import java.sql.*;
import java.util.UUID;

public final class DBManager {

    private static final String USER_NAME = "pdc"; //your DB username
    private static final String PASSWORD = "pdc"; //your DB password
    private final String databaseName;

    public DBManager(String databaseName) throws SQLException {
        this.databaseName = databaseName;
        maybeCreatePlayerTable();
    }

    public DBManager() throws SQLException {
        this("memory:" + UUID.randomUUID());
    }

    private void maybeCreatePlayerTable() throws SQLException {
        if (!tableExists("PLAYER")) {
            try (
                    Connection conn = getConnection();
                    Statement st = conn.createStatement()
            ) {
                String createTable = "CREATE TABLE PLAYER (NAME VARCHAR(50), HP INT, MAXHP INT, XP INT, ROOMNO INT)";
                st.executeUpdate(createTable);
            }
        }
    }

    //Establish connection
    private Connection getConnection() throws SQLException {
        //Establish a connection to Database
        return DriverManager.getConnection("jdbc:derby:" + databaseName + ";create=true", USER_NAME, PASSWORD);
    }

    public boolean tableExists(String tableName) throws SQLException {
        try (Connection conn = getConnection()) {
            DatabaseMetaData meta = conn.getMetaData();
            try (ResultSet resultSet = meta.getTables(null, null, tableName, new String[]{"TABLE"})) {
                return resultSet.next();
            }
        }
    }

    public Player loadPlayer(String characterName) {
        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(
                        "SELECT NAME, HP, MAXHP, XP, ROOMNO FROM PLAYER WHERE NAME = ?"
                );
        ) {
            ps.setString(1, characterName);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return new Player(
                            resultSet.getString(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getInt(4),
                            resultSet.getInt(5)
                    );
                }
                else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(-1);
            throw new IllegalStateException("System.exit failed.");
        }
    }

    public void savePlayer(Player player) {
        try (
                Connection conn = getConnection();
                PreparedStatement psDelete = conn.prepareStatement(
                        "DELETE FROM PLAYER WHERE NAME = ?"
                );
                PreparedStatement psSave = conn.prepareStatement(
                        "INSERT INTO PLAYER (NAME, HP, MAXHP, XP, ROOMNO) VALUES (?, ?, ?, ?, ?)"
                )
        ) {
            conn.setAutoCommit(false);
            psDelete.setString(1, player.name);
            psDelete.executeUpdate();

            psSave.setString(1, player.name);
            psSave.setInt(2, player.hp);
            psSave.setInt(3, player.maxHP);
            psSave.setInt(4, player.xp);
            psSave.setInt(5, player.roomCount);
            psSave.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(-1);
            throw new IllegalStateException("System.exit failed.");
        }
    }
}


