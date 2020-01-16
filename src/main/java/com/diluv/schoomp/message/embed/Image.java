package com.diluv.schoomp.message.embed;

import javax.annotation.Nullable;

import com.google.gson.annotations.Expose;

/**
 * This class represents an image element in an embedded message.
 * 
 * @author Tyler Hancock (Darkhax)
 *
 */
public class Image {
    
    /**
     * A URL that points to the image to display.
     */
    @Expose
    @Nullable
    private String url;
    
    public Image() {
        
        this(null);
    }
    
    public Image(@Nullable String url) {
        
        this.url = url;
    }
    
    /**
     * Gets the URL for the image.
     * 
     * @return The URL for the image.
     */
    @Nullable
    public String getUrl () {
        
        return this.url;
    }
    
    /**
     * Sets the URL for the image.
     * 
     * @param url The URL for the image.
     * @return The same instance.
     */
    public Image setUrl (@Nullable String url) {
        
        this.url = url;
        return this;
    }
}