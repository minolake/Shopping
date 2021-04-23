package com.vishalgaur.shoppingapp.database.products

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductsDao {
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insert(product: Product)

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertListOfProducts(products: List<Product>)

	@Query("SELECT * FROM products")
	fun getAllProducts(): List<Product>

	@Query("SELECT * FROM products WHERE productId = :proId")
	fun getProductById(proId: String): Product?

	@Query("SELECT * FROM products WHERE owner = :ownerId")
	fun getProductsByOwnerId(ownerId: String): LiveData<List<Product>>
}

//@Database(entities = [Product::class], version = 1)
//abstract class ProductsDatabase : RoomDatabase() {
//    abstract fun productsDao(): ProductsDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: ProductsDatabase? = null
//        fun getInstance(context: Context): ProductsDatabase =
//            INSTANCE ?: synchronized(this) {
//                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
//            }
//
//        private fun buildDatabase(context: Context) = Room.databaseBuilder(
//            context.applicationContext,
//            ProductsDatabase::class.java, ""
//        ).fallbackToDestructiveMigration().build()
//    }
//}