package data;

import org.testng.annotations.DataProvider;

import java.util.Iterator;

public class DataForTest {

    @DataProvider(name = "DataForPost")
    public Object[][] data_for_Post() {
        return new Object[][]{
                {"Chris", 2}, {"Alex", 4}
        };
    }

    @DataProvider(name = "DataForDelete")
    public Object[][] data_for_Delete() {
        return new Object[][]{
                {5}
        };
    }
}

//        Object[][] data = new Object[3][2];
//        data[0][0] = "Henry";
//        data[0][1] = 1;
//
//        data[1][0] = "Claire";
//        data[1][1] = 2;
//
//        data[2][0] = "Tom";
//        data[2][1] = 2;
//
//        return data;
