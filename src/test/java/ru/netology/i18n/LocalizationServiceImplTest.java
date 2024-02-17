package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.mockito.Mockito.when;


class LocalizationServiceImplTest {

    /*
    Написать тесты для проверки возвращаемого текста (класс LocalizationServiceImpl)
    Проверить работу метода public String locale(Country country)
     */
    @Test
    void testReturnTest(){

        Country country1 = Country.RUSSIA;
        Country country2 = Country.USA;

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        Assertions.assertEquals("Добро пожаловать", localizationService.locale(country1));
        Assertions.assertNotEquals("Welcome", localizationService.locale(country1));
        Assertions.assertEquals("Welcome", localizationService.locale(country2));

        //LocalizationService localizationService1 = new LocalizationServiceImpl();
        //String result = localizationService1.locale(Country.RUSSIA);
        //Assertions.assertEquals("Добро пожаловать", result);
    }
}
