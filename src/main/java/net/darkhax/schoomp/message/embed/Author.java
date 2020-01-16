package net.darkhax.schoomp.message.embed;

import javax.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * This class represents the authorship info on a Discord embed. To use it you can construct a
 * new instance and use the setters, or use some of the helper methods on the Embed instance.
 * 
 * @author Tyler Hancock (Darkhax)
 */
public final class Author {
    
    /**
     * The name of the author.
     */
    @Expose
    @Nullable
    private String name;
    
    /**
     * A URL for the author, like a twitter link or something.
     */
    @Expose
    @Nullable
    private String url;
    
    /**
     * A URL for the author icon displayed.
     */
    @Expose
    @Nullable
    @SerializedName("icon_url")
    private String iconUrl;
    
    public Author() {
        
        this(null, null, null);
    }
    
    public Author(@Nullable String name) {
        
        this(name, null, null);
    }
    
    public Author(@Nullable String name, @Nullable String url) {
        
        this(name, url, null);
    }
    
    public Author(@Nullable String name, @Nullable String url, @Nullable String iconUrl) {
        
        this.name = name;
        this.url = url;
        this.iconUrl = iconUrl;
    }
    
    /**
     * Gets the name of the author.
     * 
     * @return The name of the author.
     */
    @Nullable
    public String getName () {
        
        return this.name;
    }
    
    /**
     * Sets the name of the author.
     * 
     * @param name The name of the author.
     * @return The same instance.
     */
    public Author setName (@Nullable String name) {
        
        this.name = name;
        return this;
    }
    
    /**
     * Gets a URL for the author.
     * 
     * @return The same instance.
     */
    @Nullable
    public String getUrl () {
        
        return this.url;
    }
    
    /**
     * Sets the author's URL.
     * 
     * @param url The author's URL.
     */
    public void setUrl (@Nullable String url) {
        
        this.url = url;
    }
    
    /**
     * Gets an avatar URL for the author.
     * 
     * @return The author's avatar URL.
     */
    @Nullable
    public String getIconUrl () {
        
        return this.iconUrl;
    }
    
    /**
     * Sets the avatar icon URL for the author.
     * 
     * @param iconUrl The avatar icon URL.
     * @return The same instance.
     */
    public Author setIconUrl (@Nullable String iconUrl) {
        
        this.iconUrl = iconUrl;
        return this;
    }
}