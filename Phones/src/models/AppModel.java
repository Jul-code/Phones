package models;

import controllers.PhoneCreateController;
import controllers.PhoneDeleteController;
import controllers.PhoneReadController;
import controllers.PhoneUpdateController;
import views.PhoneAddView;
import views.PhoneDeleteView;
import views.PhoneReadView;
import views.PhoneUpdateView;

public class AppModel {

    private int choice;

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void createPhone() {
        PhoneAddModel model = new PhoneAddModel();
        PhoneAddView view = new PhoneAddView(model);
        PhoneCreateController controller = new PhoneCreateController(model, view);
        controller.addPhone();
    }

    public void readPhones() {
        PhoneReadModel model = new PhoneReadModel();
        PhoneReadView view = new PhoneReadView(model);
        PhoneReadController controller = new PhoneReadController(model, view);
        controller.getPhones();
    }

    public void updatePhone() {
        PhoneUpdateModel model = new PhoneUpdateModel();
        PhoneUpdateView view = new PhoneUpdateView(model);
        PhoneUpdateController controller = new PhoneUpdateController(model, view);
        controller.updatePhone();
    }

    public void deletePhone() {
        PhoneDeleteModel model = new PhoneDeleteModel();
        PhoneDeleteView view = new PhoneDeleteView(model);
        PhoneDeleteController controller = new PhoneDeleteController(model, view);
        controller.deletePhone();
    }
}
