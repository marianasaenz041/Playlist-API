package com.playlist.playlist;

import org.apache.tomcat.util.http.parser.HttpParser;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/songs")
public class SongsController {

    @Autowired
    private SongsService songsService;

    @GetMapping
    public ResponseEntity<List<Songs>> getAllSongs(){
        return new ResponseEntity<List<Songs>>(songsService.allSongs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Songs>> getSingleSong(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Songs>>(songsService.singleSong(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Songs> createSong(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Songs>(songsService.addSong(payload.get("songTitle"), payload.get("artistName")), HttpStatus.CREATED);
    }
}
