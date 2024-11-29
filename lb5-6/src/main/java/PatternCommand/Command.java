package PatternCommand;

// Інтерфейс Command для визначення методу execute()
public interface Command {
    void execute();
    default String getDesc(){
        return "";
    }
}
