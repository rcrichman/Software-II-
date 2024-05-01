package srcCode;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Appointments
{
    private ObservableList<Appointment> allAppointments;
    private Integer AppointmentID;

    public Appointments()
    {
        AppointmentID = 0;
        allAppointments = FXCollections.observableArrayList();
    }

    public void AddAppointment(Appointment newAppointment)
    {
        AppointmentID++;
        newAppointment.setAppointment_id(AppointmentID);
        allAppointments.add(newAppointment);
    }
    public void UpdateAppointment(Appointment originalAppointment, Appointment updatedAppointment)
    {
        allAppointments.remove(originalAppointment);
        allAppointments.add(updatedAppointment);
    }
    public void RemoveAppointment(Appointment removedAppointment)
    {
        allAppointments.remove(removedAppointment);
    }
    public ObservableList<Appointment> getAllAppointments()
    {
        return allAppointments;
    }
    public Integer getNumAppointments()
    {
        return allAppointments.size();
    }
}
