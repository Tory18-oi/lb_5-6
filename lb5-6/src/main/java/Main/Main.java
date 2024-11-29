package Main;

import Appliance.ElectricalAppliance;
import PatternCommand.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private final Map<Integer, Command> commandMap;  // для зберігання команд з індексами
    private final ArrayList<String> commandNames;    // для зберігання назв команд
    private final ArrayList<ElectricalAppliance> appliances; // головний список приладів

    public Main() {
        appliances = new ArrayList<>();
        commandMap = initializeCommands();
        commandNames = initializeCommandNames();
        menu();
    }

    private Map<Integer, Command> initializeCommands() {
        Map<Integer, Command> commands = new HashMap<>();

        // Ініціалізація команд та додавання їх до мапи з числовими ключами
        commands.put(1, new AddApplianceCommand(appliances));
        commands.put(2, new RemoveApplianceCommand(appliances));
        commands.put(3, new PowerOnCommand(appliances));
        commands.put(4, new PowerOffCommand(appliances));
        commands.put(5, new SortByPowerCommand(appliances));
        commands.put(6, new FindByParametersCommand(appliances));
        commands.put(7, new CalculatePowerUsageCommand(appliances));
        commands.put(8, new CalculateEnergyCostCommand(appliances));
        commands.put(9, new DisplayApplianceListCommand(appliances));
        commands.put(10, new SaveToFileCommand(appliances)); // Додаємо команду збереження
        commands.put(11, new LoadFromFileCommand(appliances));


        return commands;
    }

    private ArrayList<String> initializeCommandNames() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Add Appliance");
        names.add("Remove Appliance");
        names.add("Power On Appliance");
        names.add("Power Off Appliance");
        names.add("Sort Appliances by Power");
        names.add("Find Appliance by Parameters");
        names.add("Calculate Power Usage");
        names.add("Calculate Energy Cost");
        names.add("Display Appliance List");
        names.add("Save Appliances to File"); // Назва для команди збереження
        names.add("Load Appliances from File");
        // Назва для команди завантаження

        return names;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\t\t----- Electrical Appliance Management Menu -----");
            System.out.println("Available Commands:");

            // Виведення команд з числовими індексами для вибору
            for (var element : commandMap.entrySet()){
                System.out.println(element.getKey() + ". " + element.getValue().getDesc());
            }
            for (int i = 0; i < commandNames.size(); i++) {
                System.out.println((i + 1) + ". " + commandNames.get(i));
            }
            System.out.println((commandNames.size() + 1) + ". Exit");

            System.out.print("Enter the command number to execute: ");
            int choice = scanner.nextInt();

            if (choice == commandNames.size() + 1) {  // Перевірка, чи вибрано вихід
                System.out.println("Exiting program...");
                break;
            }

            Command command = commandMap.get(choice);  // Отримуємо команду за номером

            if (command != null) {
                new MenuManager().runCommand(command);  // Виконання команди
            } else {
                System.out.println("Invalid command number. Please try again.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new Main(); // Прямо ініціалізує команди і відкриває меню
    }
}
