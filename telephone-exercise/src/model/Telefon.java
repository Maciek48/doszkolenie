package model;

public class Telefon {
    private final String interfejsKomunikacyjny;
    private final Color color;

    public Telefon(String interfejsKomunikacyjny, Color color) {
        this.interfejsKomunikacyjny = interfejsKomunikacyjny;
        this.color = color;
    }

    public void zadzwon(String numer) {
        System.out.printf("Dzwonisz pod numer: %s%n", numer);
    }

    public void wyswietlHistoriePolaczen() {
        System.out.println("Brak historii");
    }
}