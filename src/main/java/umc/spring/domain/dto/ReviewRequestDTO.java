package umc.spring.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ReviewRequestDTO {
    @NotBlank(message = "리뷰 내용은 필수입니다.")
    private String description;

    @NotNull(message = "점수는 필수입니다.")
    @Min(1)
    @Max(5)
    private Integer score;
}