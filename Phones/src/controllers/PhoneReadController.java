package controllers;

import database.entities.Phone;
import models.PhoneReadModel;
import utils.AppStarter;
import utils.Constants;
import views.PhoneReadView;

import java.util.List;

public class PhoneReadController {

    PhoneReadModel model;
    PhoneReadView view;

    public PhoneReadController(PhoneReadModel model, PhoneReadView view) {
        this.model = model;
        this.view = view;
    }

    public void getPhones() {
        String str = readPhones();
        // Проверяем возврат чтения данных.
        if (str.equals(Constants.DB_ABSENT_MSG)) {
            // Выводим уведомление.
            view.getOutput(str);
            // Закрываем приложение.
            System.exit(0);
        } else {
            // Выводим уведомление или данные.
            view.getOutput(str);
            // Перезапускаем приложение.
            AppStarter.startApp();
        }
    }

    private String readPhones() {

        // Получаем данные в коллекцию.
        List<Phone> phones = model.readPhones();

        // Если коллекция не null, формируем вывод.
        // Иначе уведомление об отсутствии БД.
        if (phones != null) {
            // Если коллекция не пуста, формируем вывод.
            // Иначе уведомление об отсутствии данных.
            if (!phones.isEmpty()) {
                int count = 0;
                String str;

                StringBuilder stringBuilder = new StringBuilder();

                for (Phone phone : phones) {
                    count++;
                    str = count + ") ID: "
                            + phone.getId() + " - "
                            + " " + phone.getName()
                            + " " + phone.getPhone()
                            + "\n";
                    stringBuilder.append(str);
                }
                return stringBuilder.toString();
            } else
                return Constants.DATA_ABSENT_MSG;
        } else
            return Constants.DB_ABSENT_MSG;
    }
}
