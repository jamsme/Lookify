package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Playlist;
import com.codingdojo.lookify.repositories.PlaylistRepository;

@Service
public class PlaylistService {

	private final PlaylistRepository playlistRepo;
	
	public PlaylistService(PlaylistRepository playlistRepo) {
		this.playlistRepo = playlistRepo;
	};
	
	// returns all of the playlist
	public List<Playlist> allPlaylist() {
		return playlistRepo.findAll();
	};
	
    // creates a book
    public Playlist createPlaylist(Playlist p) {
        return playlistRepo.save(p);
    };
    
    // get specific
    public Playlist findPlaylist(Long id) {
    	Optional<Playlist> optionalPlaylist = playlistRepo.findById(id);
    	if (optionalPlaylist.isPresent()) {
    		return optionalPlaylist.get();
    	} else {
    		return null;
    	}
    };
    
    // search artists
    public List<Playlist> searchArtist(String artist){
    	return playlistRepo.findByArtist(artist);
    };
    
//    // getting top 10 songs by rating
//    public List<Playlist> topTen(){
//    	return playlistRepo.findTop10ByRatingDesc();
//    };
    
    // delete
    public Playlist deletePlaylist(Long id) {
    	Optional<Playlist> delete = playlistRepo.findById(id);
    	if (delete.isPresent()) {
    		Playlist playlist = delete.get();
    		playlistRepo.deleteById(id);
    		return playlist;
    	} else {
    		return null;
    	}
    };
	
}
