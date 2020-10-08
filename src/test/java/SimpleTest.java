import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {
    @Test
    public void testNormalWeight()
    {
        var actualResult = getIMTResult(180f, 75f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }

    @Test
    public void testZeroHeight()
    {
        var actualResult = getIMTResult(0f,60f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }

    @Test
    public void testBigWeight()
    {
        var actualResult = getIMTResult(180f, 100f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }

    @Test
    public void TestNotEnoughWeight()
    {
        var actualResult = getIMTResult(180f, 45f);
        Assert.assertEquals("выраженному дефициту массы тела", actualResult);
    }

    @Test
    public void TestNotBadWeight()
    {
        var actualResult = getIMTResult(180f, 55f);
        Assert.assertEquals("недостаточной массе тела", actualResult);
    }

    private String getIMTResult(Float heightCm, Float weightKg)
    {
        var userIndex = Math.round(weightKg / Math.pow((heightCm / 100), 2));
        String userResult = null;
        if (userIndex <= 16) {
            userResult = "выраженному дефициту массы тела";
        } else if (userIndex > 16 && userIndex < 19)  {
            userResult = "недостаточной массе тела";
        } else if (userIndex > 19 && userIndex < 25) {
            userResult = "нормальной массе тела";
        } else if (userIndex > 25) {
            userResult = "избыточной массе тела";
        }
        if (heightCm.equals(0.0f)) userResult+="указан некорректный рост";
        return userResult;
    }
}
