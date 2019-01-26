package net.kento75.kotlinAdmin.dashboard.domain.repository

import net.kento75.kotlinAdmin.dashboard.domain.model.Customer
import org.springframework.dao.DataAccessException


interface CustomerDao {

    // Userテーブルの件数を取得
    @Throws(DataAccessException::class)
    fun count(): Int

    // 顧客テーブルにデータを１件Insert
    @Throws(DataAccessException::class)
    fun insertOne(customer: Customer): Int

    // 顧客検索
    @Throws(DataAccessException::class)
    fun selectOne(customerId: String): Customer

    // 顧客全件取得
    @Throws(DataAccessException::class)
    fun selectMany(): MutableList<Customer>

    // 顧客情報アップデート
    @Throws(DataAccessException::class)
    fun updateOne(customer: Customer): Int

    // 顧客情報削除(論理)
    @Throws(DataAccessException::class)
    fun deleteOne(customerId: String): Int

    // 顧客情報ファイル出力
    @Throws(DataAccessException::class)
    fun userCsvOut()


}