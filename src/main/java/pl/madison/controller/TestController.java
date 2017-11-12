package pl.madison.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.madison.domain.Slowo;

import java.util.Map;

@Controller
public class TestController {

    @RequestMapping(value = "/wpiszSlowo")
    public String wpisz(Map<String, Object> model){
        model.put("wpiszS", new Slowo());
        return "wpisz";
    }

    @RequestMapping(value = "/palindrom", method = RequestMethod.POST)
    public String sprawdzamyCzyPalindrom(Slowo slowo, Map<String, Object> model){
        char[] tablicaZnakow = slowo.getWyrazenie().toCharArray();

        int i1=0;
        int i2=tablicaZnakow.length-1;

        boolean czyPalindrom=true;

        while(i2>i1){
            if(tablicaZnakow[i1]!=tablicaZnakow[i2]){
                czyPalindrom=false;
            }
            i1++;
            i2--;
        }

        model.put("sprawdz", czyPalindrom);
        return "palindrom";
    }
}
