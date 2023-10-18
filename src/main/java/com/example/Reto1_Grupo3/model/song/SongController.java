package com.example.Reto1_Grupo3.model.song;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto1_Grupo3.service.SongService;

@RestController

	

public class SongController {
	@Autowired
	SongService songService;
	
	@GetMapping("/songs")
	public List<Song> getSongs(){
		return songService.findAll();
	}
}
