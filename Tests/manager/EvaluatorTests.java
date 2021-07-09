package manager;
import com.dalhousie.group14.Presentation.manager.PerformanceEvaluatorScreen;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class EvaluatorTests {

    @Test
    @DisplayName("Input Validation Tests")
    public void inputValidationTest() throws Exception {
        PerformanceEvaluatorScreen obj = new PerformanceEvaluatorScreen();
        obj.evaluatoroptions();
    }


}
