package PatternCommand;

import Appliance.ElectricalAppliance;
import java.util.ArrayList;

public class PowerOnCommand implements Command {
    private ArrayList<ElectricalAppliance> appliances;

    public PowerOnCommand(ArrayList<ElectricalAppliance> appliances) {
        this.appliances = appliances;
    }

    @Override
    public void execute() {
        for (ElectricalAppliance appliance : appliances) {
            appliance.powerOn();  // Припускаємо, що є метод powerOn() у класі ElectricalAppliance
            System.out.println(appliance.getName() + " on.");
        }
    }
}
