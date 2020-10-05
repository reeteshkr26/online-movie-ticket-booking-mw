package com.cg.omtb.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.omtb.model.ScreenModel;

@FeignClient(name="screen-service")
@RibbonClient(name="screen-service")
public interface ScreenProxyService {

	@GetMapping("/api/screens/{screenId}")
    public ScreenModel getScreen(@PathVariable(name="screenId") Integer screenId);
}
