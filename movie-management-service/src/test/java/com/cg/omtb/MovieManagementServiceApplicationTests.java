/**********************************************************************************************************************************
 -File Name         :   MovieManagementServiceApplicationTests
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   23-09-2020
 -Description       :   This class is to test all the test cases.
 **********************************************************************************************************************************/
package com.cg.omtb;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.omtb.dao.MovieRepository;
import com.cg.omtb.entity.MovieEntity;
import com.cg.omtb.exception.MovieException;
import com.cg.omtb.model.MovieModel;
import com.cg.omtb.service.MovieService;

@SpringBootTest
@RunWith(SpringRunner.class)
class MovieManagementServiceApplicationTests {

	@Autowired
	private MovieService service;
	
	@MockBean
	private MovieRepository repo;
	
	/*
	 * To test addMovie() method if no exception throw
	 */
	@Test
	public void addMovieTest() throws MovieException {
		MovieEntity movieM=service.of(getMovie());
		when(repo.save(movieM)).thenReturn(movieM);
	
		MovieModel movieModel=service.addMovie(movieM);
		assertEquals(movieM.getMovieId(),movieModel.getMovieId());
	}

	/*
	 * To test addMovie() method when NullPointerException throw
	 */
	@Test
	public void testAddMovie_NullPointerException() {
	
		MovieException exception=assertThrows(MovieException.class,
				()->{
					service.addMovie(null);
				}
		);
		assertEquals("Movie Should not be null",exception.getMessage());
	}
	
	/*
	 * To test addMovie() method when movie already exist
	 */
	@Test
	public void testAddMovie_MovieAlreadyExist()  {
		 MovieEntity movie=service.of(getMovie());
		 
		
		
		MovieException exception=assertThrows(MovieException.class,
				()->{
					when(repo.findByMovieName(anyString())).thenReturn(movie);
					service.addMovie(movie);
				}
		);
		assertEquals("This Movie already exist",exception.getMessage());
	}
	
	/*
	 * To test deleteMovie() method if no exception throw
	 */
	@Test
	public void deleteMovieTest() throws MovieException {
		when(repo.existsById(anyInt())).thenReturn(true);
		service.deleteMovie(1011);
		verify(repo,times(1)).deleteById(anyInt());
	}
	
	/*
	 * To test deleteMovie() method when movie id will be empty
	 */
	@Test
	public void deleteMovieTestByEmptyMovieId() {
		
		MovieException exception=assertThrows(MovieException.class,
				()->{
					service.deleteMovie(null);;
				}
		);
		assertEquals("Movie id should not be null",exception.getMessage());
	}
	
	/*
	 * To test deleteMovie() method when movie does not exist
	 */
	@Test
	public void testDeleteMovie_MovieNotExist()  {
		
		
		
		Exception exception=assertThrows(MovieException.class,
				()->{
					when(!repo.existsById(anyInt())).thenReturn(false);
					service.deleteMovie(1011);
				}
	
		);
		assertEquals("Movie Id is not exist!",exception.getMessage());
	}
	
	/*
	 * To test findeMovie() method when if no exception will throw
	 */
	@Test
	public void findMovieTest() throws MovieException {
		MovieEntity movie=service.of(getMovie());
		
			
		when(repo.findByMovieName(anyString())).thenReturn(movie);
		MovieModel movieModel=service.findMovie("Fast & Furious");
		
		assertNotNull(movieModel);
		assertEquals("Fast & Furious", movieModel.getMovieName());
	}
	
	/*
	 * To test findeMovie() method when movie name will be blank
	 */
	@Test
	public void findMovieTestByEmptyMovieName(){
	
		MovieException exception=assertThrows(MovieException.class,
				()->{
					service.findMovie(null);
				}
		);
		assertEquals("Movie name should not be empty",exception.getMessage());
	}
	
	/*
	 * To test findeMovie() method when movie does not exist
	 */
	@Test
	public void testFindMovie_MovieNotExist(){
		
		
		
		Exception exception=assertThrows(MovieException.class,
				()->{
					when(repo.findByMovieName(anyString())).thenReturn(null);
					service.findMovie("Hero");
				}
		);

		assertEquals("Movie Not found",exception.getMessage());
	}
	
	/*
	 * To test findeMovieById() method when if no exception will throw
	 */
	@Test
	public void findMovieByIdTest() throws MovieException {
		MovieEntity movie=service.of(getMovie());
		
		when(repo.findByMovieId(anyInt())).thenReturn(movie);
		MovieModel movieModel=service.findMovieById(1234);
		assertNotNull(movieModel);
		assertEquals("Fast & Furious", movieModel.getMovieName());
	}
	
	/*
	 * To test findeMovieById() method when movie id will be null
	 */
	@Test
	public void findMovieByIdTestByEmptyMovieId(){
	
		MovieException exception=assertThrows(MovieException.class,
				()->{
					service.findMovieById(null);
				}
		);
		assertEquals("Movie id should not be null",exception.getMessage());
	}
	
	/*
	 * To test findeMovieById() method when if movie does not exist
	 */
	@Test
	public void testFindMovieByID_MovieNotExist(){
		
		
		
		Exception exception=assertThrows(MovieException.class,
				()->{
					when(repo.findByMovieId(anyInt())).thenReturn(null);
					service.findMovieById(1234);
				}
		);
		assertEquals("Movie Not found",exception.getMessage());
	}
	
	/*
	 * To return object of MovieModel
	 */
	public MovieModel getMovie() {
		List<String> language=new ArrayList<>();
		language.add("Hindi");
		language.add("English");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDate date = LocalDate.parse("29-Mar-2019", formatter);
		MovieModel movieModel=new MovieModel();
		movieModel.setMovieId(1011);
		movieModel.setMovieName("Fast & Furious");
		movieModel.setReleasedDate(date);
		movieModel.setMovieDirector("James Wan");
		movieModel.setMovieLength(2);
		movieModel.setMovieLanguage(language);
		movieModel.setMovieRating(5);
		
		return movieModel;
	}


}
