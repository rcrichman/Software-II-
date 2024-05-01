package srcCode;

import javafx.collections.FXCollections;
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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class ManageAppointments_Controller
{
    private Boolean bNeedToSave;
    private Appointments clsAppointments;
    private Contacts clsContacts;
    private Customers clsCustomers;

    public ManageAppointments_Controller()
    {
        clsAppointments = new Appointments();
        clsContacts = new Contacts();
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
    private ComboBox<String> cbContact_fxid;

    @FXML
    private ComboBox<String> cbCustomer_fxid;

    @FXML
    private ComboBox<String> cbStartTime_fxid;

    @FXML
    private ComboBox<String> cbEndTime_fxid;
    @FXML
    private TableColumn<?, ?> colApptID_fxid;

    @FXML
    private TableColumn<?, ?> colContact_fxid;

    @FXML
    private TableColumn<?, ?> colCustomerID_fxid;

    @FXML
    private TableColumn<?, ?> colDescription_fxid;

    @FXML
    private TableColumn<?, ?> colEndDate_fxid;

    @FXML
    private TableColumn<?, ?> colLocation_fxid;

    @FXML
    private TableColumn<?, ?> colStartDate_fxid;

    @FXML
    private TableColumn<?, ?> colTitle_fxid;

    @FXML
    private TableColumn<?, ?> colType_fxid;

    @FXML
    private TableColumn<?, ?> colUserID_fxid;

    @FXML
    private ToggleGroup grpCustAppt;

    @FXML
    private ToggleGroup grpApptFilter;

    @FXML
    private Label lblApptID_fxid;

    @FXML
    private Label lblContact_fxid;

    @FXML
    private Label lblCustomer_fxid;

    @FXML
    private Label lblDesc_fxid;

    @FXML
    private Label lblEntry_fxid;

    @FXML
    private Label lblLocation_fxid;

    @FXML
    private Label lblTitle_fxid;

    @FXML
    private Label lblType_fxid;

    @FXML
    private Pane paneEntry_fxid;

    @FXML
    private ToggleButton togButAppointments_fxid;

    @FXML
    private ToggleButton togButCustomers_fxid;

    @FXML
    private TableView<Appointment> tvAppointments_fxid;

    @FXML
    private TextField txtApptID_fxid;

    @FXML
    private TextField txtDesc_fxid;

    @FXML
    private TextField txtLocation_fxid;

    @FXML
    private TextField txtTitle_fxid;

    @FXML
    private TextField txtType_fxid;

    @FXML
    private DatePicker dtEndDate_fxid;

    @FXML
    private DatePicker dtStartDate_fxid;

    @FXML
    private RadioButton rbMonth_fxid;

    @FXML
    private RadioButton rbWeek_fxid;
    @FXML
    void togButCustomers_Click(javafx.event.ActionEvent actionEvent) throws IOException {

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
    @FXML
    void btnAdd_Click(ActionEvent event) {

        lblEntry_fxid.setText("Add");
        paneEntry_fxid.setVisible(true);
        bNeedToSave = true;
        ManageControls(true);
        LoadTimeFields(cbStartTime_fxid);
        LoadTimeFields(cbEndTime_fxid);
    }

    @FXML
    void rbApptFilter_Click(ActionEvent event) {

    }
    void LoadTimeFields(ComboBox<String> cbTime)
    {
        int i;
        int j;
        String[] sHour = {"08","09","10","11","12","01","02","03","04","05","06","07","08","09","10"};
        String[] sMin = {"00","15","30","45"};
        String sAMPM = " AM";
        ObservableList<String> hours;
        hours = FXCollections.observableArrayList();
        for (i=0; i<14; i++)
        {
            if (i > 3)
            {
                sAMPM = " PM";
            }
            for (j=0; j<4; j++)
            {
                hours.add(sHour[i] + ":" + sMin[j] + sAMPM);
            }
        }
        cbTime.setItems(hours);
    }
    @FXML
    void btnCancel_Click(ActionEvent event) {

        paneEntry_fxid.setVisible(false);
        ClearFields();
        bNeedToSave = false;
        ManageControls(false);
    }

    @FXML
    void btnDelete_Click(ActionEvent event) {

        Boolean bOk2Delete = false;
        Appointment clsAppointment = tvAppointments_fxid.getSelectionModel().getSelectedItem();

        if (clsAppointment != null)
        {
            bOk2Delete = ShowAlert("Ok to delete appointment?");
            if (bOk2Delete)
            {
                clsAppointments.RemoveAppointment(clsAppointment);
            }
        }
        else
        {
            ShowDialog("You must select an Appointment record to delete.");
        }
    }

    @FXML
    void btnEdit_Click(ActionEvent event) {

        Appointment clsAppointment = tvAppointments_fxid.getSelectionModel().getSelectedItem();
        if (clsAppointment != null)
        {
            ManageControls(true);
            lblEntry_fxid.setText("Edit");
            LoadTimeFields(cbStartTime_fxid);
            LoadTimeFields(cbEndTime_fxid);
            LoadFields(clsAppointment);
            paneEntry_fxid.setVisible(true);
            bNeedToSave = true;
        }
        else
        {
            ShowDialog("You must select an Appointment record to edit.");
        }
    }

    private void LoadFields(Appointment clsAppointment)
    {
        txtApptID_fxid.setText(String.valueOf(clsAppointment.getAppointment_id()));
        txtTitle_fxid.setText(clsAppointment.getTitle());
        txtDesc_fxid.setText((clsAppointment.getDescription()));
        txtLocation_fxid.setText(clsAppointment.getLocation());
        txtType_fxid.setText(clsAppointment.getType());
        dtStartDate_fxid.setValue(LocalDate.parse(clsAppointment.getStartDateOnly()));
        dtEndDate_fxid.setValue(LocalDate.parse(clsAppointment.getEndDateOnly()));
        cbStartTime_fxid.setValue(clsAppointment.getStartTimeOnly());
        cbEndTime_fxid.setValue(clsAppointment.getEndTimeOnly());
        cbCustomer_fxid.setValue(String.valueOf(clsAppointment.getCustomer_id()));
        cbContact_fxid.setValue(clsContacts.getContactNameById(clsAppointment.getContact_id()));
    }

    private String FormatTimeToAMPM(String timeIn)
    {
        String sAMPM = "AM";
        String[] timeInRay = timeIn.split((":"));
        Integer timeHours = Integer.parseInt(timeInRay[0]);
        if (timeHours >= 12)
        {
            sAMPM = "PM";
            if (timeHours > 12)
            {
                timeHours -= 12;
            }
        }
        String timeOut = String.valueOf(timeHours) + ":" + timeInRay[1] + " " + sAMPM;
        return timeOut;
    }
    private String FormatTimeToMilitary(String timeIn)
    {
        String sAMPM = "AM";
        String timeOut;
        Integer hours;

        if (timeIn.indexOf("PM") > 0)
        {
            sAMPM = "PM";
            timeIn.replace(" PM","");
        }
        else
        {
            timeIn.replace(" AM","");
        }
        String[] timeInRay = timeIn.split(":");
        hours = Integer.valueOf(timeInRay[0]);
        if ((sAMPM == "PM") && (hours != 12))
        {
            hours += 12;
        }

        timeOut = hours.toString() + ":" + timeInRay[1];
        return timeOut;
    }

    @FXML
    void dtEndDate_Action(ActionEvent event) {

        LocalDate ldEnd = dtEndDate_fxid.getValue();
        DayOfWeek sDayOfWeek = ldEnd.getDayOfWeek();
        if (sDayOfWeek.getValue() >= 6)
        {
            ShowDialog("End Date cannot be on the weekend!");
            dtEndDate_fxid.setValue(null);
        }
        else
        {
            int iCompare = CompareDates(dtStartDate_fxid.getValue(),ldEnd);
            if (iCompare > 0)
            {
                ShowDialog("End Date must be on or after Start Date!");
                dtEndDate_fxid.setValue(null);
            }
        }


    }

    @FXML
    void dtStartDate_Action(ActionEvent event) {

        LocalDate ldStart = dtStartDate_fxid.getValue();
        DayOfWeek sDayOfWeek = ldStart.getDayOfWeek();
        if (sDayOfWeek.getValue() >= 6)
        {
            ShowDialog("Start Date cannot be on the weekend!");
            dtStartDate_fxid.setValue(null);
        }
        else {
            int iCompare = CompareDates(ldStart, dtEndDate_fxid.getValue());
            if (iCompare > 0) {
                ShowDialog("Start Date must be on or prior to End Date!");
                dtStartDate_fxid.setValue(null);
            }
        }
    }
    int CompareDates(LocalDate dtStart, LocalDate dtEnd)
    {
        int iCompare = -1;
        if ((dtStart != null) && (dtEnd != null))
        {
            iCompare = dtStart.compareTo(dtEnd);
        }

        return iCompare;
    }
    @FXML
    void btnExit_Click(ActionEvent event) {

        if (bNeedToSave)
        {
            bNeedToSave = ShowAlert("Do you want to save before exiting?");
            if (bNeedToSave)
            {
                SaveAppointment();
            }
        }

        System.exit(0);
    }

    private void SaveAppointment()
    {
       Appointment clsAppointmentNew = new Appointment();
       clsAppointmentNew.setTitle(txtTitle_fxid.getText());
       clsAppointmentNew.setDescription(txtDesc_fxid.getText());
       clsAppointmentNew.setLocation(txtLocation_fxid.getText());
       clsAppointmentNew.setType(txtType_fxid.getText());
       clsAppointmentNew.setStartDate(String.valueOf(dtStartDate_fxid.getValue()) + " " + cbStartTime_fxid.getValue());
       clsAppointmentNew.setEndDate(String.valueOf(dtEndDate_fxid.getValue()) + " " + cbEndTime_fxid.getValue());
       clsAppointmentNew.setContact(cbContact_fxid.getValue());
       clsAppointmentNew.setContact_id(clsContacts.GetContactID(cbContact_fxid.getValue()));

       if (lblEntry_fxid.getText() == "Add")
        {
            //NEW
           clsAppointments.AddAppointment(clsAppointmentNew);
        }
       else
       {
           //EDIT
           clsAppointmentNew.setAppointment_id(Integer.parseInt(txtApptID_fxid.getText()));
           Appointment clsAppointment = tvAppointments_fxid.getSelectionModel().getSelectedItem();
           clsAppointments.UpdateAppointment(clsAppointment,clsAppointmentNew);
       }
     }

    @FXML
    void btnSave_Click(ActionEvent event) {

        String sMessage = ValidateData();
        if (Objects.equals(sMessage, ""))
        {
            SaveAppointment();
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

        if ((Objects.equals(txtTitle_fxid.getText(), "")) || (Objects.equals(txtDesc_fxid.getText(), "")) ||
                (Objects.equals(txtLocation_fxid.getText(), "")) || (Objects.equals(txtType_fxid.getText(), "")) ||
                (dtStartDate_fxid.getValue() == null) || (dtEndDate_fxid.getValue() == null) ||
                (cbStartTime_fxid.getValue() == "") || (cbEndTime_fxid.getValue() == ""))
        {
            sErrMsg = "All fields must be filled in!";
        }
        return sErrMsg;
    }

    private void ClearFields()
    {
        txtApptID_fxid.clear();
        txtTitle_fxid.clear();
        txtDesc_fxid.clear();
        txtLocation_fxid.clear();
        txtType_fxid.clear();
        dtStartDate_fxid.setValue(null);
        dtEndDate_fxid.setValue(null);
        cbStartTime_fxid.setValue("");
        cbEndTime_fxid.setValue("");
        cbCustomer_fxid.setValue("");
        cbContact_fxid.setValue("");
    }
    public void LoadAppointments()
    {
        bNeedToSave = false;
        paneEntry_fxid.setVisible(false);
        ClearFields();

        LoadContacts();

        Appointment clsAppointment = new Appointment();
        clsAppointment.setTitle("Title1");
        clsAppointment.setDescription(("Desc1"));
        clsAppointment.setLocation("Loc1");
        clsAppointment.setType("Type1");
        clsAppointment.setStartDate("2024-01-12 12:00 PM");
        clsAppointment.setEndDate("2024-01-12 12:45 PM");
        clsAppointment.setContact_id(1);
        clsAppointment.setContact(clsContacts.getContactNameById(1));
        clsAppointment.setCustomer_id(10);
        clsAppointments.AddAppointment(clsAppointment);

        clsAppointment = new Appointment();
        clsAppointment.setTitle("Title2");
        clsAppointment.setDescription(("Desc2"));
        clsAppointment.setLocation("Loc2");
        clsAppointment.setType("Type2");
        clsAppointment.setStartDate("2024-01-10 10:45 AM");
        clsAppointment.setEndDate("2024-01-10 11:45 AM");
        clsAppointment.setContact_id(2);
        clsAppointment.setContact(clsContacts.getContactNameById(2));
        clsAppointment.setCustomer_id(20);
        clsAppointments.AddAppointment(clsAppointment);
        LoadAppointmentsTable();

    }

    private void LoadAppointmentsTable()
    {
        ObservableList<Appointment> allAppointments = clsAppointments.getAllAppointments();
        colApptID_fxid.setCellValueFactory(new PropertyValueFactory<>("appointment_id"));
        colTitle_fxid.setCellValueFactory(new PropertyValueFactory<>("title"));
        colDescription_fxid.setCellValueFactory(new PropertyValueFactory<>("description"));
        colLocation_fxid.setCellValueFactory(new PropertyValueFactory<>("location"));
        colContact_fxid.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colType_fxid.setCellValueFactory(new PropertyValueFactory<>("type"));
        colStartDate_fxid.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        colEndDate_fxid.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        colCustomerID_fxid.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        colUserID_fxid.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        tvAppointments_fxid.setItems(allAppointments);
    }

    private void LoadContacts()
    {
        Contact clsContact = new Contact();
        clsContact.setContact_name("Joe Rockhead");
        clsContact.setEmail("jRockhead@gmail.com");
        clsContacts.AddContact(clsContact);

        clsContact = new Contact();
        clsContact.setContact_name("Joe Schmoe");
        clsContact.setEmail("jSchmoe@gmail.com");
        clsContacts.AddContact(clsContact);

        clsContact = new Contact();
        clsContact.setContact_name("Joe Mama");
        clsContact.setEmail("jMama@gmail.com");
        clsContacts.AddContact(clsContact);

        cbContact_fxid.setItems(clsContacts.getAllContactNames());
    }

    private void ManageControls(boolean bDisable)
    {
        tvAppointments_fxid.setDisable(bDisable);
        btnAdd_fxi.setDisable(bDisable);
        btnEdit_fxid.setDisable(bDisable);
        btnDelete_fxid.setDisable(bDisable);
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
