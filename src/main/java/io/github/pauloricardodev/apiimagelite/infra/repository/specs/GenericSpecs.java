package io.github.pauloricardodev.apiimagelite.infra.repository.specs;

import org.springframework.data.jpa.domain.Specification;

public class GenericSpecs {
    public GenericSpecs() {
    }

    public static <T> Specification<T> conjunction(){
        return (root, q, criteraBuilder) -> criteraBuilder.conjunction();
    }
}
