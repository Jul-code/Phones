package controllers;

import models.PhoneDeleteModel;
import utils.AppStarter;
import utils.Constants;
import views.PhoneDeleteView;

public class PhoneDeleteController {

    PhoneDeleteModel model;
    PhoneDeleteView view;

    public PhoneDeleteController(PhoneDeleteModel model, PhoneDeleteView view) {
        this.model = model;
        this.view = view;
    }

    public void deletePhone() {

        // Вносим данные и получаем сообщение.
        String str = model.deletePhone(view.doInput());
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
