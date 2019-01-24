package net.kento75.kotlinAdmin.dashboard.domain.model

import java.util.Date


class Customer {

    // 顧客ID
    var customerId: String ? = null
    // 顧客名
    var customerName: String ? = null
    // 住所
    var address: String? = null
    // 更新日
    var updatedAt: Date? = null
    // 削除フラグ
    var deleteFlg: Boolean = false
}