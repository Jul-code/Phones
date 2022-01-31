package controllers;

import database.entities.Phone;
import models.PhoneAddModel;
import utils.AppStarter;
import utils.Constants;
import views.PhoneAddView;

public class PhoneCreateController {

    PhoneAddModel model;
    PhoneAddView view;
    Phone phone;

    public PhoneCreateController(PhoneAddModel model, PhoneAddView view) {
        this.model = model;
        this.view = view;
    }

    public void addPhone() {

        phone = view.doInputs();
        // Вносим данные и получаем сообщение.
        String str = model.addPhone(phone);
        // Проверяем сообщение на внесение данных.
        if (str.equals(Constants.DB_ABSENT_MSG)) {
            // Выводим уведомление.
            view.getOutput(str);
            // Закрываем приложение.
            System.exit(0);
        } else {
            // Выводим уведомление.
            view.getOutput(str);
            // Перезапускаем приложение.
            AppStarter.startApp();
        }
    }
}
