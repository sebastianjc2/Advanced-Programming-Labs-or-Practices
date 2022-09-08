import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LogisticGrowthTest {

	@Test
	public void testMiceGrowth() {
		assertEquals("It should return p0.", 200.0, LogisticGrowth.miceGrowth(0, 0.5, 2000, 200), 0.001);
		assertEquals("It should return p1.", 290.0, LogisticGrowth.miceGrowth(1, 0.5, 2000, 200), 0.001);
		assertEquals("It should return p5.", 1021.917, LogisticGrowth.miceGrowth(5, 0.5, 2000, 200), 0.001);
		assertEquals("It should return p10.", 1902.472, LogisticGrowth.miceGrowth(10, 0.5, 2000, 200), 0.001);
		
		assertEquals("It should return 200 if rate == 0.0.", 200.0, LogisticGrowth.miceGrowth(100, 0.0, 1200, 200), 0.001);
		assertEquals("It should return 0.0 if p0 == 0.0", 0.0, LogisticGrowth.miceGrowth(100, 0.3, 5, 0.0), 0.001);
		assertEquals("It should return 0.0 if p0 == 0.0", 0.0, LogisticGrowth.miceGrowth(100, 0.3, 0.0, 200), 0.001);
	}

}
