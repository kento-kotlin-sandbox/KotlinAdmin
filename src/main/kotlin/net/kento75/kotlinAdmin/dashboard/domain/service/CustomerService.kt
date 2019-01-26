package net.kento75.kotlinAdmin.dashboard.domain.service

import net.kento75.kotlinAdmin.dashboard.domain.model.Customer
import net.kento75.kotlinAdmin.dashboard.domain.repository.CustomerDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Transactional
@Service
class CustomerService {

    @Autowired
    @Qualifier("CustomerDaoJdbcImpl")
    internal var dao: CustomerDao? = null

    // カウント用メソッド
    fun count(): Int {
        return dao!!.count()
    }

    // 全件取得用メソッド
    fun selectMany(): MutableList<Customer> {
        return dao!!.selectMany()!!
    }
}

