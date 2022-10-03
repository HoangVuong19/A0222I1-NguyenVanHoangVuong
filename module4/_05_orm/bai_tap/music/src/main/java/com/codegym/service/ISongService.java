package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    Song findById(long id);

    void save(Song song);

    void delete(long id);
}
