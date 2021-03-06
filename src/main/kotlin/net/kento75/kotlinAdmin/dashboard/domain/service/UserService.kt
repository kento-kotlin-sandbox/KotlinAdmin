package net.kento75.kotlinAdmin.dashboard.domain.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import net.kento75.kotlinAdmin.dashboard.domain.model.User
import net.kento75.kotlinAdmin.dashboard.domain.repository.UserDao
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.transaction.annotation.Transactional


@Transactional
@Service
class UserService {

    @Autowired
    @Qualifier("UserDaoJdbcImpl")
    internal var dao: UserDao? = null

    // insert用メソッド
    fun insert(user: User): Boolean {

        // insert実行
        val rowNumber: Int = dao!!.insertOne(user)

        var result = false

        if(rowNumber > 0) {
            result = true
        }

        return result
    }

    // カウント用メソッド
    fun count(): Int {
        return dao!!.count()
    }

    // 全件取得用メソッド
    fun selectMany(): MutableList<User> {
        return dao!!.selectMany()!!
    }

    // 1件取得用メソッド
    fun selectOne(userId: String): User {
        return dao!!.selectOne(userId)!!
    }

    // 1件更新メソッド
    fun updateOne(user: User): Boolean {

        // 1件更新
        val rowNumber: Int = dao!!.updateOne(user)

        var result = false

        if(rowNumber > 0) {
            // update成功
            result = true
        }

        return result
    }

    // 1件削除メソッド
    fun deleteOne(userId: String): Boolean {

        // 1件削除
        val rowNomber: Int = dao!!.deleteOne(userId)

        // 判定用変数
        var result: Boolean = false

        if(rowNomber > 0) {
            // delete成功
            result = true
        }

        return result
    }
}