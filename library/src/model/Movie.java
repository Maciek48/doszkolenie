package model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return timeInMinutes == movie.timeInMinutes && isAvailable == movie.isAvailable && Objects.equals(title, movie.title) && Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, director, timeInMinutes, isAvailable);
    }
}