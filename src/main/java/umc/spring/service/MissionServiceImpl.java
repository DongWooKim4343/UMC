package umc.spring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.realException.exception.ErrorCode;
import umc.spring.apiPayload.realException.exception.UMCCustomException;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.dto.MissionRequestDTO;
import umc.spring.domain.dto.MissionResponseDTO;
import umc.spring.domain.entity.Mission;
import umc.spring.domain.entity.Store;
import umc.spring.domain.entity.User;
import umc.spring.domain.repository.MissionRepository;
import umc.spring.domain.repository.StoreRepository;
import umc.spring.domain.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MissionServiceImpl implements MissionService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Override
    public MissionResponseDTO addMission(MissionRequestDTO request) {
        try {
            // 하드코딩된 유저 (예시로 ID가 1인 유저를 사용)
            User user = userRepository.findById(1L)
                    .orElseThrow(() -> new UMCCustomException(ErrorCode.MEMBER_NOT_FOUND));

            // 가게 조회
            Store store = storeRepository.findById(request.getStoreId())
                    .orElseThrow(() -> new UMCCustomException(ErrorCode.STORE_NOT_FOUND));

            // 중복 미션 검증
            if (missionRepository.existsByStoreAndDescription(store, request.getDescription())) {
                throw new UMCCustomException(ErrorCode.DUPLICATE_MISSION);
            }

            // 미션 생성 및 저장
            Mission mission = MissionConverter.toMission(request, store);
            Mission savedMission = missionRepository.save(mission);

            return MissionConverter.toResponse(savedMission);

        }catch (RuntimeException e) {
            log.error("createMission error: {}", e.getMessage());
            throw new UMCCustomException(ErrorCode.MISSION_CREATE_FAIL);
        }

    }
}