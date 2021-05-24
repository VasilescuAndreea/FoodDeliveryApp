package ro.unibuc.fooddeliveryapp;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Drivers extends Users {
    String mainVehicle;

    public Drivers(@NotNull String userName, Date birthDate, String adress, String mainVehicle) {
        super(userName, birthDate, adress);
        this.mainVehicle = mainVehicle;
    }

    public Drivers(final int id, @NotNull String userName, Date birthDate, String adress, String mainVehicle) {
        super(id, userName, birthDate, adress);
        this.mainVehicle = mainVehicle;
    }

    @Override
    public String csvParser() {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return super.csvParser() + ", " + mainVehicle;
    }


}
