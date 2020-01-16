package com.diluv.schoomp.message.embed;

import javax.annotation.Nullable;

import com.google.gson.annotations.Expose;

/**
 * This class represents the thumbnail element of an embedded Discord message.
 * 
 * @author Tyler Hancock (Darkhax)
 *
 */
public class Thumbnail {
    
    /**
     * The url of the thumbnail image.
     */
    @Expose
    @Nullable
    private String url;
    
    public Thumbnail() {
        
        this(null);
    }
    
    public Thumbnail(@Nullable String url) {
        
        this.url = url;
    }
    
    /**
     * Gets the URL for the thumbnail.
     * 
     * @return The URL for the thumbnail.
     */
    @Nullable
    public String getUrl () {
        
        return this.url;
    }
    
    /**
     * Sets the URL for the thumbnail.
     * 
     * @param url The URL for the thumbail.
     * @return The same instance.
     */
    public Thumbnail setUrl (@Nullable String url) {
        
        this.url = url;
        return this;
    }
}
