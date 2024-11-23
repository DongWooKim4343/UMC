package umc.spring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
//import umc.spring.apiPayload.code.status.ErrorStatus;
//import umc.spring.apiPayload.code.status.GeneralException;
//import umc.spring.apiPayload.exception.handler.ErrorHandler;
import umc.spring.apiPayload.realException.exception.ErrorCode;
import umc.spring.apiPayload.realException.exception.UMCCustomException;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.dto.StoreRequestDTO;
import umc.spring.domain.dto.StoreResponseDTO;
import umc.spring.domain.entity.Region;
import umc.spring.domain.entity.Store;
import umc.spring.domain.repository.RegionRepository;
import umc.spring.domain.repository.UserRepository;
import umc.spring.domain.repository.StoreRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final UserRepository userRepository;

    //특정 지역에 가게 추가하기
    @Override
    public StoreResponseDTO.createResult createStore(StoreRequestDTO.createStore storeRequestDTO) {
        try {
            // regionId로 Region 엔티티 조회
            Region region = regionRepository.findById(storeRequestDTO.getRegionId())
                    .orElseThrow(() -> new UMCCustomException(ErrorCode.REGION_NOT_FOUND));
            Store store = StoreConverter.toStore(storeRequestDTO,region);
            storeRepository.save(store);
            return StoreConverter.toCreateStoreResponse (store);

        }catch (RuntimeException e) {
            log.error("createStore error: {}",  e.getMessage());
            throw new UMCCustomException(ErrorCode.STORE_CREATE_FAIL);
        }


    }

}
