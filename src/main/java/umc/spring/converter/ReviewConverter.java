package umc.spring.converter;

import umc.spring.domain.dto.ReviewRequestDTO;
import umc.spring.domain.dto.ReviewResponseDTO;
import umc.spring.domain.entity.Review;
import umc.spring.domain.entity.Store;
import umc.spring.domain.entity.User;

public class ReviewConverter {
    public static Review toEntity(ReviewRequestDTO dto, User user, Store store) {
        return Review.builder()
                .description(dto.getDescription())
                .score(dto.getScore())
                .user(user)
                .store(store)
                .build();
    }

    public static ReviewResponseDTO toDto(Review review) {
        return ReviewResponseDTO.builder()
                .reviewId(review.getReviewId())
                .description(review.getDescription())
                .score(review.getScore())
                .userId(review.getUser().getUserId())
                .storeId(review.getStore().getStoreId())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }
}