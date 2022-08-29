
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class CalculatorTest {

    Calculator calculator;

    @BeforeClass
    private void beforeClassMethode(){
        System.out.println("This is before class method");
    }
    @AfterClass
    private void AfterClassMethode(){
        System.out.println("This is After class method");
    }

    @BeforeMethod(groups = {"simpleCalculation"})
    private void initializeCalculator(){
        calculator = new Calculator();
    }
    @BeforeMethod(groups = {"complexCalculation"})
    private void initializeCalculator1(){
        calculator = new Calculator();
    }

    @AfterMethod(groups = {"simpleCalculation","complexCalculation"})
    private void afterMAssage(){
        System.out.println("Printing After Method Execution.......");
    }


    @BeforeGroups
    public void beforeGroupMethod(){
        System.out.println("New Group Test Methods Are Started .............");
    }

    @AfterGroups
    public void afterGroupMethod(){
        System.out.println("Group Test Methods Are Ended here .............");
    }


    @Test(priority = 1,groups = {"simpleCalculation"},dataProvider = "simpleCalculationData" , dataProviderClass = DataProviderMethod.class)
    private void testAddMethod(int num1,int num2){

//        Calculator calculator = new Calculator();
        int add = calculator.add(num1,num2);
        Assert.assertEquals(add,7);
    }

    @Test(groups = {"simpleCalculation"},dataProvider = "simpleCalculationData" , dataProviderClass = DataProviderMethod.class)
    private void testSubtractMethod(int num1,int num2){

//        Calculator calculator = new Calculator();
        int sub = calculator.subtract(num1,num2);
        Assert.assertEquals(sub,3);
    }

    @Test(groups = {"simpleCalculation"},dataProvider = "simpleCalculationData" , dataProviderClass = DataProviderMethod.class)
    private void testMultiply(int num1,int num2){

//        Calculator calculator = new Calculator();
        int multiply = calculator.multiply(num1,num2);
        Assert.assertEquals(multiply,10);
    }

    @Test(groups = {"complexCalculation"})
    private void testPercentage(){
        int num = 58;
        int total = 100;
//        Calculator calculator = new Calculator();
        double percentage = calculator.percentage(num,total);
        Assert.assertEquals(percentage,58.00);
    }

    @Test(groups = {"complexCalculation"})
    private void testSquare(){
        int num = 3;
//        Calculator calculator = new Calculator();
        int square = calculator.square(num);
        Assert.assertEquals(square,9);
    }

    @Test(enabled = false)
    private void testIgnoreThis(){
        System.out.println("Ignored method");
    }

    @Test(timeOut = 100)
    private void testByTimeout(){
        for(int i=0;i<5;i++){
            System.out.println("TimeOut Expected method");
        }
    }

    @Test (expectedExceptions = {IOException.class},expectedExceptionsMessageRegExp = "This is Tester Given Exeption")
    private void testForException() throws IOException {
        throw new IOException("This is Tester Given Exeption");
    }




 @Test(dataProvider = "AddData" , dataProviderClass = DataProviderMethod.class)
    private void checkDataProvider(int num1,int num2){
     System.out.println("Data is "+num1+" and "+num2);
 }





}
