package srcCode;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.concurrent.atomic.AtomicInteger;

public class Countries
{
    private ObservableList<Country> allCountries;
    private ObservableList<String> allCountryNames;
    public Countries()
    {
        allCountries = FXCollections.observableArrayList();
        allCountryNames = FXCollections.observableArrayList();
    }

    public void AddCountry(Country newCountry)
    {
        allCountries.add(newCountry);
        allCountryNames.add(newCountry.getCountry());
    }

    public int GetCountryID(String sCountryName)
    {
        AtomicInteger iCountryID = new AtomicInteger(-1);
        allCountries.forEach((country) -> {
            if (country.getCountry() == sCountryName)
            {
                iCountryID.set(country.getCountry_id());
            }
                });

        return iCountryID.get();

    }

    public ObservableList<Country> getAllCountries()
    {
        return allCountries;
    }
    public ObservableList<String> getAllCountryNames()
    {
        return allCountryNames;
    }
    public Integer getNumCountries()
    {
        return allCountries.size();
    }
}
