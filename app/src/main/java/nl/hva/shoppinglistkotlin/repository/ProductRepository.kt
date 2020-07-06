package nl.hva.shoppinglistkotlin.repository

import android.content.Context
import nl.hva.shoppinglistkotlin.dao.ProductDao
import nl.hva.shoppinglistkotlin.database.ShoppingListRoomDatabase
import nl.hva.shoppinglistkotlin.model.Product

class ProductRepository(context: Context) {

    private val productDao: ProductDao

    init {
        val database =
            ShoppingListRoomDatabase.getDatabase(
                context
            )
        productDao = database!!.productDao()
    }

    suspend fun getAllProducts(): List<Product> = productDao.getAllProducts()

    suspend fun insertProduct(product: Product) = productDao.insertProduct(product)

    suspend fun deleteProduct(product: Product) = productDao.deleteProduct(product)

    suspend fun deleteAllProducts() = productDao.deleteAllProducts()

}