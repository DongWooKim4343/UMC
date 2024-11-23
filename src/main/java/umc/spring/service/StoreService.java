package umc.spring.service;

import umc.spring.domain.dto.StoreRequestDTO;
import umc.spring.domain.dto.StoreResponseDTO;

public interface StoreService {
    //특정 지역에 가게 추가하기
    StoreResponseDTO.createResult createStore(StoreRequestDTO.createStore storeRequestDTO);
}
