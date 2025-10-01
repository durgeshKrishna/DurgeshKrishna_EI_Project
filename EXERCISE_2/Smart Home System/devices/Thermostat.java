package devices;

public class Thermostat extends Device {
    private int temperature;

    public Thermostat(int id, int temperature) {
        super(id, "Thermostat", true);
        this.temperature = temperature;
    }

    public int getTemperature() { return temperature; }
    public void setTemperature(int temperature) { this.temperature = temperature; }

    @Override
    public String getStatusDescription() {
        return "Thermostat is set to " + temperature + " degrees.";
    }

    @Override
    public void update() {
        super.update();
        if (temperature > 75) {
            System.out.println("Thermostat > 75 detected. Lights may turn off automatically if triggered.");
        }
    }
}
