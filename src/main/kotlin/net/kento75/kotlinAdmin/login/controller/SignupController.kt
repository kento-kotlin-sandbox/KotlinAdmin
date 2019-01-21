package net.kento75.kotlinAdmin.login.controller

import java.util.LinkedHashMap

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

import net.kento75.kotlinAdmin.login.domain.model.SignupForm


@Controller
class SignupController {

    // ラジオボタンの実装
    internal var radioMarriage: Map<String, String>? = null

    // ラジオボタンの初期化メソッド
    private fun initRadioMarriage(): Map<String, String> {
        val radio: MutableMap<String, String> = LinkedHashMap()

        // 既婚、未婚をMapに格納
        radio["既婚"] = "true"
        radio["未婚"] = "false"

        return radio
    }

    // データアクセス例外処理
    @ExceptionHandler(DataAccessException::class)
    fun dataAccessExceptionHandler(e: DataAccessException, model: Model): String {
        //　例外クラスのメッセージをModelに登録
        model.addAttribute("error", "内部サーバーエラー（DB）：ExceptionHandler")

        // 例外クラスのメッセージをModelに登録
        model.addAttribute("message", "SignupControllerでDataAccessExceptionが発生しました")

        // HTTPのエラーコード（500）をModelに登録
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR)

        return "error"
    }

    // 例外処理
    @ExceptionHandler(Exception::class)
    fun exceptionHandler(e: Exception, model: Model): String {
        // 例外クラスのメッセージをModelに登録
        model.addAttribute("error", "内部サーバーエラー：ExceptionHandler")

        // 例外クラスのメッセージをModelに登録
        model.addAttribute("message", "SignupControllerでExceptionが発生しました")

        // HTTPのエラーコード （500）をModelに登録
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR)

        return "error"
    }


    // ユーザー登録画面のGET用コントローラー
    @GetMapping("/signup")
    fun getSignUp(@ModelAttribute form: SignupForm, model: Model): String {

        // ラジオボタンの初期化メソッド呼び出し
        radioMarriage = initRadioMarriage()

        // ラジオボタン用のMapをModelに登録
        model.addAttribute("radioMarriage", radioMarriage)

        // signup.htmlに画面遷移
        return "login/signup"
    }

    // ユーザー登録画面のPOST用コントローラー
    @PostMapping("/signup")
    fun postSignUp(model: Model): String {

        // login.htmlにリダイレクト
        return "redirect:/login"
    }
}