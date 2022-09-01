import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupingMethod {

    Calculator calculator;

    @BeforeMethod(groups = {"simpleCalculation"})
    public void initializeCalculator(){
        System.out.println("simpleCalculation Before Method");
        calculator = new Calculator();
    }
    @BeforeMethod(groups = {"complexCalculation"})
    public void initializeCalculator2(){
        System.out.println("complexCalculation Before Method");
        calculator = new Calculator();
    }

//    @BeforeMethod()
//    public void initializer(){
//        calculator = new Calculator();
//    }


    @Test(groups = {"simpleCalculation"},dataProvider = "simpleCalculationData" , dataProviderClass = DataProviderMethod.class)
    private void testAddMethod1(int num1,int num2){

//        Calculator calculator = new Calculator();
        int add = calculator.add(num1,num2);
        Assert.assertEquals(add,7);
    }

    @Test(groups = {"simpleCalculation"},dataProvider = "simpleCalculationData" , dataProviderClass = DataProviderMethod.class)
    private void testSubtractMethod1(int num1,int num2){

//        Calculator calculator = new Calculator();
        int sub = calculator.subtract(num1,num2);
        Assert.assertEquals(sub,3);
    }

    @Test(groups = {"simpleCalculation"},dataProvider = "simpleCalculationData" , dataProviderClass = DataProviderMethod.class)
    private void testMultiply1(int num1,int num2){

//        Calculator calculator = new Calculator();
        int multiply = calculator.multiply(num1,num2);
        Assert.assertEquals(multiply,10);
    }

    @Test(groups = {"complexCalculation"})
    private void testPercentage1(){
        int num = 58;
        int total = 100;
        // Calculator calculator = new Calculator();
        double percentage = calculator.percentage(num,total);
        Assert.assertEquals(percentage,58.00);
    }

    @Test(groups = {"complexCalculation"})
    private void testSquare1(){
        int num = 3;
        // Calculator calculator = new Calculator();
        int square = calculator.square(num);
        Assert.assertEquals(square,9);
    }
}
