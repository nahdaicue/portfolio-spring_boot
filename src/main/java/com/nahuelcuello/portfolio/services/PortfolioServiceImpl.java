package com.nahuelcuello.portfolio.services;

import com.nahuelcuello.portfolio.DTO.portfolioDTO.PortfolioDTO;
import com.nahuelcuello.portfolio.DTO.user.UserDTO;
import com.nahuelcuello.portfolio.entitys.User;
import com.nahuelcuello.portfolio.mapper.UserMapper;
import com.nahuelcuello.portfolio.repositorys.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PortfolioServiceImpl implements PortfolioService {
    
    private final UserRepository userRepository;
    
    public PortfolioServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    @Transactional(readOnly = true)
    public PortfolioDTO getPortfolio() {
        User user = userRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        UserDTO userDTO = UserMapper.toDto(user);
        
        PortfolioDTO portfolioDTO = new PortfolioDTO();
        portfolioDTO.setUser(userDTO);
        
        return portfolioDTO;
    }
}