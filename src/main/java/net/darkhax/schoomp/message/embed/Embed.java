package net.darkhax.schoomp.message.embed;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.google.gson.annotations.Expose;

/**
 * This class represents an embedded message. These allow for special formatting and other
 * features which are not available to standard messages. A single message can have up to ten
 * embeds. To use this object simply create a new instance and use the setter methods to
 * customize the embed.
 * 
 * @author Tyler Hancock (Darkhax)
 */
public final class Embed {
    
    /**
     * The title string for the embed.
     */
    @Expose
    @Nullable
    private String title;
    
    /**
     * A url for the embed. If {@link #title} was set this will automatically become a
     * hyperlink.
     */
    @Expose
    @Nullable
    private String url;
    
    /**
     * The description text box of the embed.
     */
    @Expose
    @Nullable
    private String description;
    
    /**
     * The color of the message as a decimal. This does not support hexadecimal, but if you use
     * 0x followed by a hex code it will automatically be converted for you.
     */
    @Expose
    private int color;
    
    /**
     * The authorship information for the embed.
     */
    @Expose
    @Nullable
    private Author author;
    
    /**
     * A list of information fields.
     */
    @Expose
    @Nullable
    private List<Field> fields;
    
    /**
     * A thumbnail image that is displayed as part of the embed message.
     */
    @Expose
    @Nullable
    private Thumbnail thumbnail;
    
    /**
     * An image to include as part of the embed object.
     */
    @Expose
    @Nullable
    private Image image;
    
    /**
     * The footer block of the embed.
     */
    @Expose
    @Nullable
    private Footer footer;
    
    /**
     * A time stamp to put in the embed. This does not control the time the message was
     * sent/received.
     */
    @Expose
    @Nullable
    private LocalDateTime timestamp;
    
    /**
     * Gets the title of the embed.
     * 
     * @return The title of the embed.
     */
    @Nullable
    public String getTitle () {
        
        return this.title;
    }
    
    /**
     * Sets the title of the embed.
     * 
     * @param title The title of the embed.
     * @return The same embed instance.
     */
    public Embed setTitle (@Nullable String title) {
        
        this.title = title;
        return this;
    }
    
    /**
     * Gets the URL of the embed.
     * 
     * @return The URL of the embed.
     */
    @Nullable
    public String getUrl () {
        
        return this.url;
    }
    
    /**
     * Sets the URL for the embed to link to. If the {@link #title} has also been set this will
     * create a hyperlink.
     * 
     * @param url The URL for the embed to link to.
     * @return The same embed object.
     */
    public Embed setUrl (@Nullable String url) {
        
        this.url = url;
        return this;
    }
    
    /**
     * Gets the description text for the embed.
     * 
     * @return The description text for the embed.
     */
    @Nullable
    public String getDescription () {
        
        return this.description;
    }
    
    /**
     * Sets the description text for the embed.
     * 
     * @param description The description text for the embed.
     * @return The same embed object.
     */
    public Embed setDescription (@Nullable String description) {
        
        this.description = description;
        return this;
    }
    
    /**
     * Gets the color to display for the embed.
     * 
     * @return The color to display for the embed.
     */
    public int getColor () {
        
        return this.color;
    }
    
    /**
     * Sets the color of the embed.
     * 
     * @param color The color of the embed as a packed RGB integer.
     * @return The same embed object.
     */
    public Embed setColor (int color) {
        
        this.color = color;
        return this;
    }
    
    /**
     * Gets the author info of the embed.
     * 
     * @return The authorship info.
     */
    @Nullable
    public Author getAuthor () {
        
        return this.author;
    }
    
    /**
     * Sets the authorship info for the embed.
     * 
     * @param author The new authorship info.
     * @return The same embed object.
     */
    public Embed setAuthor (@Nullable Author author) {
        
        this.author = author;
        return this;
    }
    
    /**
     * Gets all the field info for the embed.
     * 
     * @return The list of fields for the embed.
     */
    @Nullable
    public List<Field> getFields () {
        
        return this.fields;
    }
    
    /**
     * Adds a new field to the embed.
     * 
     * @param name The name of the field.
     * @param value The value of the field.
     * @param inline Whether or not the field should be inlined with other fields.
     * @return The same embed object.
     */
    public Embed addField (String name, String value, boolean inline) {
        
        return this.addField(new Field(name, value, inline));
    }
    
    /**
     * Adds a new field to the embed.
     * 
     * @param field The new field to add to the embed.
     * @return The same embed object.
     */
    public Embed addField (Field field) {
        
        if (this.fields == null) {
            
            this.fields = new ArrayList<>();
        }
        
        this.fields.add(field);
        return this;
    }
    
    /**
     * Gets the thumbnail info for the embed.
     * 
     * @return The thumbnail info for the embed.
     */
    @Nullable
    public Thumbnail getThumbnail () {
        
        return this.thumbnail;
    }
    
    /**
     * Sets the thumbnail URL for the embed.
     * 
     * @param url The thumbnail URL to use.
     * @return The same embed object.
     */
    public Embed setThumbnail (String url) {
        
        return this.setThumbnail(new Thumbnail(url));
    }
    
    /**
     * Sets the thumbnail info for the embed.
     * 
     * @param thumbnail The thumbnail info for the embed.
     * @return The same embed object.
     */
    public Embed setThumbnail (@Nullable Thumbnail thumbnail) {
        
        this.thumbnail = thumbnail;
        return this;
    }
    
    /**
     * Gets the image info for the embed.
     * 
     * @return The image info for the embed.
     */
    @Nullable
    public Image getImage () {
        
        return this.image;
    }
    
    /**
     * Sets the image URL of the embed.
     * 
     * @param url The image URL for the embed.
     * @return The same embed object.
     */
    public Embed setImage (String url) {
        
        return this.setImage(new Image(url));
    }
    
    /**
     * Sets the image info for the embed.
     * 
     * @param image The new image info for the embed.
     * @return The same embed object.
     */
    public Embed setImage (@Nullable Image image) {
        
        this.image = image;
        return this;
    }
    
    /**
     * Gets the footer info for the embed.
     * 
     * @return The footer info for the embed.
     */
    @Nullable
    public Footer getFooter () {
        
        return this.footer;
    }
    
    /**
     * Sets the footer info for the embed.
     * 
     * @param footer The footer info for the embed.
     * @return The same embed object.
     */
    public Embed setFooter (@Nullable Footer footer) {
        
        this.footer = footer;
        return this;
    }
    
    /**
     * Gets the embed timestamp info.
     * 
     * @return The embed timestamp.
     */
    @Nullable
    public LocalDateTime getTimestamp () {
        
        return this.timestamp;
    }
    
    /**
     * Sets the embed timestamp.
     * 
     * @param timestamp The embed timestamp.
     * @return The same embed object.
     */
    public Embed setTimestamp (@Nullable LocalDateTime timestamp) {
        
        this.timestamp = timestamp;
        return this;
    }
}
