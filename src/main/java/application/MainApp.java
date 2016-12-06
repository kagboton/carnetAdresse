package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Bijou on 06/12/2016.
 */
public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private AnchorPane personOverview;

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Carnet d'adresse");

        initRootLayout();
        showPersonOverview();

    }

    /**
     * Initialise le rootLayout
     */
    private void initRootLayout() {

        try {

            //Charger la vue RootLayout
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/vues/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            //Afficher la scene contenant le RootLayout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Méthode permettant d'afficher la vue PersonOverview au centre de RootLayout
     */
    private void showPersonOverview() {
        try {

            //Charger la vue PersonOverview
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/vues/PersonOverview.fxml"));
            personOverview = (AnchorPane) loader.load();

            //Affiche la vue PersonOverview au centre de RootLayout
            rootLayout.setCenter(personOverview);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Retourne le principal stage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
