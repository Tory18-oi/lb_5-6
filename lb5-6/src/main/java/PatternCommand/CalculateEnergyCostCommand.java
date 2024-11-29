package PatternCommand;

import Appliance.ElectricalAppliance;
import java.util.ArrayList;

public class CalculateEnergyCostCommand implements Command {
    private ArrayList<ElectricalAppliance> appliances;

    public CalculateEnergyCostCommand(ArrayList<ElectricalAppliance> appliances) {
        this.appliances = appliances;
    }

    @Override
    public void execute() {
        int totalPower = appliances.stream().mapToInt(ElectricalAppliance::getPower).sum();
        double cost = totalPower * 0.15; // Припустимо, тариф 0.15 за одиницю
        System.out.println("Energy consumption cost: $" + cost);
    }
}
