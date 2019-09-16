package javacourse;

import java.util.Arrays;
import java.util.List;

import javacourse.PathFinder;

public class Main {

    // инициализация транспорта
    private static Transport GAZelle = new Transport("Газель", 1, 1, RouteType.Road);
    private static Transport Plane = new Transport("Самолет", 20, 50, RouteType.Air);
    private static Transport Tanker = new Transport("Танкер", 200, 100, RouteType.Sea);
    private static Transport Train = new Transport("Поезд", 100, 10, RouteType.Railway);
    private static Transport SemiTrailerTruck = new Transport("Фура", 5, 2, RouteType.Road);

    static private List<Transport> getAvailableTransport() {
        return Arrays.asList(GAZelle, Plane, Tanker, Train, SemiTrailerTruck);
    }

    // инициализируем задания по доставке
    static DeliveryTask bread = new DeliveryTask(
            "Хлеб",
            Arrays.asList(
                    new Route(RouteType.Air, 50),
                    new Route(RouteType.Road, 100),
                    new Route(RouteType.Railway, 70)
            ),
            1
    );
    static DeliveryTask kingKong = new DeliveryTask(
            "Кинг-Конг",
            Arrays.asList(
                    new Route(RouteType.Air, 2000),
                    new Route(RouteType.Sea, 2500)
            ),
            150
    );


    static DeliveryTask cars = new DeliveryTask(
            "Автомобили",
            Arrays.asList(
                    new Route(RouteType.Air, 2000),
                    new Route(RouteType.Sea, 2500),
                    new Route(RouteType.Road, 4000),
                    new Route(RouteType.Railway, 3000)
            ),
            100);

    static DeliveryTask phones = new DeliveryTask(
            "Смартфоны",
            Arrays.asList(
                    new Route(RouteType.Air, 2000),
                    new Route(RouteType.Sea, 2500),
                    new Route(RouteType.Road, 4000)
            ),
            20
    );

    static DeliveryTask apples = new DeliveryTask(
            "Яблоки",
            Arrays.asList(
                    new Route(RouteType.Road, 1000),
                    new Route(RouteType.Air, 700)
            ),
            5
    );

    // в методе main проверяем корректность работы
    public static void main(String[] args) {
        System.out.println("Для товара: " + kingKong.getName() + " лучшая доставка: " + PathFinder.getOptimalTransport(kingKong, getAvailableTransport()).getName());


        System.out.println("Для товара: " + bread.getName() + " лучшая доставка: " + PathFinder.getOptimalTransport(bread, getAvailableTransport()).getName());


        System.out.println("Для товара: " + phones.getName() + " лучшая доставка: " + PathFinder.getOptimalTransport(phones, getAvailableTransport()).getName());


        System.out.println("Для товара: " + apples.getName() + " лучшая доставка: " + PathFinder.getOptimalTransport(apples, getAvailableTransport()).getName());


        System.out.println("Для товара: " + cars.getName() + " лучшая доставка: " + PathFinder.getOptimalTransport(cars, getAvailableTransport()).getName());

    }
}
