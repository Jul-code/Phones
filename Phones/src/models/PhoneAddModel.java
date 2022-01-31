package models;

import database.DBCheck;
import database.DBConn;
import database.entities.Phone;
import utils.Constants;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PhoneAddModel {

    public String addPhone(Phone phone) {
        // Проверяем на наличие файла БД.
        if (DBCheck.isDBExists()) {
            return addData(phone);
        } else {
            return Constants.DB_ABSENT_MSG;
        }
    }

    private String addData(Phone phone) {

        String sql = "INSERT INTO " + Constants.TABLE_NAME + "(name, phone) VALUES(?, ?)";
        // PreparedStatement - подготовленное выражение, чтобы избежать SQL-инъекций
        try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {
            pstmt.setString(1, phone.getName());
            pstmt.setString(2, phone.getPhone());
            pstmt.executeUpdate();
            return Constants.DATA_INSERT_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
