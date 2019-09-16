package javacourse;

import javacourse.DeliveryTask;
import javacourse.Transport;

import java.util.List;

public class PathFinder {

    public static Transport getOptimalTransport(DeliveryTask deliveryTask, List<Transport> transports) {

        Transport temp = null; //создаем переменную для транспорта
        int betterPrice = -1; //начальное значение
        for (int i = 0; i < transports.size(); i++) { //для каждого транспорта
            for (int j = 0; j < deliveryTask.getRoutes().size(); j++) { //проверяем все типы доставки
                if (transports.get(i).getType() != deliveryTask.getRoutes().get(j).getType()) //если тип не подходит, то пропускаем
                    continue;
                if (deliveryTask.getVolume() > transports.get(i).getVolume()) //если объем больше доступного, то пропускаем
                    continue;
                int price = (int) (deliveryTask.getRoutes().get(j).getLength() * transports.get(i).getPrice()); //высчитываем стоимость доставки
                if (price < betterPrice || betterPrice == -1) { //если стоимость лучше предыдущей(или предыдущая не инициализирована)
                    betterPrice = price; //записываем новую лучшую стоимость
                    temp = transports.get(i); //записываем лучший транспорт
                }
            }
        }
        return temp;
    }

}
