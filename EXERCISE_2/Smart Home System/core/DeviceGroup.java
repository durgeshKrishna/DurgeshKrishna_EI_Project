package core;

import java.util.*;

public class DeviceGroup {
    private final String groupName;
    private final List<Integer> deviceIds = new ArrayList<>();

    public DeviceGroup(String groupName) { this.groupName = groupName; }
    public String getGroupName() { return groupName; }
    public List<Integer> getDeviceIds() { return deviceIds; }
    public void addDevice(int deviceId) { deviceIds.add(deviceId); }
}
