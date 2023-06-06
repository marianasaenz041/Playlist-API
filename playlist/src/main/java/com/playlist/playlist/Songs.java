package com.playlist.playlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "songs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Songs {
    @Id
    private ObjectId id;

    private String songTitle;

    private String artistName;

    public Songs(String songTitle, String artistName) {
        this.songTitle = songTitle;
        this.artistName = artistName;
    }
}
