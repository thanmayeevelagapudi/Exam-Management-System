package com.project.quiz_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.quiz_service.Dto.categoryDto;
@FeignClient(name = "category-service", url = "http://localhost:9006")  // URL of the category service
public interface CategoryClient {
	@GetMapping("/category/{cid}")
    categoryDto getCategoryById(@PathVariable("cid") Long cid);

}







    

