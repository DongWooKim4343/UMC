package umc.spring.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


// Request DTO
public class StoreRequestDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createStore {
        @NotNull
        private Long regionId;

        @NotNull
        private String location;

        @NotNull
        private String name;

        private Float score;


    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MenuRequestDTO {
        private String name;
        private Integer price;
        private String description;
    }
}
