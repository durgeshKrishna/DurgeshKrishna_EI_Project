package devices;

public class Light extends Device {
    public Light(int id, boolean isOn) {
        super(id, "Light", isOn);
    }

    @Override
    public String getStatusDescription() {
        return "Light " + getId() + " is " + (isOn() ? "On" : "Off") + ".";
    }
}
