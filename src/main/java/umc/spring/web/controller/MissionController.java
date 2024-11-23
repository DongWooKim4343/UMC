package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.domain.dto.MissionRequestDTO;
import umc.spring.domain.dto.MissionResponseDTO;
import umc.spring.service.MissionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
@Tag(name = "미션", description = "미션 CRUD")
public class MissionController {
    private final MissionService missionService;

    @PostMapping
    public ResponseEntity<MissionResponseDTO> createMission(@Valid @RequestBody MissionRequestDTO request
    ) {
        MissionResponseDTO response = missionService.addMission(request);
        return ResponseEntity.ok(response);
    }
}