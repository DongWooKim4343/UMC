package umc.spring.domain.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ReviewResponseDTO {
    private Long reviewId;
    private String description;
    private Integer score;
    private Long userId;
    private Long storeId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}