package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.mockito.Mockito.when;

class GeoServiceImplTest {
    /*
    Написать тесты для проверки определения локации по ip (класс GeoServiceImpl)
    Проверить работу метода public Location byIp(String ip)
     */
    @Test
    void testLocationIp() {
        String ip = "172.";
        GeoServiceImpl geoService2 = new GeoServiceImpl();
        Location location3 = Mockito.mock(Location.class);
        when(location3.getCountry()).thenReturn(geoService2.byIp(ip).getCountry());
        when(location3.getCity()).thenReturn(geoService2.byIp(ip).getCity());
        Assertions.assertEquals("Moscow", location3.getCity());
    }

}
