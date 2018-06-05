package com.example.shortener.repositories;

import com.example.shortener.model.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UrlRepository extends CrudRepository<UrlModel, String> {
    UrlModel findItemById(Long id);
}
