package models;

import java.util.*;

public class ContactReadModel {

    public HashMap<String, String> readContacts() {

        // Имитация чтения из БД.
        HashMap<String, String> hm = new HashMap<>();

        hm.put("Анатолий", "0957554466");
        hm.put("Федор", "0508412234");
        hm.put("Родион", "0508506465");

        return hm;
    }
}

//        // TASK Средствами HashMap<> создайте перечень контактов,
//        // где имя - ключ, номер телефона - значение.
//        // TASK должно возвращаться значение типа HashMap<>.