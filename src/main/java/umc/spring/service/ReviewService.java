package umc.spring.service;

import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.dto.ReviewRequestDTO;
import umc.spring.domain.dto.ReviewResponseDTO;

public interface ReviewService {
    ReviewResponseDTO createReview(Long storeId, ReviewRequestDTO requestDto);
}
