package views;

import models.ContactCreateModel;

public class ContactCreateView {

    ContactCreateModel model;

    public ContactCreateView(ContactCreateModel model) {
        this.model = model;
    }

    // TASK допишите недостающий конструктор.
    // Вывод уведомления
    public void getOutput(String output) {
        System.out.println(output);
    }
}
