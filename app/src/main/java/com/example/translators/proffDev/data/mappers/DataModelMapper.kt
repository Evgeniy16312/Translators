package com.example.translators.proffDev.data.mappers

import com.example.translators.proffDev.data.model.DataModelResponse
import com.example.translators.proffDev.domain.model.search.DataModel


class DataModelMapper(private val meaningsMapper: MeaningsMapper) {

    fun toDomain(dataModelResponse: DataModelResponse): DataModel {

        requireNotNull(dataModelResponse.meanings)

        return DataModel.of(
            dataModelResponse.text,
            meaningsMapper.toDomain(dataModelResponse.meanings)
        )
    }
}