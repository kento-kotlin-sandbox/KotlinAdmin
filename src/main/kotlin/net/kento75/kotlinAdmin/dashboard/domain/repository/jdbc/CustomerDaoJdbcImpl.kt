package net.kento75.kotlinAdmin.dashboard.domain.repository.jdbc

import net.kento75.kotlinAdmin.dashboard.domain.model.Customer
import net.kento75.kotlinAdmin.dashboard.domain.repository.CustomerDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.util.*


@Repository("CustomerDaoJdbcImpl")
class CustomerDaoJdbcImpl: CustomerDao {

    @Autowired
    internal var jdbc: JdbcTemplate? = null

    // Userテーブルの件数を取得
    @Throws(DataAccessException::class)
    override fun count(): Int {

        // 全件取得してカウントする
        val count: Int = jdbc!!.queryForObject("SELECT COUNT(*) FROM customer", Int::class.java)!!

        return count
    }

    // Userテーブルにデータを１件insert
    @Throws(DataAccessException::class)
    override fun insertOne(customer: Customer): Int {
        return 0
    }

    // Userテーブルのデータを1件取得
    @Throws(DataAccessException::class)
    override fun selectOne(customerId: String): Customer {
        return Customer()
    }

    // Userテーブルの全データを取得
    @Throws(DataAccessException::class)
    override fun selectMany(): MutableList<Customer> {
        val customerList: MutableList<Customer> = ArrayList<Customer>()
        // m_userテーブルのデータを全件取得
        val getList: MutableList<MutableMap<String, Any>> = jdbc!!.queryForList("SELECT * FROM customer")

        for(map in getList) {

            // Customerインスタンス生成
            val customer: Customer = Customer()

            // Customerインスタンスに取得したデータをセットする
            // 顧客ID
            customer.customerId = map["customer_id"] as Short?
            // 顧客名
            customer.customerName = map["customer_name"] as String?
            // 住所
            customer.address = map["address"] as String?
            // 更新日
            customer.updatedAt = map["updated_at"] as Date?
            // 取引停止フラグ
            customer.deleteFlg = map["delete_flg"] as Boolean

            // 結果返却用のListに追加
            customerList.add(customer)
        }
        return customerList
    }

    // Userテーブルを1件更新
    @Throws(DataAccessException::class)
    override fun updateOne(customer: Customer): Int {
        return 0
    }

    // Userテーブルを1件削除
    @Throws(DataAccessException::class)
    override fun deleteOne(customerId: String): Int {
        return 0
    }

    // Userテーブルの全データをCSVに出力
    @Throws(DataAccessException::class)
    override fun userCsvOut() {

    }
}