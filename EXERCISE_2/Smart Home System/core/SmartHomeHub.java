package core;

import devices.*;
import factory.*;
import java.util.*;

public class SmartHomeHub {
    private final Map<Integer, Device> devices = new HashMap<>();
    private final List<Schedule> schedules = new ArrayList<>();
    private final List<Trigger> triggers = new ArrayList<>();
    private final List<String> logs = new ArrayList<>();
    private final Map<String, DeviceGroup> groups = new HashMap<>();

    // --- Device Management ---
    public void addDevice(int deviceId, String type, Scanner scanner) {
        if (devices.containsKey(deviceId)) {
            System.out.println("Device with ID " + deviceId + " already exists.");
            return;
        }

        Device newDevice = null;
        switch (type.toLowerCase()) {
            case "light":
                System.out.print("Enter status (on/off): ");
                boolean status = scanner.nextLine().trim().equalsIgnoreCase("on");
                newDevice = DeviceFactory.createDevice("light", deviceId, status);
                break;
            case "door":
                System.out.print("Enter status (locked/unlocked): ");
                boolean locked = scanner.nextLine().trim().equalsIgnoreCase("locked");
                newDevice = DeviceFactory.createDevice("door", deviceId, locked);
                break;
            case "thermostat":
                System.out.print("Enter temperature: ");
                int temp = Integer.parseInt(scanner.nextLine());
                newDevice = DeviceFactory.createDevice("thermostat", deviceId, temp);
                break;
            default: System.out.println("Invalid device type."); return;
        }

        DeviceProxy proxy = new DeviceProxy(newDevice);
        devices.put(deviceId, proxy);
        logs.add("Device " + type + " " + deviceId + " added.");
        System.out.println("Device added successfully.");
    }

    public void removeDevice(int deviceId) {
        Device removed = devices.remove(deviceId);
        if (removed != null) {
            logs.add("Device " + removed.getType() + " " + deviceId + " removed.");
            System.out.println("Device removed successfully.");
        } else System.out.println("No device found with ID " + deviceId);
    }

    public void turnOnDevice(int deviceId) {
        Device d = devices.get(deviceId);
        if (d != null) { d.turnOn(); logs.add(d.getType() + " " + deviceId + " turned ON."); }
        else System.out.println("No device found with ID " + deviceId);
    }

    public void turnOffDevice(int deviceId) {
        Device d = devices.get(deviceId);
        if (d != null) { d.turnOff(); logs.add(d.getType() + " " + deviceId + " turned OFF."); }
        else System.out.println("No device found with ID " + deviceId);
    }

    public void addSchedule(int deviceId, String time, String command) {
        if (devices.containsKey(deviceId)) {
            schedules.add(new Schedule(deviceId, time, command));
            logs.add("Schedule added for device " + deviceId + ": " + command + " at " + time);
        } else System.out.println("No device found with ID " + deviceId);
    }

    public void addTrigger(String condition, String action) {
        triggers.add(new Trigger(condition, action));
        logs.add("Trigger added: " + condition + " -> " + action);
    }

    public void createGroup(String groupName, List<Integer> deviceIds) {
        DeviceGroup group = new DeviceGroup(groupName);
        for (int id : deviceIds) {
            if (devices.containsKey(id)) group.addDevice(id);
        }
        groups.put(groupName, group);
        logs.add("Group '" + groupName + "' created with devices " + group.getDeviceIds());
        System.out.println("Group '" + groupName + "' created.");
    }

    public void controlGroup(String groupName, boolean turnOn) {
        DeviceGroup group = groups.get(groupName);
        if (group == null) { System.out.println("No group named " + groupName); return; }
        for (int id : group.getDeviceIds()) { if (turnOn) turnOnDevice(id); else turnOffDevice(id); }
    }

    // --- Display ---
    public void showDeviceStatus() { devices.values().forEach(d -> System.out.println(d.getStatusDescription())); }
    public void showSchedules() { schedules.forEach(System.out::println); }
    public void showTriggers() { triggers.forEach(System.out::println); }
    public void showLogs() { logs.forEach(System.out::println); }
    public boolean hasDevices() { return !devices.isEmpty(); }
}
