package core.data.db

import app.cash.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {

    fun create(): SqlDriver

}