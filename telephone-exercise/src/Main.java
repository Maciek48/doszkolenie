import model.Color;
import model.Komorka;
import model.Osoba;
import model.Smartfon;
import model.Telefon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Osoba> znajomi = List.of(
                new Osoba("Jan", "Kowalski", "123-456-789"),
                new Osoba("Anna", "Nowak", "987-654-321"),
                new Osoba("Piotr", "Zieliński", "111-222-333"),
                new Osoba("Kasia", "Wiśniewska", "222-333-444"),
                new Osoba("Tomek", "Lewandowski", "333-444-555")
        );

        List<String> h1 = new ArrayList<>();
        List<String> h2 = new ArrayList<>();

        Telefon t1 = new Telefon("GSM", Color.BLACK);
        Komorka t2 = new Komorka("LTE", Color.SILVER, h1);
        Smartfon t3 = new Smartfon("5G", Color.GOLD, h2, znajomi);

        Telefon[] telefony = new Telefon[]{t1, t2, t3};
        List<String> numeryObce = Arrays.asList(
                "700-111-222",
                "700-333-444",
                "700-555-666",
                "800-111-111",
                "900-999-999"
        );

        for (Telefon tel : telefony) {
            for (int i = 0; i < 10; i++) {
                String numer;
                if (i % 2 == 0) {
                    numer = znajomi.get(i % znajomi.size()).getNumer();
                } else {
                    numer = numeryObce.get(i % numeryObce.size());
                }
                tel.zadzwon(numer);
                if (tel instanceof Komorka komorka) {
                    komorka.getHistoriaPolaczen().add(numer);
                }
            }
            System.out.println();
        }

        System.out.println("===== HISTORIA POŁĄCZEŃ =====");
        for (Telefon tel : telefony) {
            System.out.println("\n--- " + tel.getClass().getSimpleName() + " ---");
            tel.wyswietlHistoriePolaczen();
        }
    }
}