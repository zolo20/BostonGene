package multithreadingtest;

import mutithreading.Converter;
import org.junit.Assert;
import org.junit.Test;

public class ConverterTest {

    @Test
    public void converterFromStringsToNumbersTest() {
        for (int i = 1; i < 10000; i++) {
            String actualDigitInEnglish = Converter.converterFromNumberToString(i);
            Assert.assertEquals(i, (long) Converter.converterFromStringToNumber(actualDigitInEnglish));
        }
    }
}
