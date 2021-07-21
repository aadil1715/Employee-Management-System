package com.dalhousie.group14.Database.utilities;


public interface insertCredentialsInterface {

  DbConnection dbConnection = new DbConnection();

  void insert_credentials(String emailID, String password, String userType);

}
