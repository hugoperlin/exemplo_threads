package ifpr.pgua.eic.javafx.Exemplo01;

/*Referência https://examples.javacodegeeks.com/desktop-java/javafx/javafx-concurrency-example */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ExemploJavaFx01  extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("exemplo01.fxml"));
        primaryStage.setTitle("Exemplo Ruim...");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        Application.launch(args);
    }


}
