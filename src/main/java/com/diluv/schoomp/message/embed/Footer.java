package com.diluv.schoomp.message.embed;

import javax.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * This class represents the Footer element of an embedded discord message. The footer can be
 * used to add some small additional text or a small icon.
 * 
 * @author Tyler Hancock (Darkhax)
 */
public final class Footer {
    
    /**
     * Text to display at the bottom of the message. This will not support markdown strings!
     */
    @Expose
    @Nullable
    private String text;
    
    /**
     * A URL for an icon to include as part of the footer message.
     */
    @Expose
    @Nullable
    @SerializedName("icon_url")
    private String iconUrl;
    
    public Footer() {
        
        this(null, null);
    }
    
    public Footer(@Nullable String text) {
        
        this(text, null);
    }
    
    public Footer(@Nullable String text, @Nullable String icon) {
        
        this.text = text;
        this.iconUrl = icon;
    }
    
    /**
     * Gets the footer text.
     * 
     * @return The footer text.
     */
    @Nullable
    public String getText () {
        
        return this.text;
    }
    
    /**
     * Sets the footer text.
     * 
     * @param text The new footer text.
     * @return The same footer object.
     */
    public Footer setText (@Nullable String text) {
        
        this.text = text;
        return this;
    }
    
    /**
     * Gets the footer icon URL.
     * 
     * @return The icon URL for the footer.
     */
    @Nullable
    public String getIconUrl () {
        
        return this.iconUrl;
    }
    
    /**
     * Sets the icon URL for the footer.
     * 
     * @param iconUrl The new footer icon URL.
     * @return The same footer object.
     */
    public Footer setIconUrl (@Nullable String iconUrl) {
        
        this.iconUrl = iconUrl;
        return this;
    }
}
