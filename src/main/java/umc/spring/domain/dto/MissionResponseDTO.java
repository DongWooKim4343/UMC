package umc.spring.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MissionResponseDTO {
    private Long missionId;
    private String missionName;
    private String description;
    private Integer rewardPoint;
    private Long storeId;
}