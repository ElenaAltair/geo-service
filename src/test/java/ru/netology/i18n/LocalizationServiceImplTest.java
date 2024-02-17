package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class LocalizationServiceImplTest {

    /*
    Написать тесты для проверки возвращаемого текста (класс LocalizationServiceImpl)
    Проверить работу метода public String locale(Country country)
     */
    @Test
    void testReturnTest(){

        Country country = Country.RUSSIA;
        
        Location location = Mockito.mock(Location.class);
        when(location.getCountry()).thenReturn(country);

        LocalizationService localizationService1 = new LocalizationServiceImpl();
        String result = localizationService1.locale(location.getCountry());
        Assertions.assertEquals("Добро пожаловать", result);
    }
}
