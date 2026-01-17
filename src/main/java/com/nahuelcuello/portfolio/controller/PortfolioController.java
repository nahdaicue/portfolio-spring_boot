
package com.nahuelcuello.portfolio.controller;

import com.nahuelcuello.portfolio.DTO.portfolioDTO.PortfolioDTO;
import com.nahuelcuello.portfolio.services.PortfolioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/portfolio")
@CrossOrigin(origins = "*")
public class PortfolioController {
    
    private final PortfolioService portfolioService;
    
    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }
    
    @GetMapping
    public ResponseEntity<PortfolioDTO> getPortfolio() {
        PortfolioDTO portfolio = portfolioService.getPortfolio();
        return new ResponseEntity<>(portfolio, HttpStatus.OK);
    }
}
