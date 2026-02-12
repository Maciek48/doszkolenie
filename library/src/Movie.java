public class Movie {
    private String title, director;
    private int timeInMinutes;

    public Movie(String title, String director, int timeInMinutes) {
        this.title = title;
        this.director = director;
        this.timeInMinutes = timeInMinutes;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getTimeInMinutes() {
        return timeInMinutes;
    }

    public void setTimeInMinutes(int timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }
}
