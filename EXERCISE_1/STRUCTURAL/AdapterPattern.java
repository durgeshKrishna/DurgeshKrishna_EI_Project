import java.util.ArrayList;
import java.util.List;

interface Car {
    String getName();
    String getBrand();
    int getPrice();
}

class IndianCar implements Car {
    private String name;
    private String brand;
    private int price;

    public IndianCar(String name, String brand, int price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getBrand() { return brand; }

    @Override
    public int getPrice() { return price; }
}

class ForeignCar {
    private String carName;
    private String carBrand;
    private int brandPrice;

    public ForeignCar(String carName, String carBrand, int brandPrice) {
        this.carName = carName;
        this.carBrand = carBrand;
        this.brandPrice = brandPrice;
    }

    public String getCarName() { return carName; }
    public String getCarBrand() { return carBrand; }
    public int getBrandPrice() { return brandPrice; }
}

class ForeignCarAdapter implements Car {
    private ForeignCar foreignCar;

    public ForeignCarAdapter(ForeignCar foreignCar) {
        this.foreignCar = foreignCar;
    }

    @Override
    public String getName() { return foreignCar.getCarName(); }

    @Override
    public String getBrand() { return foreignCar.getCarBrand(); }

    @Override
    public int getPrice() { return foreignCar.getBrandPrice(); }
}

class CarDealerClient {
    public List<Car> getCarList() {
        List<Car> carList = new ArrayList<>();
        carList.add(new IndianCar("Punch", "Tata", 1000000));
        carList.add(new ForeignCarAdapter(new ForeignCar("Spectre", "Rolls Royce", 10000000)));
        return carList;
    }
}

public class AdapterPattern{
    public static void main(String[] args) {
        CarDealerClient client = new CarDealerClient();
        List<Car> cars = client.getCarList();
        System.out.println("=== Car List ===");
        for (Car car : cars) {
            System.out.println(car.getName() + " -> " + car.getBrand() + " -> Rs " + car.getPrice());
        }
    }
}
