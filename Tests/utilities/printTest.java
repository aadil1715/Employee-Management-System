package utilities;

import org.junit.Test;
import com.dalhousie.group14.Presentation.utilities.Print;

import static org.junit.Assert.*;

public class printTest {

  @Test
  public void displayMessageTest() {
    String string = "hello";
    Print object1 = new Print();
    assertEquals(string, object1.displayMessage(string));
  }

}