package models;

import java.util.HashMap;
import java.util.Map;

public class ContactCreateModel {

    // Имитация записи в БД.
    public String createContacts() {

        // TASK Средствами HashMap<> создайте перечень контактов,
        // где имя - ключ, номер телефона - значение.

        // TASK должно возвращаться уведомление о создании
        // со значением типа HashMap<>.

        HashMap<String, String> hm = new HashMap<>();

        hm.put("Анатолий", "0957554466");
        hm.put("Федор", "0508412234");
        hm.put("Родион", "0508506465");

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> m : hm.entrySet()) {
            result.append(m.getKey())
                    .append(" ")
                    .append(m.getValue())
                    .append("; ")
                    .append("\n");

        }
        return result.toString();
    }
}