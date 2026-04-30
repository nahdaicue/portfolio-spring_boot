package com.nahuelcuello.portfolio.services.portfolioService;

import com.nahuelcuello.portfolio.services.portfolioService.PortfolioService;
import com.nahuelcuello.portfolio.DTO.portfolioDTO.PortfolioDTO;
import com.nahuelcuello.portfolio.entitys.User;
import com.nahuelcuello.portfolio.mapper.UserMapper;
import com.nahuelcuello.portfolio.entitys.Profile;
import com.nahuelcuello.portfolio.mapper.ProfileMapper;
import com.nahuelcuello.portfolio.repository.ProfileRepository;
import com.nahuelcuello.portfolio.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    @Override
    @Transactional(readOnly = true)
    public PortfolioDTO getPortfolio() {
        User user = userRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Profile profile = profileRepository.findByUserId(1L)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));

        PortfolioDTO portfolioDTO = new PortfolioDTO();
        portfolioDTO.setUser(UserMapper.toDto(user));
        portfolioDTO.setProfile(ProfileMapper.toDto(profile));

        return portfolioDTO;
    }
}