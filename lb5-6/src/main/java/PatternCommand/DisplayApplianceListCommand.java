package PatternCommand;

import Appliance.ElectricalAppliance;
import java.util.ArrayList;

public class DisplayApplianceListCommand implements Command {
    private ArrayList<ElectricalAppliance> appliances;

    public DisplayApplianceListCommand(ArrayList<ElectricalAppliance> appliances) {
        this.appliances = appliances;
    }

    @Override
    public void execute() {
        System.out.println("List of electrical appliances:");

        appliances.forEach(appliance -> {
            System.out.println("Name: " + appliance.getName());
            System.out.println("Power: " + appliance.getPower() + " W");
            System.out.println("Manufacturer: " + appliance.getManufacturer());
            System.out.println("Year of Manufacture: " + appliance.getYearOfManufacture());
            System.out.println("Status: " + (appliance.isOn() ? "On" : "Off"));
            System.out.println("Usage Hours: " + appliance.getUsageHours() + " hours");
            System.out.println("Energy Rate: " + appliance.getEnergyRate() + " UAH/kWh");
            System.out.println("---------------------------------");
        });
    }
}
