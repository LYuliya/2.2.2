package web.DAO;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class CarDaoImpl implements CarDao{
    protected static final List<Car> carList = Arrays.asList(
            new Car("Bentley", 7, "Red" ),
            new Car("BMW", 3, "Black" ),
            new Car("Lada", 14, "White" ),
            new Car("Ferrari", 5,"Green" ),
            new Car("UAZ", 4, "Orange")
    );

    @Override
    public List<Car> getCars(int count) {
        if (count >= 5) {
            return carList;
        }
        return carList.stream().limit(count).toList();
    }


}
