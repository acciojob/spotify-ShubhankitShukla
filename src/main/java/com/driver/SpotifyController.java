package com.driver;

import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("spotify")
public class SpotifyController {


    SpotifyService spotifyService = new SpotifyService();

    @PostMapping("/add-user")
    public String createUser(@RequestParam(name = "name") String name, String mobile){

        User user=spotifyService.createUser(name,mobile);
        return "Success";
    }

    @PostMapping("/add-artist")
    public String createArtist(@RequestParam(name = "name") String name){

        Artist artist = spotifyService.createArtist(name);
        return "Success";
    }

    @PostMapping("/add-album")
    public String createAlbum(@RequestParam(name = "title") String title, String artistName){

        Album album = spotifyService.createAlbum(title, artistName);
        return "Success";
    }

    @PostMapping("/add-song")
    public String createSong(String title, String albumName, int length) throws Exception{

        Song song = spotifyService.createSong(title, albumName, length);
        return "Success";
    }

    @PostMapping("/add-playlist-on-length")
    public String createPlaylistOnLength(String mobile, String title, int length) throws Exception{

        Playlist playlist = spotifyService.createPlaylistOnLength(mobile, title, length);
        return "Success";
    }

    @PostMapping("/add-playlist-on-name")
    public String createPlaylistOnName(String mobile, String title, List<String> songTitles) throws Exception{

        Playlist playlist = spotifyService.createPlaylistOnName(mobile,title,songTitles);
        return "Success";
    }

    @PutMapping("/find-playlist")
    public String findPlaylist(String mobile, String playlistTitle) throws Exception{

        Playlist playlist = spotifyService.findPlaylist(mobile, playlistTitle);

        return "Success";
    }

    @PutMapping("/like-song")
    public String likeSong(String mobile, String songTitle) throws Exception{

        Song song = spotifyService.likeSong(mobile,songTitle);
        return "Success";
    }

    @GetMapping("/popular-artist")
    public String mostPopularArtist(){

        return spotifyService.mostPopularArtist();
    }

    @GetMapping("/popular-song")
    public String mostPopularSong(){

        return spotifyService.mostPopularSong();
    }
}