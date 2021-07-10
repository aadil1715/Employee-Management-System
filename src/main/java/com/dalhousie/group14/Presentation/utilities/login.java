package com.dalhousie.group14.Presentation.utilities;
import com.dalhousie.group14.BusinessLogic.utilities.Enter_credentials;
import com.dalhousie.group14.BusinessLogic.utilities.Password_Check;
import com.dalhousie.group14.BusinessLogic.utilities.Username_Check;





import java.io.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class login implements Login_credentials {
    private Enter_credentials ec=new Enter_credentials();
    private Map<String, String> credentials=new HashMap<>();
    public static void main(String[] args)
    {
        login l=new login();
        l.userType();

    }

    public  void login1() {
        Username_Check uc=new Username_Check();

        HashMap<String, String> userName=new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        Console cnsl = System.console();
        // Take the user input for username
        System.out.println("Enter the username");
        String username = scanner.nextLine();
        uc.username_Check(username);
        userName.put("UserName",username);
        ec.credentials(userName);
    }

    public void login2()
    {
        Password_Check pc=new Password_Check();
        HashMap<String, String> passwords=new HashMap<>();
        Scanner scanner=new Scanner(System.in);
        // take the user input for password
        System.out.println("Enter the password");
        String password = scanner.nextLine();
        System.out.println("Password is "+password);
        pc.password_Check(password);


        passwords.put("Password",password);
        ec.credentials(passwords);
    }
    public void userType() {
        HashMap<String, String> userType = new HashMap<>();
        String usertype = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select the user type: 1) Employee 2) Manager 3) Client");

        int user = scanner.nextInt();
        switch (user) {
            case 1:
                System.out.println("You are an employee!");
                usertype = "Employee";
                this.login1();
                this.login2();
                break;
            case 2:
                System.out.println("You are a manager!");
                usertype = "Manager";
                this.login1();
                this.login2();
                break;
            case 3:
                System.out.println("You are a client!");
                usertype = "Client";
                this.login1();
                this.login2();
                break;
            default:
                System.out.println("Please select another option");

        }
        userType.put("userType", usertype);
        ec.credentials(userType);

    }


}
