package umc.spring.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFoodCategory is a Querydsl query type for FoodCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodCategory extends EntityPathBase<FoodCategory> {

    private static final long serialVersionUID = 306557883L;

    public static final QFoodCategory foodCategory = new QFoodCategory("foodCategory");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> foodCategoryId = createNumber("foodCategoryId", Long.class);

    public final StringPath foodCategoryName = createString("foodCategoryName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.spring.domain.mapping.UserFood, umc.spring.domain.mapping.QUserFood> userFoodList = this.<umc.spring.domain.mapping.UserFood, umc.spring.domain.mapping.QUserFood>createList("userFoodList", umc.spring.domain.mapping.UserFood.class, umc.spring.domain.mapping.QUserFood.class, PathInits.DIRECT2);

    public QFoodCategory(String variable) {
        super(FoodCategory.class, forVariable(variable));
    }

    public QFoodCategory(Path<? extends FoodCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFoodCategory(PathMetadata metadata) {
        super(FoodCategory.class, metadata);
    }

}

