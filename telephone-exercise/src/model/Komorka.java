package model;

import java.util.List;

public class Komorka extends Telefon {
    private List<String> historiaPolaczen;

    public Komorka(String interfejsKomunikacyjny, Color color, List<String> historiaPolaczen) {
        super(interfejsKomunikacyjny, color);
        this.historiaPolaczen = historiaPolaczen;
    }

    @Override
    public void wyswietlHistoriePolaczen() {
        historiaPolaczen.forEach(System.out::println);
    }

    public List<String> getHistoriaPolaczen() {
        return historiaPolaczen;
    }
}