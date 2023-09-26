package com.example.animeWorld.service;

import org.springframework.stereotype.Service;

import com.example.animeWorld.entita.sicurezza;
import com.example.animeWorld.ripo.ripository;

@Service
public class servo {

	private ripository ripo;
	
	public boolean verify(String username ,String password) {
		sicurezza utente = ripo.findByUser(username);
		if(utente != null && utente.getPassword().equals(password)&& utente.isEnabled()) {
			return true;
		}
		return false;
	}
}
