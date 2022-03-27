package anh.ptt.data.repository.mapper

import anh.ptt.core.BaseMapper
import anh.ptt.data.datasource.local.model.SellLocalModel
import anh.ptt.domain.entities.SellEntity

class SellListMapper :
    BaseMapper<List<SellLocalModel>, List<SellEntity>> {

    override fun map(type: List<SellLocalModel>?): List<SellEntity> {
        return type?.map {
            SellEntity(
                id = it.id,
                name = it.name,
                price = it.price,
                quantity = it.quantity,
                type = it.type
            )
        } ?: listOf()
    }

}