import core.SmartHomeHub;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        SmartHomeHub hub = new SmartHomeHub();
        Scanner scanner = new Scanner(System.in);
        boolean running=true;
        while (running) {
            System.out.println("\nMenu:\n1.Add Device\n2.Remove Device\n3.Turn On Device\n4.Turn Off Device\n5.Set Schedule\n6.Add Trigger\n7.Show Status\n8.Show Schedules\n9.Show Triggers\n10.Show Logs\n11.Create Device Group\n12.Control Device Group\n13.Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter ID: "); int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter type (light/door/thermostat): "); String type = scanner.nextLine();
                        hub.addDevice(id, type, scanner); break;
                    case "2":
                        System.out.print("Enter ID: "); hub.removeDevice(Integer.parseInt(scanner.nextLine())); break;
                    case "3":
                        System.out.print("Enter ID: "); hub.turnOnDevice(Integer.parseInt(scanner.nextLine())); break;
                    case "4":
                        System.out.print("Enter ID: "); hub.turnOffDevice(Integer.parseInt(scanner.nextLine())); break;
                    case "5":
                        System.out.print("Enter device ID: "); int sId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter time: "); String time = scanner.nextLine();
                        System.out.print("Enter command: "); String cmd = scanner.nextLine();
                        hub.addSchedule(sId, time, cmd); break;
                    case "6":
                        System.out.print("Enter condition: "); String cond = scanner.nextLine();
                        System.out.print("Enter action: "); String act = scanner.nextLine();
                        hub.addTrigger(cond, act); break;
                    case "7": hub.showDeviceStatus(); break;
                    case "8": hub.showSchedules(); break;
                    case "9": hub.showTriggers(); break;
                    case "10": hub.showLogs(); break;
                    case "11":
                        System.out.print("Enter group name: "); String gName = scanner.nextLine();
                        System.out.print("Enter device IDs (comma-separated): "); String[] ids = scanner.nextLine().split(",");
                        List<Integer> listIds = new ArrayList<>();
                        for (String s : ids) { try { listIds.add(Integer.parseInt(s.trim())); } catch(Exception e){} }
                        hub.createGroup(gName, listIds); break;
                    case "12":
                        System.out.print("Enter group name: "); String grp = scanner.nextLine();
                        System.out.print("Turn ON or OFF? "); String onOff = scanner.nextLine();
                        hub.controlGroup(grp, onOff.equalsIgnoreCase("on")); break;
                    case "13": 
                        System.out.println("Exiting."); 
                        running=false;
                        scanner.close(); 
                        return;
                    default: System.out.println("Invalid choice.");
                }
            } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
        }
    }
}
