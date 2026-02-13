package model;

import java.util.List;

public class Smartfon extends Komorka {
    private List<Osoba> znajomi;

    public Smartfon(String interfejsKomunikacyjny, Color color, List<String> historiaPolaczen, List<Osoba> znajomi) {
        super(interfejsKomunikacyjny, color, historiaPolaczen);
        this.znajomi = znajomi;
    }

    @Override
    public void wyswietlHistoriePolaczen() {
        getHistoriaPolaczen().forEach(numer -> {
            znajomi.stream()
                    .filter(osoba -> osoba.getNumer().equals(numer))
                    .findFirst()
                    .ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println(numer)
                    );
        });
    }
}