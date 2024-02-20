import java.time.LocalDate;
import java.time.Period;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//********************************************************************************************************************************************
//  WeekPicker.java            Author: Steffanie Peralta
//
//  Demonstrating the use of color picker and date picker controls
//*********************************************************************************************************************************************

public class WeekPicker extends Application
{
    private Text message;
    private DatePicker datePicker;
    private ColorPicker colorPicker;

    // Allows the user to select a date and color. The text object displays the day of the week in the color specified.

    public void start (Stage primaryStage)
    {


        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(2024, 02, 20);
        int years = Period.between(birthday,today).getYears();
        System.out.println(years);

        datePicker = new DatePicker();
        datePicker.setOnAction(this::processDate);


        colorPicker = new ColorPicker(Color.CHARTREUSE);

        colorPicker.setOnAction(this::processColorChoice);

        message = new Text("You're " + years);
        message.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 24)) ;
        message.setFill(Color.CHARTREUSE);


        HBox pickers = new HBox(datePicker, colorPicker);
        pickers.setSpacing(15);
        pickers.setAlignment (Pos.CENTER);

        VBox root = new VBox();
        root.setStyle("fx-background-color: white");
        root.setSpacing(25);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(pickers, message);

        Scene scene = new Scene(root, 420,190);

        primaryStage.setTitle("Age Picker");
        primaryStage.setScene(scene);
        primaryStage.show();

        //Gets the color specified in the color picker and sets the color of the displayed message.


    }

    private void processColorChoice(ActionEvent event) {

        message.setFill(colorPicker.getValue());



    }

    private void processDate(Event event){
        LocalDate today = LocalDate.now();
        LocalDate birthday = datePicker.getValue();
        int years = Period.between(birthday,today).getYears();
        message.setText("You're " + years);
    }
}

// Get the value of the date from the date picker and update the message with the corresponding day of the week.
