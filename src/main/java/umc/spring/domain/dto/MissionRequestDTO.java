package umc.spring.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MissionRequestDTO {

    @NotNull(message = "가게 ID는 필수입니다")
    private Long storeId;

    @NotBlank(message = "미션 설명은 필수입니다")
    private String description;

    @NotBlank(message = "미션 제목은 필수입니다")
    private String title;

    @NotNull(message = "미션 점수는 필수입니다")
    @Min(value = 1, message = "미션 점수는 1점 이상이어야 합니다")
    @Max(value = 5, message = "미션 점수는 5점 이하여야 합니다")
    private Integer rewardPoint;


}