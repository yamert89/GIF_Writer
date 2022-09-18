import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import softoad.gif.GIFBuilder
import kotlin.reflect.jvm.isAccessible

class GIFBuilderTest {
    @Test
    fun convertToBytes(){
        val f = GIFBuilder::class.members.find { it.name == "convertToBytes" }!!
        f.isAccessible = true
        assertEquals(127 to 0, f.call(GIFBuilder(), 127))
        assertEquals(232 to 3, f.call(GIFBuilder(), 1000))
    }
}