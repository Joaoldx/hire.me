package com.example.shortener.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shortener.exceptions.ObjNotFoundException;
import com.example.shortener.repositories.UrlRepository;
import com.example.shortener.model.UrlModel;

@Service
public class UrlService {
	
	@Autowired
	private UrlRepository urlRepository;
	
//	public Url find(Long id) {
//		Optional<Url> obj = urlRepository.findById(id);
//		return obj.orElseThrow(() -> new ObjNotFoundException(
//				"Objeto não encontrado! Id: " + id + ", Tipo: " + Url.class.getName()));
//	}

}
