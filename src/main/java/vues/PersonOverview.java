package vues;

import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modele.Person;

import javax.swing.text.TabableView;

/**
 * Created by Bijou on 06/12/2016.
 */
public class PersonOverview {

    @FXML
    private TableView<Person> personTable;

    @FXML
    private TableColumn<Person, String> firstNameColumn;

    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label streetLabel;

    @FXML
    private Label postalCodeLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label birthdayLabel;

    //Référence à la classe MainApp - application principale
    private MainApp mainApp;

    //Constructeur
    public PersonOverview(){

    }

    /**
     * Méthode pour initialiser la classs controleur de la vue.
     * Cette methode sera automatiquement appellée juste après le chargement de la page fxml
     *
     */
    @FXML
    private void initialize(){
        //Initialisation de la table personne avec les deux colonnes
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    }

    /**
     * Methode appelée par l'application principale qui donne une référence à elle-même
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        //Ajoute les données de la liste observable dans la table personne
        personTable.setItems(mainApp.getPersonData());
    }
}
