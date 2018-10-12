package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Playlist;
import com.codingdojo.lookify.services.PlaylistService;

@Controller
public class PlaylistController {
	private final PlaylistService playlistService;
	
	public PlaylistController(PlaylistService playlistService) {
		this.playlistService = playlistService;
	};
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	};
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Playlist> play = playlistService.allPlaylist();
        model.addAttribute("playlist", play);
		return "dashboard.jsp";
	};
	
	@RequestMapping("/new")
	public String songNew(@ModelAttribute("playlist") Playlist play) {
		return "create.jsp";
	};
	
	@RequestMapping(value="/new/playlist", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("playlist") Playlist play, BindingResult result) {
		if (result.hasErrors()) {
			return "create.jsp";
		} else {
			playlistService.createPlaylist(play);
			return "redirect:/dashboard";
		}
	};
	
	@RequestMapping("/songs/{id}")
	public String getSpecific(@PathVariable("id") Long id, Model model) {
		Playlist play = playlistService.findPlaylist(id);
		model.addAttribute("playlist", play);
		return "specific.jsp";
	};
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(@RequestParam("artist") String artist) {
		return "redirect:/search/" + artist;
	};
	
	@RequestMapping("/search/{artist}")
	public String showSearch(@PathVariable("artist") String artist, Model model) {
		List<Playlist> songs  = playlistService.searchArtist(artist);
		model.addAttribute("song", songs);
		model.addAttribute("artist", artist);
		return "search.jsp";
	};
	
//	@RequestMapping("/search/topTen")
//	public String topSongs(Model model) {
//		List<Playlist> songs = playlistService.topTen();
//		model.addAttribute("song", songs);
//		return "ten.jsp";
//	};
	
	@RequestMapping("/delete/{id}")
	public String deletePlaylist(@PathVariable("id") Long id) {
		playlistService.deletePlaylist(id);
		return "redirect:/dashboard";
	};
	
}
