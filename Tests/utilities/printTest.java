package utilities;

import org.junit.Test;
import com.dalhousie.group14.Presentation.utilities.print;

import static org.junit.Assert.*;

public class printTest {

  @Test
  public void displayMessageTest() {
    String string="hello";
    print object1=new print();
    assertEquals(string,object1.display_message(string));
  }

}