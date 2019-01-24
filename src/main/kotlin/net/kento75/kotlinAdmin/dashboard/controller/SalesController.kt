package net.kento75.kotlinAdmin.dashboard.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class SalesController {

    @GetMapping("/customer")
    fun getCustomer(model: Model): String {
        // コンテンツ部分に顧客一覧を表示するための文字列を登録
        model.addAttribute("contents", "dashboard/customerList::customerList_contents")

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
