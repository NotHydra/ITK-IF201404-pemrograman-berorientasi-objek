package utilities;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Modal {
    public boolean confirmation() {
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Notification");
        confirmation.setHeaderText("Confirmation");
        confirmation.setContentText("Are you sure?");

        confirmation.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);

        java.util.Optional<ButtonType> result = confirmation.showAndWait();

        return result.isPresent() && result.get() == ButtonType.YES;
    }
}
