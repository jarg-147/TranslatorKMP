package core.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.jarg.translator.database.TranslatorDatabase

actual class DatabaseDriverFactory {

    actual fun create(): SqlDriver = NativeSqliteDriver(TranslatorDatabase.Schema, "translate.db")


}