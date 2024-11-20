package dto;

public class DvD {
    private String title;
    private String releaseDate;
    private String rating;
    private String directorName;
    private String studio;
    private String personalRating;

    public DvD(String title){
        this.title = title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public void setRating(String rating){
        this.rating = rating;
    }
    public void setDirectorName(String directorName){
        this.directorName = directorName;
    }
    public void setStudio(String studio){
        this.studio = studio;
    }
    public void setPersonalRating(String personalRating){
        this.personalRating = personalRating;
    }

    public String getTitle() {
        return title;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getPersonalRating() {
        return personalRating;
    }

    public String getRating() {
        return rating;
    }

    public String getStudio() {
        return studio;
    }
}
