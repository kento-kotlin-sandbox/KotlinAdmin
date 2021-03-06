package net.kento75.kotlinAdmin.login.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping


@Controller
class LoginController {

    // ログイン画面のGET用コントローラー
    @GetMapping("/")
    fun getRoot(model: Model): String {

        // login.htmlに画面遷移
        return "redirect:/login"
    }

    // ログイン画面のGET用コントローラー
    @GetMapping("/login")
    fun getLogin(model: Model): String {

        // login.htmlに画面遷移
        return "login/login"
    }

    // ログイン画面のPOST用コントローラー
    @PostMapping("/login")
    fun postLogin(model: Model): String {

        // ホーム画面に遷移
        return "redirect:/home"
    }
}