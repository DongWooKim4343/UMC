package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.domain.dto.StoreRequestDTO;
import umc.spring.domain.dto.StoreResponseDTO;
import umc.spring.service.StoreServiceImpl;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
@Tag(name = "가게", description = "가게 CRUD")
public class StoreRestController {
    private final StoreServiceImpl storeService;

    @PostMapping
    public ResponseEntity<StoreResponseDTO.createResult> createStore(@Valid @RequestBody StoreRequestDTO.createStore storeRequestDTO) {
        StoreResponseDTO.createResult store = storeService.createStore(storeRequestDTO);
        return ResponseEntity.ok(store);
    }
}

