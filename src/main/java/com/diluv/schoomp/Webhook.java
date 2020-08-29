package com.diluv.schoomp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.Nullable;
import javax.net.ssl.HttpsURLConnection;

import com.diluv.schoomp.message.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;

/**
 * This class represents a Discord Webhook. Once an instance has been created using the
 * constructor you can use it to send messages to the associated Discord channel through your
 * application.
 * 
 * @author Tyler Hancock (Darkhax)
 */
public class Webhook {
    
    /**
     * Converts OffsetDateTime into a JSON string that Discord can use.
     */
    private static final JsonSerializer<OffsetDateTime> TIME_SERIALIZER = (s, t, c) -> new JsonPrimitive(s.format(DateTimeFormatter.ISO_INSTANT));
    
    /**
     * The internal Gson instance used to serialize webhook messages.
     */
    private static final Gson GSON = new GsonBuilder().registerTypeAdapter(OffsetDateTime.class, TIME_SERIALIZER).create();
    
    /**
     * The webhook URL to send the message to. This should be considered a sensitive value as
     * it contains keys and can be misused.
     */
    private final String webookUrl;
    
    /**
     * A user agent for the request. This allows Discord to log requests from your specific
     * application.
     */
    private final String userAgent;
    
    /**
     * Creates an object that represents a Discord Webhook for a Discord channel. With this you
     * can send messages to your Discord channel using your application. This type is reusable,
     * so it is recommended that you keep a hard reference to your channels to save ram.
     * 
     * @param webookUrl The URL of your webhook.
     * @param userAgent The user agent to use when sending your requests.
     */
    public Webhook(String webookUrl, String userAgent) {
        
        this.webookUrl = webookUrl;
        this.userAgent = userAgent;
    }
    
    /**
     * Sends a message to Discord using your webhook. This will ignore any errors that occur
     * and move on as normal if the message fails to send.
     * 
     * @param message The message to send.
     * @return A response object containing all the information sent back from Discord.
     */
    @Nullable
    public Response sendMessageUnsafely (Message message) {
        
        try {
            
            return this.sendMessage(message);
        }
        
        catch (final IOException e) {
            
            // Ignore the error and move on.
        }
        
        return null;
    }
    
    /**
     * Sends a message to Discord using your webhook.
     * 
     * @param message The message to send.
     * @return A response object containing all the information sent back from Discord.
     * @throws IOException This will happen if the request can not be sent properly.
     */
    @Nullable
    public Response sendMessage (Message message) throws IOException {
        
        // Encodes the message object as JSON.
        final String encoded = GSON.toJson(message);
        
        final URL url = new URL(this.webookUrl);
        final HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        
        // Set up the request to send the message data.
        connection.addRequestProperty("Content-Type", "application/json; charset=UTF-8");
        connection.addRequestProperty("User-Agent", this.userAgent);
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        
        connection.connect();
        
        // Write the contents of the json to the output stream.
        try (OutputStream out = connection.getOutputStream()) {
            
            out.write(encoded.getBytes());
        }
        
        // Actually sends our request, and gets the response back. In this case Discord gives
        // us no response so we don't do anything here.
        connection.getInputStream().close();
        
        final Response response = new Response(connection);
        
        // Closes the connection.
        connection.disconnect();
        
        return response;
    }
}