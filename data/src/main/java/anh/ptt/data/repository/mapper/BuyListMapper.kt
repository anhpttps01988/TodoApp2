package anh.ptt.data.repository.mapper

import anh.ptt.core.BaseMapper
import anh.ptt.data.datasource.remote.model.response.BuyResponse
import anh.ptt.domain.entities.BuyEntity

class BuyListMapper : BaseMapper<List<BuyResponse>, List<BuyEntity>>{

    override fun map(type: List<BuyResponse>?): List<BuyEntity> {
        return type?.map {
            BuyEntity(
                id = it.id ?: -1,
                name = it.name ?: "",
                price = it.price ?: 0f,
                quantity = it.quantity ?: -1,
                type = it.type ?: -1
            )
        } ?: listOf()
    }
}