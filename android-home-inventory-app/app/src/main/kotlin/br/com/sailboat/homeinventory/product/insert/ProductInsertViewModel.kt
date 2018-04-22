package br.com.sailboat.homeinventory.view.product.insert

import br.com.sailboat.canoe.helper.EntityHelper

class ProductInsertViewModel {

    var productId: Long = EntityHelper.NO_ID
    var name: String = ""
    var quantity: Int = 0
}