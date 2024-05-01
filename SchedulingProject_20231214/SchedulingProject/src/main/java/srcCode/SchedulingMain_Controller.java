package srcCode;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class SchedulingMain_Controller
{

    @FXML
    private Button btnExit_fxid;

    @FXML
    private Button btnLogin_fxid;

    @FXML
    private Label lblMessage_fxid;

    @FXML
    private Label lblAppname_fxid;

    @FXML
    private Label lblLocation_fxid;

    @FXML
    private Label lblLogin_fxid;

    @FXML
    private Label lblPassword_fxid;

    @FXML
    private Label lblUsername_fxid;

    @FXML
    private PasswordField txtPassword_fxid;

    @FXML
    private TextField txtUsername_fxid;

    @FXML
    void btnExit_Action(javafx.event.ActionEvent actionEvent) {
       System.exit(0);
    }

    @FXML
    void btnLogin_Action(javafx.event.ActionEvent actionEvent) throws IOException
    {

        String sMessage = ValidateUser(txtUsername_fxid.getText(),txtPassword_fxid.getText());
        if (!Objects.equals(sMessage, ""))
        {
           lblMessage_fxid.setText(sMessage);
           lblMessage_fxid.setVisible(true);
        }
        else
        {
            lblMessage_fxid.setVisible(false);
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Customers.fxml"));
            Parent root = fxmlLoader.load();
            ManageCustomers_Controller conManageCust = fxmlLoader.getController();
            conManageCust.LoadCustomers();
            Scene scene = new Scene(root);
            stage.setTitle("Customers");
            stage.setScene(scene);
            stage.show();
        }
    }

    private String ValidateUser(String sUsername, String sPassword)
    {
        String sRetVal = "";

        if ((Objects.equals(sUsername, "")) || (Objects.equals(sPassword, "")))
        {
            sRetVal = "Please enter a username and password!";
        }
        return sRetVal;
    }

    private Boolean ShowAlert(String sMsg)
    {

        AtomicReference<Boolean> bYes = new AtomicReference<>(false);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(sMsg);
        ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(yesButton, noButton, cancelButton);
        alert.showAndWait().ifPresent(type -> {
            if (type == yesButton) {
                bYes.set(true);
            }});
        return bYes.get();

    }

    public static void ShowDialog(String sMsg)
    {
        Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle("Message");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.setContentText(sMsg);
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();
    }
    public static Boolean IsNumber(String strVal, Boolean bIncludeDecimal)
    {

        Integer iCount=0;
        String sNumbers = "0123456789";
        char decimalPoint = '.';

        if (bIncludeDecimal) {
            if (Objects.equals(strVal,"."))
            {
                return false;
            }
            //MAKE SURE THE USER DIDN'T JUST PUT MORE THAN ONE DECIMAL POINT
            for (int i = 0; i < strVal.length(); i++) {
                if (strVal.charAt(i) == decimalPoint) {
                    iCount++;
                }
            }
            if (iCount > 1)
            {
                return false;
            }
            sNumbers += ".";
        }
        for (int i = 0; i < strVal.length(); i++)
        {
            if (sNumbers.indexOf(strVal.charAt(i)) < 0)
            {
                return false;  // NOT A NUMBER
            }
        }
        return true;  // IS A NUMBER
    }
}
