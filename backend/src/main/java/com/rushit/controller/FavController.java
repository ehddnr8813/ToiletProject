package com.rushit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rushit.model.service.FavService;
import com.rushit.model.vo.Fav;

@RequestMapping
@RestController
public class FavController {
	private FavService favService;
	
	@Autowired
	public void setFavService(FavService favService) {
		this.favService = favService;
	}
	
	@GetMapping("/fav")
	public ResponseEntity<Boolean> registerFav(@RequestParam String user_id, @RequestParam String toilet_id, @RequestParam int state){
		boolean favorite;
		if(state == 1) favorite = true;
		else favorite = false;
		Fav addFav = new Fav("test", "test", favorite);
		return favService.addFav(addFav) ? new ResponseEntity<Boolean>(true, HttpStatus.OK) : new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
	}
	
	@DeleteMapping("/fav")
	public void deleteLove(@RequestBody Fav deleteFav) {
		System.out.println("DELETE");
		favService.removeFav(deleteFav);
	}
}