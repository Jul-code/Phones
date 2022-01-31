package utils;

import database.DBConn;
import database.entities.Phone;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Класс-проверка наличия id в БД
public class IdChecker {

    public static boolean isIdExists(Phone phone) {

        try {
            String query = "SELECT COUNT(id) FROM " + Constants.TABLE_NAME + " WHERE id = ?";
            PreparedStatement pst = DBConn.connect().prepareStatement(query);
            pst.setInt(1, phone.getId());

            try (ResultSet rs = pst.executeQuery()) {
                // Ожидаем только один результат
                if (rs.next()) {
                    return rs.getBoolean(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
