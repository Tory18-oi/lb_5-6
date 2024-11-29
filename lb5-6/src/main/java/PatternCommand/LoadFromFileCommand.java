package PatternCommand;

import Appliance.ElectricalAppliance;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LoadFromFileCommand implements Command {
    private final ArrayList<ElectricalAppliance> appliances;

    public LoadFromFileCommand(ArrayList<ElectricalAppliance> appliances) {
        this.appliances = appliances;
    }



    @Override
    public void execute() {
        String filename = "C:\\Users\\User\\Desktop\\electricalappliances.ser";

        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            // Завантажуємо список приладів з файлу
            ArrayList<ElectricalAppliance> loadedAppliances = (ArrayList<ElectricalAppliance>) in.readObject();
            appliances.clear();  // Очищаємо поточний список приладів
            appliances.addAll(loadedAppliances);  // Додаємо завантажені прилади

            System.out.println("Appliances successfully loaded from file \"" + filename + "\".");

            // Виводимо всі завантажені прилади
            if (!appliances.isEmpty()) {
                System.out.println("Loaded Appliances:");
                for (ElectricalAppliance appliance : appliances) {
                    System.out.println(appliance);  // Має бути реалізований метод toString() у класі ElectricalAppliance для коректного виведення
                }
            } else {
                System.out.println("No appliances loaded from the file.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while loading the file: " + e.getMessage());
        }

    }
}