package PatternCommand;

import Appliance.ElectricalAppliance;
import java.util.ArrayList;
import java.util.Scanner;

public class AddApplianceCommand implements Command {
    private ArrayList<ElectricalAppliance> appliances;

    public AddApplianceCommand(ArrayList<ElectricalAppliance> appliances) {
        this.appliances = appliances;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        // Зчитуємо параметри для ElectricalAppliance
        System.out.print("Enter appliance name: ");
        String name = scanner.nextLine();

        System.out.print("Enter appliance power (in watts): ");
        int power = scanner.nextInt();
        scanner.nextLine();  // Очистка сканера після зчитування числа

        System.out.print("Enter appliance manufacturer: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Is the appliance on? (true/false): ");
        boolean isOn = scanner.nextBoolean();

        System.out.print("Enter year of manufacture: ");
        int yearOfManufacture = scanner.nextInt();

        System.out.print("Enter usage hours per day: ");
        int usageHours = scanner.nextInt();

        System.out.print("Enter energy rate (cost per kWh): ");
        double energyRate = scanner.nextDouble();

        // Створюємо новий об'єкт ElectricalAppliance з введеними значеннями
        ElectricalAppliance newAppliance = new ElectricalAppliance(
                name,
                power,
                manufacturer,
                isOn,
                yearOfManufacture,
                usageHours,
                energyRate
        );

        // Додаємо новий прилад до списку appliances
        appliances.add(newAppliance);
        System.out.println("Appliance added: " + newAppliance);
    }

    public String getDesc(){
        return "Add Appliance";
    }

}