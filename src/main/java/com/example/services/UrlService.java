package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.ObjNotFoundException;
import com.example.repositories.UrlRepository;
import com.example.shortener.domain.Url;

@Service
public class UrlService {
	
	@Autowired
	private UrlRepository urlRepository;
	
	public Url find(Integer id) {
		Optional<Url> obj = urlRepository.findById(id);
		return obj.orElseThrow(() -> new ObjNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Url.class.getName()));
	}

}
