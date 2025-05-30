import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.jyx.runDistanceConverter
import org.jyx.runMassConverter
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class ConverterFunctionsTest {

    @Test
    fun `convert kg to pounds`() {
        val input = "10 kg lb\n"
        val output = ByteArrayOutputStream()
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        System.setOut(PrintStream(output))

        runMassConverter()

        assertTrue(output.toString().contains("10.0 kg is 22.046226218487758 lb"))
    }

    @Test
    fun massConverter_handlesUnknownSourceUnit() {
        val input = "5 stone kg\n"
        val output = ByteArrayOutputStream()
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        System.setOut(PrintStream(output))

        runMassConverter()

        assertTrue(output.toString().contains("Unknown source unit: stone"))
    }

    @Test
    fun massConverter_handlesUnknownTargetUnit() {
        val input = "5 kg stone\n"
        val output = ByteArrayOutputStream()
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        System.setOut(PrintStream(output))

        runMassConverter()

        assertTrue(output.toString().contains("Unknown target unit: stone"))
    }

    @Test
    fun massConverter_handlesInvalidInputSize() {
        val input = "5 kg\n"
        val output = ByteArrayOutputStream()
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        System.setOut(PrintStream(output))

        runMassConverter()

        assertTrue(output.toString().contains("Invalid input. Please provide value, source unit, and target unit."))
    }

    @Test
    fun distanceConverter_convertsMilesToKilometersCorrectly() {
        val input = "1 mile kilometers\n"
        val output = ByteArrayOutputStream()
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        System.setOut(PrintStream(output))

        runDistanceConverter()

        assertTrue(output.toString().contains("1.0 mile is 1.60934 kilometers"))
    }

    @Test
    fun distanceConverter_handlesUnknownSourceUnit() {
        val input = "5 furlong meters\n"
        val output = ByteArrayOutputStream()
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        System.setOut(PrintStream(output))

        runDistanceConverter()

        assertTrue(output.toString().contains("Unknown source unit: furlong"))
    }

    @Test
    fun distanceConverter_handlesUnknownTargetUnit() {
        val input = "5 miles furlong\n"
        val output = ByteArrayOutputStream()
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        System.setOut(PrintStream(output))

        runDistanceConverter()

        assertTrue(output.toString().contains("Unknown target unit: furlong"))
    }

    @Test
    fun distanceConverter_handlesInvalidInputSize() {
        val input = "5 miles\n"
        val output = ByteArrayOutputStream()
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        System.setOut(PrintStream(output))

        runDistanceConverter()

        assertTrue(output.toString().contains("Invalid input. Please provide value, source unit, and target unit."))
    }
}

