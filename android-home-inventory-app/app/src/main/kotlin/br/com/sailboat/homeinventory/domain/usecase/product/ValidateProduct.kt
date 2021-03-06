package br.com.sailboat.homeinventory.domain.usecase.product

import br.com.sailboat.homeinventory.domain.entity.Product
import br.com.sailboat.homeinventory.domain.usecase.UseCase
import javax.inject.Inject

class ValidateProduct @Inject constructor() : UseCase<Product, List<ValidateProduct.InvalidFields>>() {

    override fun execute(product: Product): List<InvalidFields> {
        val invalidFields = mutableListOf<InvalidFields>()
        validateName(product, invalidFields)
        validateQuantity(product, invalidFields)

        return invalidFields
    }

    private fun validateName(product: Product, invalidFields: MutableList<InvalidFields>) {
        if (product.name.trim().isBlank()) {
            invalidFields.add(InvalidFields.NAME_NOT_FILLED)
        }
    }

    private fun validateQuantity(product: Product, invalidFields: MutableList<InvalidFields>) {
        if (product.quantity < 0) {
            invalidFields.add(InvalidFields.QUANTITY_NEGATIVE)
        }
    }

    enum class InvalidFields {
        NAME_NOT_FILLED, QUANTITY_NEGATIVE
    }


}