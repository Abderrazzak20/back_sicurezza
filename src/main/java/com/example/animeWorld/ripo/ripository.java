package com.example.animeWorld.ripo;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.animeWorld.entita.sicurezza;

public interface ripository extends JpaRepositoryImplementation<sicurezza, Long> {


	sicurezza findByUser(String username);



}

