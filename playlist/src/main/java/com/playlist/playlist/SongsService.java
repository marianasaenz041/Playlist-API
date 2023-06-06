package com.playlist.playlist;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongsService {

    @Autowired
    private SongsRepository songsRepository;

    public List<Songs> allSongs(){
        return songsRepository.findAll();
    }

    public Optional<Songs> singleSong(ObjectId id){
        return songsRepository.findById(id);
    }

    @Autowired
    private MongoTemplate mongoTemplate;
    public Songs addSong(String songTitle, String artistName){
        Songs songs = songsRepository.insert(new Songs(songTitle, artistName));

        mongoTemplate.update(Songs.class)
                .apply(new Update().push("id").value(songs));
        return songs;
    }
}
