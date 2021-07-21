package Employee;

import com.dalhousie.group14.BusinessLogic.employee.notice_period;
import org.junit.Test;

import static org.junit.Assert.*;

public class notice_periodTest {

  @Test
  public void notice_period_calculation() {
    int months = 2;
    notice_period np = new notice_period();
    assertEquals(months, np.notice_period_calculation());
  }

}