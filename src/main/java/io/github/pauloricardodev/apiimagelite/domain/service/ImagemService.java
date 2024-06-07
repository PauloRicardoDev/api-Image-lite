package io.github.pauloricardodev.apiimagelite.domain.service;

import io.github.pauloricardodev.apiimagelite.domain.entity.Image;
import io.github.pauloricardodev.apiimagelite.domain.enums.ImageExtension;

import java.util.List;
import java.util.Optional;

public interface ImagemService {
    Image save(Image image);
    Optional<Image> getById(String id);
    List<Image> search(ImageExtension extension, String query);
}
