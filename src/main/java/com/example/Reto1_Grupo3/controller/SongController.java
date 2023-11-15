package com.example.Reto1_Grupo3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.Reto1_Grupo3.exceptions.song.SongEmptyListException;
import com.example.Reto1_Grupo3.exceptions.song.SongNotCreatedException;
import com.example.Reto1_Grupo3.exceptions.song.SongNotFoundException;

import com.example.Reto1_Grupo3.model.song.SongDTO;
import com.example.Reto1_Grupo3.model.song.SongGetResponse;
import com.example.Reto1_Grupo3.model.song.SongPostRequest;
import com.example.Reto1_Grupo3.security.model.UserDAO;
import com.example.Reto1_Grupo3.service.SongService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("api")
public class SongController {
	@Autowired
	SongService songService;

	@GetMapping("/fav")
	public ResponseEntity<List<SongGetResponse>> getAllFavorites(Authentication authentication)throws SongNotFoundException{	
		try {
			UserDAO userDetails = (UserDAO) authentication.getPrincipal();
			List<SongDTO> list = songService.findAllFavorite(userDetails.getId());
			List<SongGetResponse> listPostRequest = new ArrayList<SongGetResponse>();
			for (SongDTO songDTO : list) {
				listPostRequest.add(convertDTOtoResponse(songDTO));
			}
			
			return new ResponseEntity<>(listPostRequest,HttpStatus.ACCEPTED);
		
		}catch(SongNotFoundException e) {
		
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage(), e);
		}
	}

	@GetMapping("/songs")
	public ResponseEntity<List<SongGetResponse>> getSongs(Authentication authentication) throws SongEmptyListException{
		try {
			List<SongDTO> listSongsDAO = new ArrayList<SongDTO>();
			if(authentication == null) {
				listSongsDAO = songService.findAll(0);
			}else{				
				UserDAO userDetails = (UserDAO) authentication.getPrincipal();
				listSongsDAO = songService.findAll(userDetails.getId());
			}
			List<SongGetResponse> listSongsGetREsponse= new ArrayList<SongGetResponse>();
	
			for(SongDTO songDTO: listSongsDAO ) {
	
				listSongsGetREsponse.add(convertDTOtoResponse(songDTO));
			}
			
			return new ResponseEntity<>(listSongsGetREsponse, HttpStatus.ACCEPTED);
		}catch (SongEmptyListException e){
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage(), e);
		}
	}
	
	@GetMapping("/songs/{id_song}")
	public ResponseEntity<List<SongGetResponse>> getSongById(@PathVariable("id_song") int id)throws SongNotFoundException{
		List<SongDTO> listSongsDAO = songService.findSongById(id);
		List<SongGetResponse> listSongsGetREsponse= new ArrayList<SongGetResponse>();

		for(SongDTO songDTO: listSongsDAO ) {

			listSongsGetREsponse.add(convertDTOtoResponse(songDTO));

		}
		return new ResponseEntity<> (listSongsGetREsponse, HttpStatus.ACCEPTED);

	}

	@PostMapping("/songs")
	public ResponseEntity<?> createSong(@Valid @RequestBody SongPostRequest songPostRequest) throws SongNotCreatedException{

		try {
			songService.createSong(SongDTOconvertRequestToDTO(songPostRequest));
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (SongNotCreatedException e) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
		}
	}
	@DeleteMapping("/songs/{id}")
	public ResponseEntity<?> deleteSong(@PathVariable("id") int id) throws SongNotFoundException{

		try {
			return new ResponseEntity<>(songService.deleteSongById(id), HttpStatus.NO_CONTENT);
		} catch (SongNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,e.getMessage(),e);
		}	
	}

	@PutMapping("/songs/{id}")
	public ResponseEntity<?>  updateSong(@PathVariable("id") int id, @RequestBody SongPostRequest songPostRequest) throws SongNotFoundException{
		songPostRequest.setId(id);

		try {
			return new ResponseEntity<>(songService.updateSong(SongDTOconvertRequestToDTO(songPostRequest)),HttpStatus.NO_CONTENT);
		} catch (SongNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,e.getMessage(),e);
		
		}

	}

	private SongDTO SongDTOconvertRequestToDTO(SongPostRequest songPostRequest) {
		SongDTO songDTO = new SongDTO(
				songPostRequest.getId(),
				songPostRequest.getUrl(),
				songPostRequest.getTitle(),
				songPostRequest.getAuthor(),
				songPostRequest.isFavorite()
				
				);
		return songDTO;
	}
	private SongGetResponse convertDTOtoResponse(SongDTO songDTO) {
		return new SongGetResponse(
				songDTO.getId(),
				songDTO.getUrl(),
				songDTO.getTitle(),
				songDTO.getAuthor(),
				songDTO.isFavorite()				
				);
	}
}