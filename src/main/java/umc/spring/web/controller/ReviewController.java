package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.domain.dto.ReviewRequestDTO;
import umc.spring.domain.dto.ReviewResponseDTO;
import umc.spring.service.ReviewServiceImpl;
import umc.spring.validation.ExistStores;

// ReviewController.java
@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
@Tag(name = "리뷰", description = "리뷰 CRUD")
public class ReviewController {
    private final ReviewServiceImpl reviewService;

    @PostMapping("/store/{storeId}")
    public ResponseEntity<ReviewResponseDTO> createReview(
            @PathVariable @ExistStores Long storeId,
            @Valid @RequestBody ReviewRequestDTO requestDto) {
        ReviewResponseDTO review = reviewService.createReview(storeId, requestDto);
        return ResponseEntity.ok(review);
    }
}