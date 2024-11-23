package umc.spring.converter;

import umc.spring.domain.dto.StoreRequestDTO;
import umc.spring.domain.dto.StoreResponseDTO;
import umc.spring.domain.entity.Region;
import umc.spring.domain.entity.Store;
//import umc.spring.domain.enums.Gender;
//import umc.spring.practice.Member;
//import umc.spring.practice.dto.MemberRequestDTO;
//import umc.spring.practice.dto.MemberResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {
    public static Store toStore(StoreRequestDTO.createStore request, Region region) {
        return Store.builder()
                .region(region)
                .location(request.getLocation())
                .score(request.getScore())
                .name(request.getName())
                .build();
    }

    public static StoreResponseDTO.createResult toCreateStoreResponse(Store store) {
        return StoreResponseDTO.createResult.builder()
                .createdAt(LocalDateTime.now())
                .storeName(store.getName())
                .location(store.getLocation())
                .region(store.getRegion().getName())
                .build();
    }
}