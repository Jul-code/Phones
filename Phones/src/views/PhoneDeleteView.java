package views;

import database.entities.Phone;
import models.PhoneDeleteModel;
import utils.Validator;

import java.util.Scanner;

public class PhoneDeleteView {

    PhoneDeleteModel model;

    public PhoneDeleteView(PhoneDeleteModel model) {
        this.model = model;
    }

    public Phone doInput() {

        Scanner scanner = new Scanner(System.in);
        Phone phone = new Phone();

        // Ввод и валидация данных
        String title = "Введите ID контакта: ";
        System.out.print(title);
        phone.setId(Validator.validateIdInput(scanner));

        return phone;
    }

    // Вывод уведомления
    public void getOutput(String output) {
        System.out.println(output);
    }
}
