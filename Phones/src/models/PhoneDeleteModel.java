package models;

import database.DBCheck;
import database.DBConn;
import database.entities.Phone;
import utils.Constants;
import utils.IdChecker;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PhoneDeleteModel {

    public String deletePhone(Phone phone) {
        // Проверяем на наличие файла БД.
        if (DBCheck.isDBExists()) {
            return deleteData(phone);
        } else {
            return Constants.DB_ABSENT_MSG;
        }
    }

    // Удаление по id, при условии его наличия в БД.
    private String deleteData(Phone phone) {

        if (IdChecker.isIdExists(phone)) {

            String sql = "DELETE FROM " + Constants.TABLE_NAME + " WHERE id = ?";

            try (PreparedStatement stmt = DBConn.connect().prepareStatement(sql)) {
                // установка соответствующих параметров
                stmt.setInt(1, phone.getId());
                // выполнение запроса в БД
                stmt.executeUpdate();
                return Constants.DATA_DELETE_MSG;
            } catch (SQLException e) {
                return e.getMessage();
            }
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }
    }
}
