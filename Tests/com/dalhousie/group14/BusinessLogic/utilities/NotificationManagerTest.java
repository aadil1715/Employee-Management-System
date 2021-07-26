package com.dalhousie.group14.BusinessLogic.utilities;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class NotificationManagerTest {

    @Test
    public void getNotifications() throws SQLException {
        NotificationManager nm = new NotificationManager();
        nm.getNotifications("891000");
        System.out.println(nm);
    }
}