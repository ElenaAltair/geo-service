package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;


import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;


class MessageSenderImplTest {

    /*
    Поверить, что MessageSenderImpl всегда отправляет только русский текст,
    если ip относится к российскому сегменту адресов
     */
    @Test
    void testLanguageRus(){
        String ip = "172.11";
        if(ip.startsWith("172.")) ip = "172.";


        Location location = Mockito.mock(Location.class);
        when(location.getCountry()).thenReturn(Country.RUSSIA);
        //
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        when(geoService.byIp("172.")).thenReturn(location);

        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        when(localizationService.locale(Country.RUSSIA)).thenReturn(" Добро пожаловать ");
        when(localizationService.locale(Country.USA)).thenReturn(" Welcome ");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("x-real-ip", ip);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Assertions.assertEquals(" Добро пожаловать ", messageSender.send(headers));
    }

    /*
    Поверить, что MessageSenderImpl всегда отправляет только английский текст,
    если ip относится к американскому сегменту адресов.
     */
    @Test
    void testLanguageEng(){
        String ip = "96.44.183.149";
        if(ip.startsWith("96.")) ip = "96.";


        Location location = Mockito.mock(Location.class);
        when(location.getCountry()).thenReturn(Country.USA);
        //
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        when(geoService.byIp("96.")).thenReturn(location);

        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        when(localizationService.locale(Country.RUSSIA)).thenReturn(" Добро пожаловать ");
        when(localizationService.locale(Country.USA)).thenReturn(" Welcome ");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("x-real-ip", ip);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Assertions.assertEquals( " Welcome ", messageSender.send(headers));
    }
}
