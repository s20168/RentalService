package pl.pjatk.rentalservice.Model;

public class Movie {

    private Long id;
    private String title;
    private Genre genre;
    private boolean available;

    public Movie(Long id, String title, Genre genre, boolean available) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.available = available;
    }

    public Movie(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
