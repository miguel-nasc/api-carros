package com.projeto.Carros.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import java.util.List;

public class ObjectMapper {

    private final static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <X, Y> Y parseObject(X origin,
                                Class<Y> destination) {
        return mapper.map(origin, destination);
    }

    public static <X, Y> List<Y> parseListObjects(List<X> origins,
                                           Class<Y> destine) {
        return origins.stream()
                        .map(origin -> parseObject(origin, destine))
                        .toList();
    }


}
