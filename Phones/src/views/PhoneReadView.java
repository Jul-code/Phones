package views;

import models.PhoneReadModel;

public class PhoneReadView {

    PhoneReadModel model;

    public PhoneReadView(PhoneReadModel model) {
        this.model = model;
    }

    // Вывод данных
    public void getOutput(String output) {
        System.out.println(output);
    }
}
