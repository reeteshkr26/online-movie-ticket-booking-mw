package com.cg.omtb.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.omtb.model.TheaterModel;

@FeignClient(name="theatre-service")
@RibbonClient(name="theatre-service")
public interface TheaterProxyService {

	@GetMapping("/api/theaters/{theatreId}")
    public TheaterModel getTheatre(@PathVariable(name="theatreId") Integer theatreId);
}
