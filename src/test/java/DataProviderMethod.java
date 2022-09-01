import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderMethod {

    @DataProvider(name = "AddData")
    public Object[][] dataForAdd(){

        Integer[][] data = {{4,1},{5,6},{8,9}};
        return data;
    }

    @DataProvider(name = "simpleCalculationData")
    public Object[][] dataForSimpleCal(){

        Integer[][] data = {{5,2}};
        return data;
    }


    Calculator cal = new Calculator();
    @Test(dataProvider = "AddData")
    private void testAddition(Integer n1, Integer n2){
        int res = cal.add(n1,n2);
        System.out.println("Test Passed with "+ n1 +" and "+n2 +" = "+res);
    }

}
