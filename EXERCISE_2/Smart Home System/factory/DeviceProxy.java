package factory;

import devices.Device;

public class DeviceProxy extends Device {
    private final Device realDevice;

    public DeviceProxy(Device realDevice) {
        super(realDevice.getId(), realDevice.getType(), realDevice.isOn());
        this.realDevice = realDevice;
    }

    @Override public void turnOn() { realDevice.turnOn(); }
    @Override public void turnOff() { realDevice.turnOff(); }
    @Override public String getStatusDescription() { return realDevice.getStatusDescription(); }
    @Override public void update() { realDevice.update(); }
}
