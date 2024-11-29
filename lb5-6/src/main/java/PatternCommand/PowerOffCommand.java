package PatternCommand;

import Appliance.ElectricalAppliance;
import java.util.ArrayList;

public class PowerOffCommand implements Command {
    private ArrayList<ElectricalAppliance> appliances;

    public PowerOffCommand(ArrayList<ElectricalAppliance> appliances) {
        this.appliances = appliances;
    }

    @Override
    public void execute() {
        for (ElectricalAppliance appliance : appliances) {
            appliance.powerOff();
            System.out.println(appliance.getName() + " off.");
        }
    }
}
