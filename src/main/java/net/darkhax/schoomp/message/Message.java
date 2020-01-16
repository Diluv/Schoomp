package net.darkhax.schoomp.message;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.darkhax.schoomp.message.embed.Embed;

/**
 * This class represents a message that can be sent to Discord using a Webhook. To use this
 * class simply create a new instance and use the various setters to customize it.
 * 
 * @author Tyler Hancock (Darkhax)
 */
public final class Message {
    
    /**
     * The username to display for the message. This will override whatever the default name
     * is.
     */
    @Expose
    @Nullable
    private String username;
    
    /**
     * The image to display for the avatar of the message. This will override whatever the
     * default icon is.
     */
    @Expose
    @Nullable
    @SerializedName("avatar_url")
    private String avatarUrl;
    
    /**
     * The basic text of the message. This is optional, and can only be 2000 chars max.
     */
    @Expose
    @Nullable
    private String content;
    
    /**
     * Whether or not the message should be broadcasted using text to speech.
     */
    @Expose
    private boolean tts = false;
    
    /**
     * A list of embeds attached to the message.
     */
    @Expose
    @Nullable
    private List<Embed> embeds;
    
    /**
     * Gets the display name override for the message. Null means the default in Discord will
     * be used.
     * 
     * @return The display name override for the message, or null if there is no override.
     */
    @Nullable
    public String getUsername () {
        
        return this.username;
    }
    
    /**
     * Sets the override username for the message. Setting this value to a non-null string will
     * replace the display name set in Discord for this specific message. Setting this value to
     * null will reset the value back to the default name set in Discord.
     * 
     * @param username The desired username.
     * @return The same message instance.
     */
    public Message setUsername (@Nullable String username) {
        
        this.username = username;
        return this;
    }
    
    /**
     * Gets the URL of the avatar image override. A null value means the default is being used.
     * 
     * @return The avatar override image, or null if there is no override.
     */
    @Nullable
    public String getAvatarUrl () {
        
        return this.avatarUrl;
    }
    
    /**
     * Sets the avatar image to a temporary override image. Setting this to null will remove
     * the override and default back to the avatar set in Discord.
     * 
     * @param avatarUrl The desired avatar override image.
     * @return The same message instance.
     */
    public Message setAvatarUrl (@Nullable String avatarUrl) {
        
        this.avatarUrl = avatarUrl;
        return this;
    }
    
    /**
     * Gets the basic message contents. If this is null it means no base text has been set.
     * 
     * @return The basic message contents, or null if none have been set.
     */
    @Nullable
    public String getContent () {
        
        return this.content;
    }
    
    /**
     * Sets the basic message contents. If this is set to null the message contents will be
     * removed.
     * 
     * @param content The desired message contents.
     * @return The same message instance.
     */
    public Message setContent (@Nullable String content) {
        
        this.content = content;
        return this;
    }
    
    /**
     * Checks whether or not the message will use Discord Text To Speech. This is off by
     * default.
     * 
     * @return Whether or not TTS is enabled.
     */
    public boolean isTts () {
        
        return this.tts;
    }
    
    /**
     * Sets whether or not the message should use Discord Text To Speech.
     * 
     * @param tts Whether or not TTS should be used.
     * @return The same message instance.
     */
    public Message setTts (boolean tts) {
        
        this.tts = tts;
        return this;
    }
    
    /**
     * Adds a new embed to the message. Embeds are used to display styled content in a Discord
     * message. Keep in mind that there is a max of 10 embeds per one message, adding more will
     * cause an exception.
     * 
     * @param embed The embed to add.
     * @return The same message instance.
     */
    public Message addEmbed (Embed embed) {
        
        if (this.embeds == null) {
            
            this.embeds = new ArrayList<>();
        }
        
        this.embeds.add(embed);
        
        if (this.embeds.size() > 10) {
            
            throw new IllegalArgumentException("Too many embeds for this message. Discord only allows for 10.");
        }
        
        return this;
    }
    
    /**
     * Gets a list of all the embeds on this message. This will usually be null if there are no
     * embeds.
     * 
     * @return A list of all the embeds, or null if no embeds have been added.
     */
    @Nullable
    public List<Embed> getEmbeds () {
        
        return this.embeds;
    }
}