# Schoomp
Schoomp is a Java library for building and sending webhook requests to Discord. This library allows you to quickly send messages to an authorized Discord channel in a programatic way. 

## What's with the name?
The name Schoomp comes from a description of webhooks given by Discord in their [Intro To Webhooks](https://support.discordapp.com/hc/en-us/articles/228383668-Intro-to-Webhooks) blog post. The word Schoomp is an onomatopeia, meaning that it comes from the imitation of a sound. In this case the sound of a capsule traveling through a pneumatic tube.

## Maven Info
Coming soon to a maven central near you! 🙃

## Getting Started

The first step is to get or create a webhook URL. Webhooks are easily created from the settings page of any text channel on Discord. **Keep in mind that the webhook URL contains a private token and should not be made public facing!** You will also need a user agent for your application. This can be arbitrary, but should make your application identifiable in some way.

Now that you have your URL and user agent you can construct a new Webhook object. This will allow you to send messages using your application. 

```java
Webhook webhook = new Webhook("webhook url here", "user agent here");
```

The next step is to create a new Message object which represents the contents and structure of the message you are sending. This is done by constructing the message object and customizing it with the various setter methods. You do not need to set every property however you do need to set the content or add at least one embed to the message. 

```java
    Message message = new Message().setContent("Hello world!").setUsername("Example Application");
```

The last step is to send the message to Discord. This is done by passing the message to the webhook. 

```java
final Webhook webhook = new Webhook("webhook url here", "user agent here");
final Message message = new Message().setContent("Hello world!").setUsername("Example Application");

try {
    
    webhook.sendMessage(message);
}

catch (final IOException e) {
    
    // Handle or log the error.
}
```