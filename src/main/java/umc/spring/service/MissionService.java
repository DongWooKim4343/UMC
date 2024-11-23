package umc.spring.service;

import umc.spring.domain.dto.MissionRequestDTO;
import umc.spring.domain.dto.MissionResponseDTO;

public interface MissionService {
    MissionResponseDTO addMission(MissionRequestDTO request);
}
