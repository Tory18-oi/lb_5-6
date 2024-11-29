package Main;

import PatternCommand.Command;

// Клас MenuManager викликає виконання команд
public class MenuManager {
    public void runCommand(Command command) {
        command.execute();
    }
}
