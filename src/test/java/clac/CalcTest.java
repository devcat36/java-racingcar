package clac;

import calc.Calculation;
import calc.type.Operation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalcTest {

    Calculation calculation = new Calculation();

    @Test
    @DisplayName("plus Test")
    void plusTest() {
        assertThat(calculation.calculate(3, 5, "+")).isEqualTo(8);
    }

    @Test
    @DisplayName("minus test")
    void minusTest() {
        assertThat(calculation.calculate(3, 5, "-")).isEqualTo(-2);
    }

    @Test
    @DisplayName("multiply test")
    void multiplyTest() {
        assertThat(calculation.calculate(3, 1, "*")).isEqualTo(3);
    }

    @Test
    @DisplayName("divide test")
    void divideTest() {
        assertThat(calculation.calculate(3, 3, "/")).isEqualTo(1);
    }

    @Test
    @DisplayName("all operation test")
    void allOperationTest() {
        assertThat(calculation.calc("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("formula blank test")
    void formulaBlankTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculation.calc(input);
                }).withMessageMatching("formula is blank");
    }

    @Test
    @DisplayName("not support operation test")
    void operationTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculation.calculate(3, 5, "%");
        }).withMessageMatching("not support operation");
    }

}
