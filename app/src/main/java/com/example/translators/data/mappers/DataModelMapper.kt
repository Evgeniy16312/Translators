package com.example.translators.data.mappers

import com.example.translators.data.model.DataModelResponse
import com.example.translators.domain.model.DataModel


class DataModelMapper(private val meaningsMapper: MeaningsMapper) {

    fun toDomain(dataModelResponse: DataModelResponse): DataModel {

        requireNotNull(dataModelResponse.meanings)

        return DataModel.of(
            dataModelResponse.text,
            meaningsMapper.toDomain(dataModelResponse.meanings)
        )
    }
}