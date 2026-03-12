package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.MovieImage;

public interface MovieImageRepository extends JpaRepository<MovieImage, Long> {

}
