package PatternCommand;

import Appliance.ElectricalAppliance;
import java.util.ArrayList;

public class CalculatePowerUsageCommand implements Command {
    private ArrayList<ElectricalAppliance> appliances;

    public CalculatePowerUsageCommand(ArrayList<ElectricalAppliance> appliances) {
        this.appliances = appliances;
    }

    @Override
    public void execute() {
        int totalPower = appliances.stream().mapToInt(ElectricalAppliance::getPower).sum();
        System.out.println("Total power consumption: " + totalPower + " W");
    }
}
