package net.darkhax.schoomp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.darkhax.schoomp.message.Message;

/**
 * This class represents a Discord Webhook. Once an instance has been created using the
 * constructor you can use it to send messages to the associated Discord channel through your
 * application.
 * 
 * @author Tyler Hancock (Darkhax)
 */
public class Webhook {
    
    /**
     * The internal Gson instance used to serialize webhook messages.
     */
    private static final Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm'Z'").create();
    
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
     */
    public void sendMessageUnsafely (Message message) {
        
        try {
            
            this.sendMessage(message);
        }
        
        catch (final IOException e) {
            
            // Ignore the error and move on.
        }
    }
    
    /**
     * Sends a message to Discord using your webhook.
     * 
     * @param message The message to send.
     * @throws IOException This will happen if the request can not be sent properly.
     */
    public void sendMessage (Message message) throws IOException {
        
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
        
        // Closes the connection.
        connection.disconnect();
    }
}