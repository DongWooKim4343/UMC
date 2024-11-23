package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.domain.repository.StoreRepository;
import umc.spring.validation.ExistStores;

@Component
@RequiredArgsConstructor
public class StoreExistsValidator implements ConstraintValidator<ExistStores, Long> {

    private final StoreRepository storeRepository;

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        if (storeId == null) return false;
        return storeRepository.existsById(storeId);
    }
}