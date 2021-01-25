import hu.adventofcode2019.day04.PasswordValidator;
import org.junit.Assert;
import org.junit.Test;

public class PasswordValidatorTest {
    @Test
    public void validatePasswordTask1Test1() {
        boolean isValid = PasswordValidator.validateByTask1Rules("111111");
        Assert.assertTrue(isValid);
    }

    @Test
    public void validatePasswordTask1Test2() {
        boolean isValid = PasswordValidator.validateByTask1Rules("223450");
        Assert.assertFalse(isValid);
    }

    @Test
    public void validatePasswordTask1Test3() {
        boolean isValid = PasswordValidator.validateByTask1Rules("123789");
        Assert.assertFalse(isValid);
    }

    @Test
    public void validatePasswordTask2Test1() {
        boolean isValid = PasswordValidator.validateByTask2Rules("112233");
        Assert.assertTrue(isValid);
    }

    @Test
    public void validatePasswordTask2Test2() {
        boolean isValid = PasswordValidator.validateByTask2Rules("123444");
        Assert.assertFalse(isValid);
    }

    @Test
    public void validatePasswordTask2Test3() {
        boolean isValid = PasswordValidator.validateByTask2Rules("111122");
        Assert.assertTrue(isValid);
    }
}
