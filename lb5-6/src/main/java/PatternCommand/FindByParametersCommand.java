package PatternCommand;

import Appliance.ElectricalAppliance;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindByParametersCommand implements Command {
    private ArrayList<ElectricalAppliance> appliances;

    public FindByParametersCommand(ArrayList<ElectricalAppliance> appliances) {
        this.appliances = appliances;
    }

    @Override
    public void execute() {
        if (appliances.isEmpty()) {
            System.out.println("No appliances to search.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter search parameters (leave empty to skip):");

        // Запит користувача на введення одного параметра для пошуку
        System.out.println("Choose the parameter to search by:");
        System.out.println("1. Name");
        System.out.println("2. Power");
        System.out.println("3. Manufacturer");
        System.out.println("4. Year of Manufacture");
        System.out.println("5. Power Status (On/Off)");

        System.out.print("Enter the number of the parameter you want to search by (or press Enter to skip): ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1": // Пошук за назвою
                System.out.print("Enter appliance name: ");
                String name = scanner.nextLine();
                searchByName(name);
                break;

            case "2": // Пошук за потужністю
                System.out.print("Enter power (W): ");
                String powerInput = scanner.nextLine();
                Integer power = powerInput.isEmpty() ? null : Integer.parseInt(powerInput);
                searchByPower(power);
                break;

            case "3": // Пошук за виробником
                System.out.print("Enter manufacturer: ");
                String manufacturer = scanner.nextLine();
                searchByManufacturer(manufacturer);
                break;

            case "4": // Пошук за роком виробництва
                System.out.print("Enter year of manufacture: ");
                String yearInput = scanner.nextLine();
                Integer yearOfManufacture = yearInput.isEmpty() ? null : Integer.parseInt(yearInput);
                searchByYearOfManufacture(yearOfManufacture);
                break;

            case "5": // Пошук за статусом увімкнення
                System.out.print("Enter power status (On/Off): ");
                String statusInput = scanner.nextLine();
                Boolean isOn = statusInput.isEmpty() ? null : Boolean.parseBoolean(statusInput);
                searchByPowerStatus(isOn);
                break;

            default:
                System.out.println("Invalid input or no search criteria selected.");
        }
    }

    // Пошук за назвою
    private void searchByName(String name) {
        List<ElectricalAppliance> results = appliances.stream()
                .filter(appliance -> appliance.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

        displayResults(results);
    }

    // Пошук за потужністю
    private void searchByPower(Integer power) {
        List<ElectricalAppliance> results = appliances.stream()
                .filter(appliance -> power == null || appliance.getPower() == power)
                .collect(Collectors.toList());

        displayResults(results);
    }

    // Пошук за виробником
    private void searchByManufacturer(String manufacturer) {
        List<ElectricalAppliance> results = appliances.stream()
                .filter(appliance -> appliance.getManufacturer().toLowerCase().contains(manufacturer.toLowerCase()))
                .collect(Collectors.toList());

        displayResults(results);
    }

    // Пошук за роком виробництва
    private void searchByYearOfManufacture(Integer yearOfManufacture) {
        List<ElectricalAppliance> results = appliances.stream()
                .filter(appliance -> yearOfManufacture == null || appliance.getYearOfManufacture() == yearOfManufacture)
                .collect(Collectors.toList());

        displayResults(results);
    }

    // Пошук за статусом увімкнення
    private void searchByPowerStatus(Boolean isOn) {
        List<ElectricalAppliance> results = appliances.stream()
                .filter(appliance -> isOn == null || appliance.isOn() == isOn)
                .collect(Collectors.toList());

        displayResults(results);
    }

    // Виведення результатів пошуку
    private void displayResults(List<ElectricalAppliance> results) {
        if (results.isEmpty()) {
            System.out.println("No appliances found matching the search criteria.");
        } else {
            System.out.println("Found appliances matching the search criteria:");
            results.forEach(appliance -> {
                System.out.println("Name: " + appliance.getName());
                System.out.println("Power: " + appliance.getPower() + " W");
                System.out.println("Manufacturer: " + appliance.getManufacturer());
                System.out.println("Year of Manufacture: " + appliance.getYearOfManufacture());
                System.out.println("Status: " + (appliance.isOn() ? "On" : "Off"));
                System.out.println("---------------------------------");
            });
        }
    }
}
