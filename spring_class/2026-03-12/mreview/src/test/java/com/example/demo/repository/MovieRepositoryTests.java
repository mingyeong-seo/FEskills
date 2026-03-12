package com.example.demo.repository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;

import com.example.demo.entity.Movie;
import com.example.demo.entity.MovieImage;
import com.example.demo.entity.Review;

import jakarta.transaction.Transactional;

@SpringBootTest
public class MovieRepositoryTests {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private MovieImageRepository movieImageRepository;

//	@Commit
//	@Transactional
//	@Test
	public void insertMovies() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Movie movie = Movie.builder().title("영화......." + i).build();
			System.out.println("--------------------------------");
			movieRepository.save(movie);

			int count = (int) (Math.random() * 5) + 1;

			for (int j = 0; j < count; j++) {
				MovieImage movieImage = MovieImage.builder().uuid(UUID.randomUUID().toString()).movie(movie)
						.imgName("test" + j + ".jpg").build();
				movieImageRepository.save(movieImage);
			}
		});
	}

//	@Test 
	public void testListPage() {
		PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "mno"));
		Page<Object[]> result = movieRepository.getListPage(pageRequest);

		for (Object[] objects : result.getContent()) {
			System.out.println(Arrays.toString(objects));
		}
	}

//	@Test
	public void testGetMovieWithAll() {

		List<Object[]> result = movieRepository.getMovieWithAll(1L);

		for (Object[] arr : result) {
			System.out.println(Arrays.toString(arr));
		}
	}
	
	@Test
	public void testGetMovieReviews() {
		
		Movie movie = Movie.builder().mno(50L).build();
		
		List<Review> result = reviewRepository.findByMovie(movie);
		
		result.forEach(review -> {
			System.out.println(review.getText());
		});
    }
	
	
}
