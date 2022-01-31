package models;

import database.DBCheck;
import database.DBConn;
import database.entities.Phone;
import utils.Constants;
import utils.IdChecker;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PhoneUpdateModel {

    public String updatePhone(Phone phone) {
        // Проверяем на наличие файла БД.
        if (DBCheck.isDBExists()) {
            return updateData(phone);
        } else {
            return Constants.DB_ABSENT_MSG;
        }
    }

    // Обновление по id, при условии его наличия в БД.
    private String updateData(Phone phone) {

        if (IdChecker.isIdExists(phone)) {

            String sql = "UPDATE " + Constants.TABLE_NAME + " SET phone = ? WHERE id = ?";
            // PreparedStatement - подготовленное выражение, чтобы избежать SQL-инъекций
            try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {
                pstmt.setString(1, phone.getPhone());
                pstmt.setInt(2, phone.getId());
                pstmt.executeUpdate();
                return Constants.DATA_UPDATE_MSG;
            } catch (SQLException e) {
                return e.getMessage();
            }
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }
    }
}
