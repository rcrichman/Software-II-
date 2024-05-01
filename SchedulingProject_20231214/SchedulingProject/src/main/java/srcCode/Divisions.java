package srcCode;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.concurrent.atomic.AtomicInteger;

public class Divisions
{
    private ObservableList<Division> allDivisions;

    public Divisions()
    {
        allDivisions = FXCollections.observableArrayList();

    }

    public void AddDivision(Division newDivision)

    {
        allDivisions.add(newDivision);
    }

    public int GetDivisionID(String sDivisionName)
    {
        AtomicInteger iDivisionID = new AtomicInteger(-1);
        allDivisions.forEach((devision) -> {
            if (devision.getDivision() == sDivisionName)
            {
                iDivisionID.set(devision.getDivision_id());
            }
        });

        return iDivisionID.get();

    }

    public ObservableList<String> GetDivisions(int iCountry_ID)
    {
        ObservableList<String> divisionNames =  FXCollections.observableArrayList();
        allDivisions.forEach((devision) -> {
            if (devision.getCountry_id() == iCountry_ID)
            {
                divisionNames.add(devision.getDivision());
            }
        });

        return divisionNames;
    }

    public ObservableList<Division> getAllDivisions()
    {
        return allDivisions;
    }
    public Integer getNumDivisions()
    {
        return allDivisions.size();
    }
}
