package core.data.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.jarg.translator.database.TranslatorDatabase

actual class DatabaseDriverFactory(
    private val context: Context
) {

    actual fun create(): SqlDriver = AndroidSqliteDriver(TranslatorDatabase.Schema, context, "translate.db")

}