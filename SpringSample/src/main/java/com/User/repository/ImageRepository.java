package com.User.repository;

import com.User.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
   Image findByUsername(String username);
   Image deleteByUsername(String username);
}
