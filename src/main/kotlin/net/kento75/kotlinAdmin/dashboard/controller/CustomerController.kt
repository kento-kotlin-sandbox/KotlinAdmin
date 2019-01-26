package net.kento75.kotlinAdmin.dashboard.controller

import net.kento75.kotlinAdmin.dashboard.domain.model.Customer
import net.kento75.kotlinAdmin.dashboard.domain.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class CustomerController {

    @Autowired
    internal var customerService: CustomerService? = null

    @GetMapping("/customer")
    fun getCustomer(model: Model): String {
        // コンテンツ部分に顧客一覧を表示するための文字列を登録
        model.addAttribute("contents", "dashboard/customerList::customerList_contents")

        // 顧客一覧の生成
        val customerList: MutableList<Customer> = customerService!!.selectMany()

        // Modelに顧客リストを登録
        model.addAttribute("customerList", customerList)

        // データ件数を取得
        val count: Int = customerService!!.count()

        model.addAttribute("customerListCount", count)

        return "dashboard/homeLayout"
    }

    @GetMapping("/sales")
    fun getSales(model: Model): String {
        // コンテンツ部分にユーザー詳細を表示するための文字列を登録
        model.addAttribute("contents", "dashboard/sales::sales_contents")

        // レイアウト用テンプレート
        return "dashboard/homeLayout"
    }
}
