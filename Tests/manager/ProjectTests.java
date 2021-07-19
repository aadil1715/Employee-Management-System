package manager;

import com.dalhousie.group14.Database.manager.ProjectStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProjectTests {

  @Test
  @DisplayName("Project Status Check")
  public void ProjectStatusCheck(){
    assertEquals(true,ProjectStatus.checkStatus("Initiation"));
  }
}
