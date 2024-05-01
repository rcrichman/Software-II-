package srcCode;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class ManageCustomers_Controller
{

    private Customers clsCustomers;
    private Countries clsCountries;

    private Divisions clsDivisions;

    private Boolean bNeedToSave;

    public ManageCustomers_Controller()
    {
        clsCustomers = new Customers();
        clsCountries = new Countries();
        clsDivisions = new Divisions();
    }
    @FXML
    private Button btnAdd_fxi;

    @FXML
    private Button btnCancel_fxid;

    @FXML
    private Button btnDelete_fxid;

    @FXML
    private Button btnEdit_fxid;

    @FXML
    private Button btnExit_fxid;

    @FXML
    private Button btnSave_fxid;

    @FXML
    private ToggleGroup grpCustAppt;
    @FXML
    private ToggleButton togButAppointments_fxid;

    @FXML
    private ToggleButton togButCustomers_fxid;
    @FXML
    private ComboBox<String> cbCountry_fxid;

    @FXML
    private ComboBox<String> cbDivision_fxid;
    @FXML
    private TableColumn<Customer, String> colAddress_fxid;

    @FXML
    private TableColumn<?, ?> colCountry_fxid;

    @FXML
    private TableColumn<?, ?> colDivision_fxid;

    @FXML
    private TableColumn<Customer, Integer> colID_fxid;

    @FXML
    private TableColumn<Customer, String> colName_fxid;

    @FXML
    private TableColumn<Customer, String> colPhone_fxid;

    @FXML
    private TableColumn<Customer, String> colPostalCode_fxid;

    @FXML
    private TableView<Customer> tvCustomers_fxid;

    @FXML
    private Label lblAddress_fxid;

    @FXML
    private Label lblCountry_fxid;

    @FXML
    private Label lblCustomerID_fxid;

    @FXML
    private Label lblCustomers_fxid;

    @FXML
    private Label lblDivision_fxid;

    @FXML
    private Label lblEntry_fxid;

    @FXML
    private Label lblName_fxid;

    @FXML
    private Label lblPhone_fxid;

    @FXML
    private Label lblPostalCode_fxid;

    @FXML
    private Pane paneEntry_fxid;

    @FXML
    private TextField txtAddress_fxid;

    @FXML
    private TextField txtCustomerID_fxid;

    @FXML
    private TextField txtName_fxid;

    @FXML
    private TextField txtPhone_fxid;

    @FXML
    private TextField txtPostalCode_fxid;
    @FXML
    void btnAdd_Click(ActionEvent event)
    {
       lblEntry_fxid.setText("Add");
       lblCustomerID_fxid.setVisible(false);
       txtCustomerID_fxid.setVisible(false);
        cbCountry_fxid.setItems(clsCountries.getAllCountryNames());
        paneEntry_fxid.setVisible(true);
        bNeedToSave = true;
        ManageControls(true);

    }

    private void ManageControls(boolean bDisable)
    {
        tvCustomers_fxid.setDisable(bDisable);
        btnAdd_fxi.setDisable(bDisable);
        btnEdit_fxid.setDisable(bDisable);
        btnDelete_fxid.setDisable(bDisable);
    }

    @FXML
    void togButAppointments_Click(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Appointments.fxml"));
        Parent root = fxmlLoader.load();
        ManageAppointments_Controller conManageAppts = fxmlLoader.getController();
        conManageAppts.LoadAppointments();
        Scene scene = new Scene(root);
        stage.setTitle("Appointments");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void btnExit_Click(ActionEvent event)
    {
        if (bNeedToSave)
        {
            bNeedToSave = ShowAlert("Do you want to save before exiting?");
            if (bNeedToSave)
            {
                SaveCustomer();
            }
        }

        System.exit(0);
    }

    @FXML
    void btnSave_Click(ActionEvent event)
    {
        String sMessage = ValidateData();
        if (Objects.equals(sMessage, ""))
        {
            SaveCustomer();
            paneEntry_fxid.setVisible(false);
            ClearFields();
            bNeedToSave = false;
            ManageControls(false);
        }
        else
        {
            ShowDialog(sMessage);
        }

    }

    private String ValidateData()
    {
        String sErrMsg = "";

        String sCBc = cbCountry_fxid.getSelectionModel().getSelectedItem();
        String sCBd = cbDivision_fxid.getSelectionModel().getSelectedItem();

        if ((Objects.equals(txtName_fxid.getText(), "")) || (Objects.equals(txtAddress_fxid.getText(), "")) ||
                (Objects.equals(txtPostalCode_fxid.getText(), "")) || (Objects.equals(txtPhone_fxid.getText(), "")) ||
                (sCBc == null) ||  (sCBd == null))
        {
            sErrMsg = "All fields must be filled in!";
        }

        return sErrMsg;
    }

    private void SaveCustomer()
    {

        Customer clsCustomerNew = new Customer();

        clsCustomerNew.setCustomer_name(txtName_fxid.getText());
        clsCustomerNew.setAddress(txtAddress_fxid.getText());
        clsCustomerNew.setPostal_code(txtPostalCode_fxid.getText());
        clsCustomerNew.setPhone(txtPhone_fxid.getText());
        String country_name = cbCountry_fxid.getSelectionModel().getSelectedItem();
        clsCustomerNew.setCountry_name(country_name);
        clsCustomerNew.setCountry_id(clsCountries.GetCountryID((country_name)));
        String division_name = cbDivision_fxid.getSelectionModel().getSelectedItem();
        clsCustomerNew.setDivision_name(division_name);
        clsCustomerNew.setDivision_id((clsDivisions.GetDivisionID(division_name)));

        if (Objects.equals(lblEntry_fxid.getText(), "Add"))
        {
           //NEW
            clsCustomers.AddCustomer(clsCustomerNew);
        }
        else
        {
            //EDIT
            clsCustomerNew.setCustomer_id(Integer.parseInt(txtCustomerID_fxid.getText()));
            Customer clsCustomer = tvCustomers_fxid.getSelectionModel().getSelectedItem();
            clsCustomers.UpdateCustomer(clsCustomer,clsCustomerNew);
        }
    }
    @FXML
    void btnCancel_Click(ActionEvent event)
    {
        paneEntry_fxid.setVisible(false);
        ClearFields();
        bNeedToSave = false;
        ManageControls(false);
    }
    @FXML
    void btnDelete_Click(ActionEvent event)
    {

        Boolean bOk2Delete = false;
        Customer clsCustomer = tvCustomers_fxid.getSelectionModel().getSelectedItem();

        if (clsCustomer != null)
        {
            bOk2Delete = ShowAlert("Ok to delete customer?");
            if (bOk2Delete)
            {
                clsCustomers.RemoveCustomer(clsCustomer);
            }
        }
        else
        {
            ShowDialog("You must select a Customer record to delete.");
        }
    }


    @FXML
    void btnEdit_Click(ActionEvent event)
    {
        Customer clsCustomer = tvCustomers_fxid.getSelectionModel().getSelectedItem();
       if (clsCustomer != null)
       {
           ManageControls(true);
           lblEntry_fxid.setText("Edit");
           LoadFields(clsCustomer);
           lblCustomerID_fxid.setVisible(true);
           txtCustomerID_fxid.setVisible(true);
           paneEntry_fxid.setVisible(true);
           bNeedToSave = true;
       }
       else
       {
           ShowDialog("You must select a Customer record to edit.");
       }
    }
    private void ClearFields()
    {
        txtCustomerID_fxid.clear();
        txtName_fxid.clear();
        txtAddress_fxid.clear();
        txtPostalCode_fxid.clear();
        txtPhone_fxid.clear();
    }

    private void LoadFields(Customer clsCustomer)
    {
        txtCustomerID_fxid.setText(String.valueOf(clsCustomer.getCustomer_id()));
        txtName_fxid.setText((clsCustomer.getCustomer_name()));
        txtAddress_fxid.setText(clsCustomer.getAddress());
        txtPostalCode_fxid.setText(clsCustomer.getPostal_code());
        txtPhone_fxid.setText(clsCustomer.getPhone());
        cbCountry_fxid.setValue(clsCustomer.getCountry_name());
        cbDivision_fxid.setItems(clsDivisions.GetDivisions(clsCustomer.getCountry_id()));
        cbDivision_fxid.setValue(clsCustomer.getDivision_name());
    }

    public void LoadCustomers()
    {
        bNeedToSave = false;
        paneEntry_fxid.setVisible(false);

       Customer clsCustomer = new Customer();
       clsCustomer.setCustomer_name("Mike");
       clsCustomer.setAddress("111 44th Street, Somewhere");
       clsCustomer.setPostal_code("19111");
       clsCustomer.setPhone("555-1111");
       clsCustomer.setDivision_id(1);
       clsCustomer.setDivision_name("US1");
       clsCustomer.setCountry_id(1);
       clsCustomer.setCountry_name("United States");
       clsCustomers.AddCustomer(clsCustomer);

       clsCustomer = new Customer();
       clsCustomer.setCustomer_name("Jeff");
       clsCustomer.setAddress("2222 44th Street, Somewhere");
       clsCustomer.setPostal_code("19222");
       clsCustomer.setPhone("555-2222");
       clsCustomer.setDivision_id(6);
       clsCustomer.setDivision_name("Can1");
       clsCustomer.setCountry_id(3);
       clsCustomer.setCountry_name("Canada");
       clsCustomers.AddCustomer(clsCustomer);
       LoadCustomersTable();

       Country clsCountry = new Country();
       clsCountry.setCountry_id(1);
       clsCountry.setCountry("United States");
       clsCountries.AddCountry(clsCountry);

       Division clsDivision = new Division();
       clsDivision.setCountry_id(1);
       clsDivision.setDivision_id(1);
       clsDivision.setDivision("US1");
       clsDivisions.AddDivision(clsDivision);

        clsDivision = new Division();
        clsDivision.setCountry_id(1);
        clsDivision.setDivision_id(2);
        clsDivision.setDivision("US2");
        clsDivisions.AddDivision(clsDivision);

        clsDivision = new Division();
        clsDivision.setCountry_id(1);
        clsDivision.setDivision_id(3);
        clsDivision.setDivision("US3");
        clsDivisions.AddDivision(clsDivision);

        clsCountry = new Country();
        clsCountry.setCountry_id(2);
        clsCountry.setCountry("United Kingdom");
        clsCountries.AddCountry(clsCountry);

         clsDivision = new Division();
        clsDivision.setCountry_id(2);
        clsDivision.setDivision_id(4);
        clsDivision.setDivision("UK1");
        clsDivisions.AddDivision(clsDivision);

        clsDivision = new Division();
        clsDivision.setCountry_id(2);
        clsDivision.setDivision_id(5);
        clsDivision.setDivision("UK2");
        clsDivisions.AddDivision(clsDivision);

        clsCountry = new Country();
        clsCountry.setCountry_id(3);
        clsCountry.setCountry("Canada");
        clsCountries.AddCountry(clsCountry);

         clsDivision = new Division();
        clsDivision.setCountry_id(3);
        clsDivision.setDivision_id(6);
        clsDivision.setDivision("Can1");
        clsDivisions.AddDivision(clsDivision);

        clsDivision = new Division();
        clsDivision.setCountry_id(3);
        clsDivision.setDivision_id(7);
        clsDivision.setDivision("Can2");
        clsDivisions.AddDivision(clsDivision);

        cbCountry_fxid.setItems(clsCountries.getAllCountryNames());

    }

    private void LoadCustomersTable()
    {
        ObservableList<Customer> allCustomers = clsCustomers.getAllCustomers();
        colID_fxid.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        colName_fxid.setCellValueFactory(new PropertyValueFactory<>("customer_name"));
        colAddress_fxid.setCellValueFactory(new PropertyValueFactory<>("address"));
        colPostalCode_fxid.setCellValueFactory(new PropertyValueFactory<>("postal_code"));
        colPhone_fxid.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colDivision_fxid.setCellValueFactory(new PropertyValueFactory<>("division_name"));
        colCountry_fxid.setCellValueFactory(new PropertyValueFactory<>("country_name"));
        tvCustomers_fxid.setItems(allCustomers);
    }
    @FXML
    void LoadDivisions(ActionEvent event) {
        int iCountryID = clsCountries.GetCountryID(cbCountry_fxid.getSelectionModel().getSelectedItem());
        cbDivision_fxid.setItems(clsDivisions.GetDivisions(iCountryID));
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

    private Boolean ShowAlert(String sMsg)
    {
        AtomicReference<Boolean> bYes = new AtomicReference<>(false);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(sMsg);
        ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
        //ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        //alert.getButtonTypes().setAll(yesButton, noButton, cancelButton);
        alert.getButtonTypes().setAll(yesButton, noButton);
        alert.showAndWait().ifPresent(type -> {
            if (type == yesButton) {
                bYes.set(true);
            }});
        return bYes.get();
    }
}
