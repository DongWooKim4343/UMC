package umc.spring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.realException.exception.ErrorCode;
import umc.spring.apiPayload.realException.exception.UMCCustomException;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.dto.ReviewRequestDTO;
import umc.spring.domain.dto.ReviewResponseDTO;
import umc.spring.domain.entity.Review;
import umc.spring.domain.entity.Store;
import umc.spring.domain.entity.User;
import umc.spring.domain.repository.ReviewRepository;
import umc.spring.domain.repository.StoreRepository;
import umc.spring.domain.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Override
    public ReviewResponseDTO createReview(Long storeId, ReviewRequestDTO requestDto) {

        try {
            // 임시로 첫 번째 유저를 가져옴 (실제로는 로그인된 유저를 사용해야 함)
            User user = userRepository.findById(1L)
                    .orElseThrow(() -> new UMCCustomException(ErrorCode.MEMBER_NOT_FOUND));

            Store store = storeRepository.findById(storeId)
                    .orElseThrow(() -> new UMCCustomException(ErrorCode.STORE_NOT_FOUND));

            Review review = ReviewConverter.toEntity(requestDto, user, store);
            Review savedReview = reviewRepository.save(review);

            return ReviewConverter.toDto(savedReview);
        }catch (RuntimeException e) {
            log.error("createReview error: {}",  e.getMessage());
            throw new UMCCustomException(ErrorCode.REVIEW_CREATE_FAIL);
        }

    }
}
