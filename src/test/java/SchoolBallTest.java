import org.junit.Assert;
import org.junit.Test;

public class SchoolBallTest
{

    @Test
    public void testTwoBall()
    {
        var actualResult = getMarkResult(20);
        Assert.assertEquals("2", actualResult);
    }

    @Test
    public void testThreeBall()
    {
        var actualResult = getMarkResult(35);
        Assert.assertEquals("3", actualResult);
    }

    @Test
    public void testFourBall()
    {
        var actualResult = getMarkResult(70);
        Assert.assertEquals("4", actualResult);
    }

    @Test
    public void testThreeRightBall()
    {
        var actualResult = getMarkResult(38);
        Assert.assertEquals("3", actualResult);
    }

    @Test
    public void testFiveBall()
    {
        var actualResult = getMarkResult(78);
        Assert.assertEquals("5", actualResult);
    }

    @Test
    public void testFiveGranBall()
    {
        var actualResult = getMarkResult(100);
        Assert.assertEquals("5", actualResult);
    }

    private String getMarkResult(Integer mark)
    {
        if(mark>=0 && mark <=35) return "2";
        if(mark>35 && mark <=56) return "3";
        if(mark>56 && mark<71) return "4";
        if(mark>72 && mark<100) return "5";
        return "no mark result";
    }
}
