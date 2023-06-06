package com.playlist.playlist;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongsRepository extends MongoRepository<Songs, ObjectId> {
}
