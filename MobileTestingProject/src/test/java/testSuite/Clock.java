package testSuite;

import activities.AlarmConfigurationScreen;
import activities.AlarmScreen;
import activities.MainScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

public class Clock {

    MainScreen mainScreen = new MainScreen();
    AlarmScreen alarmScreen = new AlarmScreen();
    AlarmConfigurationScreen alarmConfigurationScreen = new AlarmConfigurationScreen();

    @Test
    public void createAlarm(){
        String expectedHour = "3";
        String expectedMinutes = "45";
        String expectedAmPm = "PM";
        String expectedAlarmLabel = "New Alarm";
        String expectedTime = expectedHour + ":" + expectedMinutes + " " + expectedAmPm;
        mainScreen.getTaskName("ALARM").click();
        alarmScreen.addAlarmButton.click();
        alarmConfigurationScreen.getRadialPickerTouchHelper("3").click();
        Assertions.assertEquals("3",alarmConfigurationScreen.hours.getText(),"ERROR! La hora no es la esperada");
        alarmConfigurationScreen.getRadialPickerTouchHelper("45").click();
        Assertions.assertEquals("45",alarmConfigurationScreen.minutes.getText(),"ERROR! Los minutos no son los esperados");

        switch (expectedAmPm){
            case "AM":
                alarmConfigurationScreen.amButton.click();
                break;
            case "PM":
                alarmConfigurationScreen.pmButton.click();
                break;
        }

        alarmConfigurationScreen.okButton.click();

        String alarmReplaced = alarmScreen.getAlarm(expectedHour, expectedMinutes, expectedAmPm).getContentDescription().replaceAll("[?\\p{Z}]", " ");
        Assertions.assertEquals(expectedTime + " Alarm",alarmReplaced,"ERROR! La alarma no fue creada con la hora y minutos esperados");
        Assertions.assertTrue(alarmScreen.getAlarm(expectedHour, expectedMinutes, expectedAmPm).isControlDisplayed() ,"ERROR! La alarma no fue creada");

        alarmScreen.getAlarmLabelOption(expectedHour, expectedMinutes, expectedAmPm).click();
        alarmScreen.alarmName.setText(expectedAlarmLabel);
        alarmScreen.okButton.click();
        Assertions.assertEquals(expectedAlarmLabel, alarmScreen.getAlarmLabel(expectedAlarmLabel),"ERROR! La etiqueta de la alarma no es la esperada");
    }

    @AfterEach
    public void closeApp() {
        Session.getSessionInstance().closeSession();
    }
}
