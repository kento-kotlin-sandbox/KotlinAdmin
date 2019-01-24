package net.kento75.kotlinAdmin.dashboard.domain.service

import net.kento75.kotlinAdmin.dashboard.domain.model.Customer
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Transactional
@Service
class CustomerService {

    //@Autowired
    //@Qualifier("CustomerDaoJdbcImpl")
    //internal var dao: CustomerDao? = null

    // カウント用メソッド
    fun count(): Int {
        return 0
    }

    // 全件取得用メソッド
    //fun selectMany(): MutableList<Customer> {
    //    return
    //}
}

