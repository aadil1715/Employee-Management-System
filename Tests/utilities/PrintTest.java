package utilities;

import com.dalhousie.group14.Presentation.utilities.Print;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrintTest {

  @Test
  public void displayMessage() {
    String string = "hello";
    Print object1 = new Print();
    assertEquals(string, object1.displayMessage(string));
  }

}
