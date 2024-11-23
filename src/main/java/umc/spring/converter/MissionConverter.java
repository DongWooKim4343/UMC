package umc.spring.converter;

import umc.spring.domain.dto.MissionRequestDTO;
import umc.spring.domain.dto.MissionResponseDTO;
import umc.spring.domain.entity.Mission;
import umc.spring.domain.entity.Store;
import umc.spring.domain.entity.User;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO request, Store store) {
        return Mission.builder()
                .description(request.getDescription())
                .title(request.getTitle())
                .rewardPoint(request.getRewardPoint())
                .store(store)
                .build();
    }

    public static MissionResponseDTO toResponse(Mission mission) {
        return new MissionResponseDTO(
                mission.getMissionId(),
                mission.getDescription(),
                mission.getTitle(),
                mission.getRewardPoint(),
                mission.getStore().getStoreId()
        );
    }
}