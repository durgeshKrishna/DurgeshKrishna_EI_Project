package devices;

public abstract class Device implements DeviceObserver {
    private final int id;
    private final String type;
    private boolean isOn;

    public Device(int id, String type, boolean isOn) {
        this.id = id;
        this.type = type;
        this.isOn = isOn;
    }

    public int getId() { return id; }
    public String getType() { return type; }
    public boolean isOn() { return isOn; }

    public void turnOn() { isOn = true; }
    public void turnOff() { isOn = false; }

    public abstract String getStatusDescription();

    @Override
    public void update() {
        System.out.println(getType() + " " + id + " notified of system change.");
    }
}
