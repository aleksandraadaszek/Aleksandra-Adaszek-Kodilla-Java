package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Weather Forecast Test Suite")
public class WeatherForecastTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of all tests");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished");
    }

    @BeforeEach
    public static void beforeEachTest() {
        testCounter ++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Mock
    private Temperatures temperaturesMock;

    @Test
    void testCalculateForecastWithMock() {
        //Given
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszów", 25.5);
        temperaturesMap.put("Kraków", 26.2);
        temperaturesMap.put("Wrocław", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdańsk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5,quantityOfSensors);

    }
    @Test
    //Test sprawdzający czy średnia temperatura została wyliczona poprawnie
    void testCalculateAverageTemperature() {
        //Given
        Map<String, Double> theTemperatures = new HashMap<>();
        theTemperatures.put("Żywiec", 23.3);
        theTemperatures.put("Zakopane", 16.1);
        theTemperatures.put("Piotrków Trybunalski", 28.0);
        theTemperatures.put("Koszalin", 27.7);
        when(temperaturesMock.getTemperatures()).thenReturn(theTemperatures);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        List<Double> retrievedForecast = weatherForecast.calculateAverageTemperature();

        //Then
        Assertions.assertEquals(23.775,retrievedForecast);
    }
    @Test
    //Test sprawdzający czy liczba pomiarów temperatury przekazana przez mock jest taka sama jak ta pobrana z klasy WeatherForecast
    void testInputNumber () {
        //Given
        Map<String, Double> theInput = new HashMap<>();
        theInput.put("Busko-Zdrój", 34.4);
        theInput.put("Malbork", 38.9);
        theInput.put("Łódź", 29.9);
        theInput.put("Katowice", 27.8);
        theInput.put("Warszawa", 31.2);
        theInput.put("Bydgoszcz", 34.5);
        when(temperaturesMock.getTemperatures()).thenReturn(theInput);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int theInputSize = weatherForecast.calculateAverageTemperature().size();

        //Then
        Assertions.assertEquals(6,theInputSize);
    }

    @Test
    //Test sprawdzający czy mediana temperatur została wyliczona poprawnie
    void testMedianCalculation () {
        //Given
        Map<String, Double> availableTemperatures = new HashMap<>();
        availableTemperatures.put("Skierniewice", 23.3);
        availableTemperatures.put("Busko-Zdrój", 28.7);
        availableTemperatures.put("Krynica", 34.1);
        availableTemperatures.put("Bydgoszcz", 27.9);
        availableTemperatures.put("Piotrków Trybunalski", 28.2);
        availableTemperatures.put("Wieluń", 33.3);
        when(temperaturesMock.getTemperatures()).thenReturn(availableTemperatures);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double retrievedMedian = weatherForecast.medianFinder();

        //Then
        Assertions.assertEquals(42.55,retrievedMedian);
    }
}
