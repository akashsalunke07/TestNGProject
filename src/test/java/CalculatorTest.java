
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    @Test
    private void testAdd(){
        int a = 1;
        int b = 2;
        Calculator calculator = new Calculator();
        int add = calculator.add(a,b);
        Assert.assertEquals(add,3);
    }

}
