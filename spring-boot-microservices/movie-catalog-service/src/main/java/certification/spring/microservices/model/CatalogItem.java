package certification.spring.microservices.model;

public class CatalogItem {

    private String catalogId;
    private String userId;
    private String rating;
    
    private Movie movie;

    public CatalogItem() {}
    
    public CatalogItem(String catalogId, String userId, String rating, Movie movie) {
        this.catalogId = catalogId;
        this.userId = userId;
        this.rating = rating;
        this.movie = movie;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }    

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
