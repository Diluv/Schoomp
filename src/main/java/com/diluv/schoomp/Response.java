package com.diluv.schoomp;

import java.io.IOException;

import javax.annotation.Nullable;
import javax.net.ssl.HttpsURLConnection;

/**
 * This class represents all the relevant information that Discord sends back after they
 * receive the request.
 * 
 * @author Tyler Hancock (Darkhax)
 */
public class Response {
    
    /**
     * The response code given back by Discord.
     */
    private final int statusCode;
    
    /**
     * Only returned when {@link #statusCode} is 429. This is the global rate limit.
     */
    private final Integer rateLimitGlobal;
    
    /**
     * The number of requests that can be made.
     */
    private final Integer rateLimitLimit;
    
    /**
     * The number of remaining requests that can be made.
     */
    private final Integer rateLimitRemaining;
    
    /**
     * The epoch time for when the rate limit will be reset.
     */
    private final Long rateLimitReset;
    
    /**
     * The amount of seconds remaining before the rate limit will reset.
     */
    private final Integer rateLimitResetAfter;
    
    public Response(HttpsURLConnection connection) throws IOException {
        
        this.statusCode = connection.getResponseCode();
        this.rateLimitGlobal = this.getParameterInt(connection, "X-RateLimit-Global");
        this.rateLimitLimit = this.getParameterInt(connection, "X-RateLimit-Limit");
        this.rateLimitRemaining = this.getParameterInt(connection, "X-RateLimit-Remaining");
        this.rateLimitReset = this.getParameterLong(connection, "X-RateLimit-Reset");
        this.rateLimitResetAfter = this.getParameterInt(connection, "X-RateLimit-Reset-After");
    }
    
    /**
     * Reads a Long parameter from the headers of a connection. If no parameter can be found it
     * will return null.
     * 
     * @param connection The connection to read from.
     * @param name The name of the field.
     * @return The parameter or null if no param could be found.
     */
    @Nullable
    private Long getParameterLong (HttpsURLConnection connection, String name) {
        
        final String value = connection.getHeaderField(name);
        
        if (value != null) {
            
            try {
                
                return Long.parseLong(value);
            }
            
            catch (final NumberFormatException e) {
                
                return null;
            }
        }
        
        return null;
    }
    
    /**
     * Reas an Integer parameter from the headers of a connection. If no parameter can be found
     * it will return null.
     * 
     * @param connection The connection to read from.
     * @param name The name of the field.
     * @return The parameter or null if no param could be found.
     */
    @Nullable
    private Integer getParameterInt (HttpsURLConnection connection, String name) {
        
        final String value = connection.getHeaderField(name);
        
        if (value != null) {
            
            try {
                
                return Integer.parseInt(value);
            }
            
            catch (final NumberFormatException e) {
                
                return null;
            }
        }
        
        return null;
    }
    
    /**
     * Gets the status response code that Discord sent us. This is usually 204 meaning a
     * successful request but no content was sent back to us.
     * 
     * @return The status response code from Discord.
     */
    public int getStatusCode () {
        
        return this.statusCode;
    }
    
    /**
     * Gets the global rate limit value.
     * 
     * @return The global rate limit.
     */
    @Nullable
    public Integer getRateLimitGlobal () {
        
        return this.rateLimitGlobal;
    }
    
    /**
     * Gets the current rate limit.
     * 
     * @return The current rate limit.
     */
    @Nullable
    public Integer getRateLimit () {
        
        return this.rateLimitLimit;
    }
    
    /**
     * Gets the amount of calls remaining before we are limited.
     * 
     * @return The amount of remaining calls before rate limit comes into effect.
     */
    @Nullable
    public Integer getRateLimitRemaining () {
        
        return this.rateLimitRemaining;
    }
    
    /**
     * Gets the epoch time of when the rate limit will be reset.
     * 
     * @return When the rate limit will be reset.
     */
    public Long getRateLimitReset () {
        
        return this.rateLimitReset;
    }
    
    /**
     * Gets the amount of seconds until the rate limit resets.
     * 
     * @return The amount of seconds until the rate limit resets.
     */
    public Integer getRateLimitResetAfter () {
        
        return this.rateLimitResetAfter;
    }
    
    @Override
    public String toString () {
        
        return "Response [getStatusCode()=" + this.getStatusCode() + ", getRateLimitGlobal()=" + this.getRateLimitGlobal() + ", getRateLimit()=" + this.getRateLimit() + ", getRateLimitRemaining()=" + this.getRateLimitRemaining() + ", getRateLimitReset()=" + this.getRateLimitReset() + ", getRateLimitResetAfter()=" + this.getRateLimitResetAfter() + "]";
    }
}