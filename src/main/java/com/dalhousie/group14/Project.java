package com.dalhousie.group14;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Project {

    String project_name = "";
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    Date project_start = new Date();
    Date project_end = new Date();
    List<String> language_requirements = new ArrayList<>();
    Map<Integer, String> milestone_desc = new HashMap<>();
    Map<Integer, Date> milestone_deadlines = new HashMap<>();
    String project_feedback = "";
    int feedback_rating = 0;
    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;

    public void projectDBinsertion(){
        int projectid=0;
        connection = EstablishConnection(connection);
        try {
            statement = connection.createStatement();
            String projectlanguages = String.join(", ", language_requirements);
            String project_status = "Initiation";
            statement.executeUpdate("INSERT INTO Project (ProjectName, ProjectLanguages, ProjectStartDate, ProjectEndDate, ProjectStatus)"+"Values('" + project_name + "','" + projectlanguages + "','"+ sdf.format(project_start)+"','"+sdf.format(project_end)+"','"+project_status+"')");
            resultSet = statement.executeQuery("Select ProjectID from Project where ProjectName='"+project_name+"';");
            if(resultSet.isBeforeFirst()){
                resultSet.next();
                String incoming = resultSet.getString("ProjectID");
                projectid = Integer.parseInt(incoming);
            }
            for(int i =1 ; i<=milestone_deadlines.size() ; i++){
                statement.executeUpdate("INSERT INTO milestones (milestoneDesc, ProjectID, Deadline)"+"Values('" + milestone_desc.get(i) + "','" + projectid + "','"+sdf.format(milestone_deadlines.get(i))+"');");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public boolean projectexistscheck(String Projectname){
        connection = EstablishConnection(connection);
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select ProjectName from Project where ProjectName='"+project_name+"';");
            if(resultSet.isBeforeFirst()){
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    private static Connection EstablishConnection (Connection connection){
        try {
            String db_connection_url = "jdbc:mysql://34.134.143.1:3306/ems";
            String db_username = "root";
            String db_password = "ahjnr5";
            connection = DriverManager.getConnection(db_connection_url,db_username,db_password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;

    }

}

