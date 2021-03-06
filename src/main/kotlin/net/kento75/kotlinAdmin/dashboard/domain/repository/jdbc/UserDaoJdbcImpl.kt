package net.kento75.kotlinAdmin.dashboard.domain.repository.jdbc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

import net.kento75.kotlinAdmin.dashboard.domain.model.User
import net.kento75.kotlinAdmin.dashboard.domain.repository.UserDao
import org.springframework.security.crypto.password.PasswordEncoder
import java.util.*


@Repository("UserDaoJdbcImpl")
class UserDaoJdbcImpl: UserDao {

    @Autowired
    internal var jdbc: JdbcTemplate? = null

    @Autowired
    internal var passwordEncoder: PasswordEncoder? = null

    // Userテーブルの件数を取得
    @Throws(DataAccessException::class)
    override fun count(): Int {

        // 全件取得してカウントする
        val count: Int = jdbc!!.queryForObject("SELECT COUNT(*) FROM m_user", Int::class.java)!!

        return count
    }

    // Userテーブルにデータを１件insert
    @Throws(DataAccessException::class)
    override fun insertOne(user: User): Int {

        // パスワード暗号化
        val password: String = passwordEncoder!!.encode(user.password)

        // 1件登録
        val rowNumber: Int = jdbc!!.update("INSERT INTO m_user(user_id,"
                + "password,"
                + "user_name,"
                + "birthday,"
                + "age,"
                + "marriage,"
                + "role)"
                + " VALUES(?,?,?,?,?,?,?)"
                , user.userId
                , password
                , user.userName
                , user.birthday
                , user.age
                , user.marriage
                , user.role
        )

        return rowNumber
    }

    // Userテーブルのデータを1件取得
    @Throws(DataAccessException::class)
    override fun selectOne(userId: String): User {

        // 1件取得
        val map: Map<String, Any?> = jdbc!!.queryForMap("SELECT * FROM m_user WHERE user_id = ?", userId)

        // 結果返却用の変数
        val user = User()

        // 取得したデータを結果返却用の変数にセット
        // ユーザーID
        user.userId = map["user_id"] as String
        // パスワード
        user.password = map["password"] as String
        // ユーザー名
        user.userName = map["user_name"] as String
        // 誕生日
        user.birthday = map["birthday"] as Date
        // 年齢
        user.age = map["age"] as Int
        // 結婚ステータス
        user.marriage = map["marriage"] as Boolean
        // ロール
        user.role = map["role"] as String

        return user
    }

    // Userテーブルの全データを取得
    @Throws(DataAccessException::class)
    override fun selectMany(): MutableList<User> {

        // m_userテーブルのデータを全件取得
        val getList: MutableList<MutableMap<String, Any>> = jdbc!!.queryForList("SELECT * FROM m_user")

        val userList: MutableList<User> = ArrayList<User>()

        for(map in getList) {

            // Userインスタンス生成
            val user: User = User()

            // Userインスタンスに取得したデータをセットする
            // ユーザーID
            user.userId = map["user_id"] as String?
            // パスワード
            user.password = map["password"] as String?
            // ユーザー名
            user.userName = map["user_name"] as String?
            // 誕生日
            user.birthday = map["birthday"] as Date?
            // 年齢
            user.age = map["age"] as Int
            // 結婚ステータス
            user.marriage = map["marriage"] as Boolean
            // ロール
            user.role = map["role"] as String?

            // 結果返却用のListに追加
            userList.add(user)
        }

        return userList
    }

    // Userテーブルを1件更新
    @Throws(DataAccessException::class)
    override fun updateOne(user: User): Int {

        // パスワード暗号化
        val password: String = passwordEncoder!!.encode(user.password)

        // 1件更新
        val rowNumber: Int = jdbc!!.update("UPDATE M_USER SET password = ?, user_name = ?, birthday = ?, age = ?, marriage = ? WHERE user_id = ?",
                password,
                user.userName,
                user.birthday,
                user.age,
                user.marriage,
                user.userId)

        return rowNumber
    }

    // Userテーブルを1件削除
    @Throws(DataAccessException::class)
    override fun deleteOne(userId: String): Int {

        // 1件削除
        val rowNumber: Int = jdbc!!.update("DELETE FROM m_user WHERE user_id = ?", userId)

        return rowNumber
    }

    // Userテーブルの全データをCSVに出力
    @Throws(DataAccessException::class)
    override fun userCsvOut() {

    }
}