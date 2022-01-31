package models;

import database.DBCheck;
import database.DBConn;
import database.entities.Phone;
import utils.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneReadModel {

    List<Phone> list;

    public List<Phone> readPhones() {
        // Проверяем на наличие файла БД.
        if (DBCheck.isDBExists()) {
            list = readData();
        } else {
            list = null;
        }
        return list;
    }

    private List<Phone> readData() {

        try (Statement stmt = DBConn.connect().createStatement()) {

            list = new ArrayList<>();

            String sql = "SELECT id, name, phone FROM " + Constants.TABLE_NAME;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(new Phone(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("phone")
                        )
                );
            }
            // Возвращаем коллекцию данных
            return list;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // Если ошибка - возвращаем пустую коллекцию
            return Collections.emptyList();
        }
    }
}
