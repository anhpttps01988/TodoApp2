package anh.ptt.data.repository.mapper

import anh.ptt.core.BaseMapper
import anh.ptt.data.datasource.remote.model.response.CallResponse
import anh.ptt.domain.entities.CallEntity

class CallListMapper : BaseMapper<List<CallResponse>, List<CallEntity>>{

    override fun map(type: List<CallResponse>?): List<CallEntity> {
        return type?.map {
            CallEntity(
                id = it.id ?: -1,
                name = it.name ?: "",
                number = it.number ?: 0
            )
        } ?: listOf()
    }
}