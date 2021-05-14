package pt.ipg.livros

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class TestBaseDados {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = getAppContext()
        assertEquals("pt.ipg.livros", appContext.packageName)
    }

    private fun getAppContext() = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun apagaBaseDados(){
        getAppContext().deleteDatabase(BdLivrosOpenHelper.NOME_BASE_DADOS)
    }

    @Test
    fun consegueAbrirBaseDados(){
        val dbOpenHelper = BdLivrosOpenHelper(getAppContext())
        val db = dbOpenHelper.readableDatabase
        assert(db.isOpen)
        db.close()
    }
}