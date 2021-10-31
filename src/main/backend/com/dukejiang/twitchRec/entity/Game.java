package com.dukejiang.twitchRec.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


//other fields in the response can be safely ignored
@JsonIgnoreProperties(ignoreUnknown = true)
//null fields can be skipped and not included
@JsonInclude(JsonInclude.Include.NON_NULL)
//Jackson needs to use Game.Builder when constructing a game object from JSON strings
@JsonDeserialize(builder = Game.Builder.class)
public class Game {
    @JsonProperty("id")
    private final String id;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("box_art_url")
    private final String boxArtUrl;


    public String getId(){
        return id;
    }
    public String getName() {
        return name;
    }
    public String getBoxArtUrl() {
        return boxArtUrl;
    }

    public Game(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.boxArtUrl = builder.boxArtUrl;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Builder{
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("boxArtUrl")
        private String boxArtUrl;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setBoxArtUrl(String boxArtUrl){
            this.boxArtUrl = boxArtUrl;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }

}
