package PatternCommand;

import Appliance.ElectricalAppliance;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveToFileCommand implements Command {
    private final ArrayList<ElectricalAppliance> appliances;

    public SaveToFileCommand(ArrayList<ElectricalAppliance> appliances) {
        this.appliances = appliances;
    }

    @Override
    public void execute() {
        String filename = "C:\\Users\\User\\Desktop\\electricalappliances.ser";


        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(appliances);
            System.out.println("Appliances successfully saved to file \"" + filename + "\".");
        } catch (IOException e) {
            System.out.println("Error while saving the file: " + e.getMessage());
        }
    }
}
