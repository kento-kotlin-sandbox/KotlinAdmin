package net.kento75.kotlinAdmin.dashboard.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminController {

    // 管理者権限専用画面のGET用メソッド
    @GetMapping("/admin")
    fun getAdmin(model: Model): String {
        // コンテンツ部分にユーザー詳細を表示するための文字列を登録
        model.addAttribute("contents", "dashboard/admin::admin_contents")

        // レイアウト用テンプレート
        return "dashboard/homeLayout"
    }
}
