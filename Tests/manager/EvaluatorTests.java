package manager;


import com.dalhousie.group14.BusinessLogic.manager.IProjectPerformanceEvaluator;
import com.dalhousie.group14.BusinessLogic.manager.ProjectPerformanceEvaluator;
import com.dalhousie.group14.Database.utilities.QueryExecutor;
import com.dalhousie.group14.Presentation.utilities.TableFormatter;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Harjot Singh
 * @NameofFile: EvaluatorTests.java
 * @ClassDescription: Testing the evaluator's functionality.
 */
public class EvaluatorTests {

    @Test
    @DisplayName("Evalute All")
    public void evaluteAllTest() throws Exception {
        String query = "Select * from EmployeeRatings";
        List<List<String>> evaltable = new ArrayList<>();
        List<String> headers = Arrays.asList("Employee ID", "Discipline Rating"
            , "Project Performance Rating", "Employee Performance Rating");
        evaltable.add(headers);
        ResultSet resultSet = QueryExecutor.readData(query);
        if(resultSet!=null && resultSet.isBeforeFirst()){
            String employeeID = resultSet.getString("EmployeeID");
            String disciplineRating = resultSet.getString("DisciplineRating");
            String projectRating =  resultSet.getString("ProjectRating");
            String evaluationRating = resultSet.getString("ProjectRating");
            List<String> row = Arrays.asList(employeeID,disciplineRating,
                projectRating,evaluationRating);
            evaltable.add(row);
        }
        IProjectPerformanceEvaluator iProjectPerformanceEvaluator =
            new ProjectPerformanceEvaluator();
        assertEquals(iProjectPerformanceEvaluator.evalProjPerformanceAll(),
            TableFormatter.formatAsTable(evaltable));

    }


}
