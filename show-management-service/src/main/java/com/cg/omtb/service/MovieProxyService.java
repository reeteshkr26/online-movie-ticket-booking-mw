package com.cg.omtb.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.omtb.model.MovieModel;

@FeignClient(name="movie-service")
@RibbonClient(name="movie-service")
public interface MovieProxyService {

	@GetMapping("/api/movies/{movieId}")
    public MovieModel getMovie(@PathVariable(name="movieId") Integer id);
}
