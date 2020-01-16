package com.diluv.schoomp.message.embed;

import com.google.gson.annotations.Expose;

/**
 * This class represents a Field element in an embedded Discord message. A field is used to
 * represent a small piece of data such as a value or a statistic.
 * 
 * @author Tyler Hancock (Darkhax)
 */
public final class Field {
    
    /**
     * The name of the field.
     */
    @Expose
    private String name;
    
    /**
     * The value of the field.
     */
    @Expose
    private String value;
    
    /**
     * Controls whether or not fields should be displayed on the same line. There is a max of
     * three per line for normal messages. If a thumbnail is used with the message the maximum
     * becomes two.
     */
    @Expose
    private boolean inline = false;
    
    public Field() {
        
    }
    
    public Field(String name, String value, boolean inline) {
        
        this.name = name;
        this.value = value;
        this.inline = inline;
    }
    
    /**
     * Gets the name of the field.
     * 
     * @return The name of the field.
     */
    public String getName () {
        
        return this.name;
    }
    
    /**
     * Sets the name of the field.
     * 
     * @param name The name of the field.
     */
    public void setName (String name) {
        
        this.name = name;
    }
    
    /**
     * Gets the value of the field.
     * 
     * @return The value of the field.
     */
    public String getValue () {
        
        return this.value;
    }
    
    /**
     * Sets the value of the field.
     * 
     * @param value The value of the field.
     */
    public void setValue (String value) {
        
        this.value = value;
    }
    
    /**
     * Checks if the field is inlined.
     * 
     * @return Whether or not the field should be inlined.
     */
    public boolean isInline () {
        
        return this.inline;
    }
    
    /**
     * Sets whether or not the field should be inlined.
     * 
     * @param inline Whether or not the field should be inlined.
     */
    public void setInline (boolean inline) {
        
        this.inline = inline;
    }
}
