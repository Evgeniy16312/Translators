package com.example.translators.presentation.data.mappers

import com.example.translators.presentation.data.model.DataModelResponse
import com.example.translators.presentation.domain.model.DataModel


class DataModelMapper(private val meaningsMapper: MeaningsMapper) {

    fun toDomain(dataModelResponse: DataModelResponse): DataModel {

        requireNotNull(dataModelResponse.meanings)

        return DataModel.of(
            dataModelResponse.text,
            meaningsMapper.toDomain(dataModelResponse.meanings)
        )
    }
}