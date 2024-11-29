package PatternCommand;

import Appliance.ElectricalAppliance;
import java.util.ArrayList;

import java.util.Comparator;

public class SortByPowerCommand implements Command {
    private ArrayList<ElectricalAppliance> appliances;

    public SortByPowerCommand(ArrayList<ElectricalAppliance> appliances) {
        this.appliances = appliances;
    }

    @Override
    public void execute() {
        appliances.sort(Comparator.comparingInt(ElectricalAppliance::getPower));
        System.out.println("The list of electrical appliances has been sorted by power.");
    }
}
