package Theme02.Task0;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Лада", "седан"));
        cars.add(new Car("Лада", "хэтчбек"));
        cars.add(new Car("Мерседес", "седан"));
        cars.add(new Car("БМВ", "кроссовер"));
        cars.add(new Car("Форд", "хэтчбек"));
        cars.add(new Car("Пежо", "кроссовер"));
        cars.add(new Car("Тойота", "седан"));
        cars.add(new Car("Нисан", "седан"));
        cars.add(new Car("Фольцваген", "кроссовер"));

        List<Car> sedans = new ArrayList<>();
        List<Car> hatchbacks = new ArrayList<>();
        List<Car> crossovers = new ArrayList<>();

        for (Car car : cars) {
            String type = car.getType();
            switch (type) {
                case "седан":
                    sedans.add(car);
                    break;
                case "хэтчбек":
                    hatchbacks.add(car);
                    break;
                case "кроссовер":
                    crossovers.add(car);
                    break;
            }
        }
        System.out.println("Седаны: " + sedans);
        System.out.println("Хетчбеки: " + hatchbacks);
        System.out.println("Кроссоверы: " + crossovers);
    }
}
