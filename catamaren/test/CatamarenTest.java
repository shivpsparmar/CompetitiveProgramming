import org.junit.Assert;

/**
 * Created By : Shiv Pratap Singh Parmar
 * <p>
 * Created On : 09-05-2016 Description:
 */
public class CatamarenTest {
    @org.junit.Test
    public void getMinSequence() throws Exception {
        String expected = "SWB 73";
        int arr[] = {0, 15, 8, 31, 30, 12, 8, 10, 15, 20 };
        String result = Catamaren.getMinSequence(arr);
        Assert.assertEquals(expected, result);


        expected = "SBW 73";
        int arr1[] = {0, 8, 15, 31, 12, 30, 8, 15, 10, 20 };
        result = Catamaren.getMinSequence(arr1);
        Assert.assertEquals(expected, result);

        expected = "WBS 220";
        int arr2[] = {0, 10, 20, 30, 20, 40, 60, 30, 60, 90 };
        result = Catamaren.getMinSequence(arr2);
        Assert.assertEquals(expected, result);

//        expected = "BSW 20";
//        int arr3[] = {0, 10, 10, 10, 0, 0, 0, 0, 0 ,0 };
//        result = Catamaren.getMinSequence(arr3);
//        Assert.assertEquals(expected, result);
    }

}