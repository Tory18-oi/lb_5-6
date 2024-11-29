package Appliance;
import java.io.Serializable;

public class ElectricalAppliance implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;              // Назва приладу
    private int power;                 // Потужність у ватах (Вт)
    private String manufacturer;       // Виробник приладу
    private boolean isOn;              // Стан приладу: увімкнений/вимкнений
    private int yearOfManufacture;     // Рік виготовлення
    private int usageHours;            // Час роботи в годинах
    private double energyRate;         // Тариф на електроенергію в грн/кВт·год

    // Конструктор з основними параметрами
    public ElectricalAppliance(String name, int power, String manufacturer, boolean isOn, int yearOfManufacture, int usageHours, double energyRate) {
        this.name = name;
        this.power = power;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.energyRate = energyRate;
        this.isOn = false;   // За замовчуванням прилад вимкнений
        this.usageHours = 0; // Початково немає годин роботи
    }

    // Геттери та сеттери для доступу до параметрів
    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void powerOn() {
        this.isOn = true;  // Увімкнути прилад
    }

    public void powerOff() {
        this.isOn = false;  // Вимкнути прилад
    }

    public boolean isOn() {
        return isOn;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }


    public int getUsageHours() {
        return usageHours;
    }

    public double getEnergyRate() {
        return energyRate;
    }

    public void setUsageHours(int usageHours) {
        this.usageHours = usageHours;
    }

    public void togglePower() {
        isOn = !isOn;
    }

    // Метод для розрахунку споживання електроенергії (кВт·год)
    public double calculateEnergyConsumption() {
        return (power / 1000.0) * usageHours;
    }

    // Метод для розрахунку вартості використання приладу
    public double calculateEnergyCost() {
        return calculateEnergyConsumption() * energyRate;
    }

    @Override
    public String toString() {
        return "ElectricalAppliance{" +
                "name='" + name + '\'' +
                ", power=" + power +
                "W, manufacturer='" + manufacturer + '\'' +
                ", isOn=" + isOn +
                ", yearOfManufacture=" + yearOfManufacture +
                ", usageHours=" + usageHours +
                " hours, energyRate=" + energyRate + " per kWh" +
                '}';
    }
}
