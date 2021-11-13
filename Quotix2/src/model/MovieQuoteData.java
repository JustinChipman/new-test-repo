/**
 * 
 */
package model;

import java.sql.Blob;
import java.sql.Date;

/**
 * @author ChipmanJustin
 *
 */
public class MovieQuoteData {
    int id;
    
    String quote;
    
    String movieCharacter;
    
    String actor;
    
    String movieTitle;
    
    String movieGenre;
    
    Integer releaseYear;
    
    double runtime;
    
    Blob image;
    
    Integer visits;
    
    Date dateAdded;
    
    Date lastModified;

    
    /**
     * @param id
     * @param quote
     * @param movieCharacter
     * @param actor
     * @param movieTitle
     * @param movieGenre
     * @param releaseYear
     * @param runtime
     * @param image
     * @param visits
     * @param dateAdded2
     * @param dateAdded3
     */
    public MovieQuoteData(int id, String quote, String movieCharacter, String actor, String movieTitle,
	    String movieGenre, Integer releaseYear, double runtime, Blob image, Integer visits, Date dateAdded2,
	    Date dateAdded3) {
	this.id = id;
	this.quote = quote;
	this.movieCharacter = movieCharacter;
	this.actor = actor;
	this.movieTitle = movieTitle;
	this.movieGenre = movieGenre;
	this.releaseYear = releaseYear;
	this.runtime = runtime;
	this.image = image;
	this.visits = visits;
	this.dateAdded = dateAdded2;
	this.lastModified = dateAdded3;
    }
/**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @return the quote
     */
    public String getQuote() {
        return quote;
    }

    /**
     * @param quote the quote to set
     */
    public void setQuote(String quote) {
        this.quote = quote;
    }

    /**
     * @return the movieCharacter
     */
    public String getMovieCharacter() {
        return movieCharacter;
    }

    /**
     * @param movieCharacter the movieCharacter to set
     */
    public void setMovieCharacter(String movieCharacter) {
        this.movieCharacter = movieCharacter;
    }

    /**
     * @return the actor
     */
    public String getActor() {
        return actor;
    }

    /**
     * @param actor the actor to set
     */
    public void setActor(String actor) {
        this.actor = actor;
    }

    /**
     * @return the movieTitle
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * @param movieTitle the movieTitle to set
     */
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    /**
     * @return the movieGenre
     */
    public String getMovieGenre() {
        return movieGenre;
    }

    /**
     * @param movieGenre the movieGenre to set
     */
    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    /**
     * @return the releaseYear
     */
    public Integer getReleaseYear() {
        return releaseYear;
    }

    /**
     * @param releaseYear the releaseYear to set
     */
    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    /**
     * @return the runtime
     */
    public double getRuntime() {
        return runtime;
    }

    /**
     * @param runtime the runtime to set
     */
    public void setRuntime(double runtime) {
        this.runtime = runtime;
    }

    /**
     * @return the image
     */
    public Blob getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Blob image) {
        this.image = image;
    }

    /**
     * @return the visits
     */
    public Integer getVisits() {
        return visits;
    }

    /**
     * @param visits the visits to set
     */
    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    /**
     * @return the dateAdded
     */
    public Date getDateAdded() {
        return dateAdded;
    }

    /**
     * @param dateAdded the dateAdded to set
     */
    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    /**
     * @return the lastModified
     */
    public Date getLastModified() {
        return lastModified;
    }

    /**
     * @param lastModified the lastModified to set
     */
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    

    
   }
