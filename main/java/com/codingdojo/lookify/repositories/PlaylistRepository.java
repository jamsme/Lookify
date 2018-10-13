package com.codingdojo.lookify.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.lookify.models.Playlist;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Long>{
	
	List<Playlist> findAll();
	List<Playlist> findByArtist(String artist);
	List<Playlist> findTop10ByOrderByRatingDesc();
}
