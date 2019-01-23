package net.kento75.kotlinAdmin.dashboard.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping


@Controller
class HomeController {

    // ユーザー一覧画面のGET用メソッド
    @GetMapping("/home")
    fun getHome(model: Model): String {
        // コンテンツ部分にユーザー一覧を表示するための文字列を登録
        model.addAttribute("contents", "dashboard/home::home_contents")

        return "dashboard/homeLayout"
    }

    // ログアウト用メソッド
    @PostMapping("/logout")
    fun postLogout(): String {

        // ログイン画面にリダイレクト
        return "redirect:/login"
    }
}