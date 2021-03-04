import core.Line;
import core.Station;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Тест расчета маршрута")
public class RouteCalculatorTests {

    List<Station> route;

    @BeforeEach
    void setUp() {
        route = new ArrayList<>();

        Line line1 = new Line(5, "Фрунзенско-Приморская");
        Line line2 = new Line(2, "Московско-Петроградская");
        Line line3 = new Line(3, "Невско-Василеостровская");

        route.add(new Station("Адмиралтейская", line1));
        route.add(new Station("Садовая", line1));
        route.add(new Station("Сенная площадь", line2));
        route.add(new Station("Невский проспект", line2));
        route.add(new Station("Гостиный двор", line3));
        route.add(new Station("Василеостровская", line3));
    }

    @DisplayName("Список не пустой")
    @Test
    void testGetShortestRoute() {
        assertNotNull(route);
    }

    @DisplayName("Время в пути")
    @Test
    void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 14.5;
        assertEquals(expected, actual);
    }

    @AfterEach
    void tearDown() {
    }
}
// ==============================================================================================
//    @Override
//    protected void setUp() throws Exception {
//        super.setUp();
//
//        Line line1 = new Line(5, "Фрунзенско-Приморская");
//        Line line2 = new Line(2, "Московско-Петроградская");
//        Line line3 = new Line(3, "Невско-Василеостровская");
//
//        route.add(new Station("Адмиралтейская", line1));
//        route.add(new Station("Садовая", line1));
//        route.add(new Station("Сенная площадь", line2));
//        route.add(new Station("Невский проспект", line2));
//        route.add(new Station("Гостиный двор", line3));
//        route.add(new Station("Василеостровская", line3));
//    }
//
//    public void testGetShortestRoute() {
//        assertNotNull("Список не пустой", route);
//    }
//
//    public void testCalculateDuration() {
//        double actual = RouteCalculator.calculateDuration(route);
//        double expected = 14.5;
//        assertEquals(expected, actual);
//    }
//
//    @Override
//    protected void tearDown() throws Exception {
//        super.tearDown();
//    }

