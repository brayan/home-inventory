package br.com.sailboat.homeinventory.ui.product.details

import android.content.Context
import br.com.sailboat.homeinventory.R
import br.com.sailboat.homeinventory.core.interactor.product.GetProduct
import br.com.sailboat.homeinventory.core.repository.ProductRepository
import br.com.sailboat.homeinventory.ui.model.ViewType
import br.com.sailboat.homeinventory.ui.model.LabelAndValueModel
import br.com.sailboat.homeinventory.ui.model.RecyclerViewItem
import br.com.sailboat.homeinventory.ui.model.TitleModel

class ProductDetailsLoader(
    private val context: Context,
    private val productRepository: ProductRepository
) {

    fun loadProductDetailsViews(productId: Long): List<RecyclerViewItem> {
        val product = GetProduct(productRepository, productId).execute()

        val productDetails = mutableListOf<RecyclerViewItem>()

        var title = TitleModel(
            ViewType.TITLE.ordinal,
            product.name
        )

        var label = LabelAndValueModel(
            ViewType.LABEL_VALUE.ordinal,
            context.getString(R.string.label_quantity),
            product.quantity.toString()
        )

        productDetails.add(title)
        productDetails.add(label)

        return productDetails
    }

}