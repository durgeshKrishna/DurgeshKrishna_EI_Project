package devices;

public class DoorLock extends Device {
    public DoorLock(int id, boolean isLocked) {
        super(id, "Door", isLocked);
    }

    @Override
    public String getStatusDescription() {
        return "Door " + (isOn() ? "Locked" : "Unlocked") + ".";
    }
}
