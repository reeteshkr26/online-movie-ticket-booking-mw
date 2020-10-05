package com.cg.omtb.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.omtb.model.ShowModel;

@FeignClient(name="show-service")
@RibbonClient(name="show-service")
public interface ShowProxyService {

		@GetMapping("/api/shows/getshow/{showId}")
	    public ShowModel getShow(@PathVariable(name="showId") Integer showId);
	
}
