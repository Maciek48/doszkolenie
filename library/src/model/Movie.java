package model;

public class Movie {
    private final String title, director;
    private final int timeInMinutes;
    private boolean isAvailable;
    private static int counterMovie;

    public Movie(String title, String director, int timeInMinutes) {
        this.title = title;
        this.director = director;
        this.timeInMinutes = timeInMinutes;
        isAvailable = true;
        counterMovie++;
    }

    public static int getCounterMovie() {
        return counterMovie;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}