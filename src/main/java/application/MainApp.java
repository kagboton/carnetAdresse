package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modele.Person;
import vues.PersonOverview;

import java.io.IOException;

/**
 * Created by Bijou on 06/12/2016.
 */
public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    //Une observableList de personnes
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    //Constructeur
    public MainApp(){
        //Ajout de quelques données dans la list observable
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
    }

    /**
     * Methode main qui lance l'application
     * @param args
     */
    public static void main(String[] args){
        launch(args);
    }

    /**
     * Methode principale qui définit et affiche la stage
     * @param primaryStage
     */
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
            AnchorPane personOverview = (AnchorPane) loader.load();

            //Affiche la vue PersonOverview au centre de RootLayout
            rootLayout.setCenter(personOverview);

            //Permettre au controleur de la vue d'accéder à la principale application
            PersonOverview personOverviewController = loader.getController();
            personOverviewController.setMainApp(this);

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

    /**
     * Retourne la liste observable de personnes
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }
}
