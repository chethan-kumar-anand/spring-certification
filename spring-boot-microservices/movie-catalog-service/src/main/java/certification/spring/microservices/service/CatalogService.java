package certification.spring.microservices.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import certification.spring.microservices.model.CatalogItem;
import certification.spring.microservices.model.Movie;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = "/catalog")
public class CatalogService {

    List<CatalogItem> catalogItems = Arrays.asList(
        new CatalogItem("100", "200", "4", 
            new Movie("500", "Om", "Shivanna as a gangster under Uppi direction")),
        new CatalogItem("101", "200", "3", 
            new Movie("501", "Jogi", "Shivanna as a gangster under Prem's direction"))
    );
    
    @GetMapping(path = "/{userId}")
    public List<CatalogItem> getMethodName(@RequestParam String userId) {
        return catalogItems.stream().filter(item -> item.getUserId().equals(userId)).collect(Collectors.toList());
    }
    
}
