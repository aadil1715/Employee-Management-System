package Employee;

import com.dalhousie.group14.BusinessLogic.employee.NoticePeriod;
import org.junit.Test;

import static org.junit.Assert.*;

public class notice_periodTest {

  @Test
  public void notice_period_calculation() {
    int months = 2;
    NoticePeriod np = new NoticePeriod();
    assertEquals(months, np.noticePeriodCalculation());

    int months1 = 0;
    assertNotEquals(months1, np.noticePeriodCalculation());

    double months2 = 2.344467;
    assertNotEquals(months2, np.noticePeriodCalculation());


  }

}