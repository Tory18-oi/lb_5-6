
package PatternCommand;

import Appliance.ElectricalAppliance;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveApplianceCommand implements Command {
    private ArrayList<ElectricalAppliance> appliances;

    public RemoveApplianceCommand(ArrayList<ElectricalAppliance> appliances) {
        this.appliances = appliances;
    }

    @Override
    public void execute() {
        if (appliances.isEmpty()) {
            System.out.println("There are no appliances to remove.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the appliance to remove: ");
        String applianceName = scanner.nextLine();

        ElectricalAppliance applianceToRemove = null;


        for (ElectricalAppliance appliance : appliances) {
            if (appliance.getName().equalsIgnoreCase(applianceName)) {
                applianceToRemove = appliance;
                break;
            }
        }

        if (applianceToRemove != null) {
            appliances.remove(applianceToRemove);
            System.out.println("Appliance \"" + applianceName + "\" has been removed.");
        } else {
            System.out.println("No appliance found with the name \"" + applianceName + "\".");
        }
    }
}
