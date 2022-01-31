package controllers;

import models.PhoneUpdateModel;
import utils.AppStarter;
import utils.Constants;
import views.PhoneUpdateView;

public class PhoneUpdateController {

    PhoneUpdateModel model;
    PhoneUpdateView view;

    public PhoneUpdateController(PhoneUpdateModel model, PhoneUpdateView view) {
        this.model = model;
        this.view = view;
    }

    public void updatePhone() {

        // Вносим данные и получаем сообщение.
        String str = model.updatePhone(view.doInputs());
        // Проверяем сообщение на внесение данных.
        // Если БД отсутствует, выводим сообщение об этом
        // и закрываем приложение.
        // Иначе выводим сообщение и перезапускаем приложение.
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
