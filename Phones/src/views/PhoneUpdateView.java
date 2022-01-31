package views;

import database.entities.Phone;
import models.PhoneUpdateModel;
import utils.Validator;

import java.util.Scanner;

public class PhoneUpdateView {

    PhoneUpdateModel model;
    Phone phone;
    String title;
    int id;
    String phoneNumber;
    Scanner scanner;

    public PhoneUpdateView(PhoneUpdateModel model) {
        this.model = model;
    }

    public Phone doInputs() {

        scanner = new Scanner(System.in);
        phone = new Phone();

        // Ввод и валидация данных

        title = "Введите ID контакта: ";
        System.out.print(title);
        id = Validator.validateIdInput(scanner);
        phone.setId(id);

        title = "Введите новый телефон: ";
        System.out.print(title);
        phoneNumber = Validator.validatePhoneInput(scanner);
        phone.setPhone(phoneNumber);

        return phone;
    }

    // Вывод уведомления
    public void getOutput(String output) {
        System.out.println(output);
    }
}
