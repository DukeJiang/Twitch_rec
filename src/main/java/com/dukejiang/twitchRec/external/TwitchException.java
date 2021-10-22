package com.dukejiang.twitchRec.external;

/**
 * exception body class
 * this exception will be thrown if there is something wrong when calling Twitch API
 */
public class TwitchException extends RuntimeException{
    public TwitchException(String errorMessage){
        super(errorMessage);
    }
}
