package views;

import database.entities.Phone;
import models.PhoneAddModel;
import utils.Validator;

import java.util.Scanner;

public class PhoneAddView {

    PhoneAddModel model;
    Phone phone;
    String title;
    String name;
    String phoneNumber;
    Scanner scanner;

    public PhoneAddView(PhoneAddModel model) {
        this.model = model;
    }

    public Phone doInputs() {

        scanner = new Scanner(System.in);
        phone = new Phone();

        // Ввод и валидация данных

        title = "Введите имя: ";
        System.out.print(title);
        name = Validator.validateNameInput(scanner);
        phone.setName(name);

        title = "Введите телефон: ";
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
