package br.com.sailboat.homeinventory.ui.shopping

import br.com.sailboat.homeinventory.ui.base.BaseMvpContract
import br.com.sailboat.homeinventory.ui.model.ProductView
import br.com.sailboat.homeinventory.ui.model.RecyclerViewItem

interface ShoppingContract {

    interface View : BaseMvpContract.View {
        fun navigateToShoppingProduct(product: ProductView, quantity: Int)
        fun updateShoppingItems()
        fun hideShoppingItems()
        fun hideEmptyView()
        fun showShoppingItems()
        fun showEmptyView()
        fun showErrorLoadingProducts()
        fun showErrorCheckout()
    }

    interface Presenter : BaseMvpContract.Presenter {
        fun onClickCheckout()
        fun onAddProduct(productId: Long, quantity: Int)
        fun wasPurchased(productId: Long): Boolean
        fun getShoppingQuantity(productId: Long): String
        fun getShoppingItems(): List<RecyclerViewItem>
        fun onClickProduct(position: Int)
    }

}