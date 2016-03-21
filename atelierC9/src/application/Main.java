/**
*	Projet Homework2, Équipe #11 - Marco Choiniere-Guilmette, Nicolas Boisvert, Leonnel Noundou
*	Ajout de menu, mnémoniques, accélérateurs, menu contextuel
**/

package application;

//Liste des imports nécessaires
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private static final int LARGEUR_SCENE = 300;	//	Constante de largeur de fenêtre
	private static final int HAUTEUR_SCENE = 100;	//	Constante de hauteur de fenêtre
	
	private BorderPane root;	//	Panneau principal


	//	Événement de traitement d'accélérateur
	private class TraiteOption  implements EventHandler<ActionEvent> {
	  public void handle(ActionEvent event) {
		 MenuItem option= (MenuItem) event.getSource();		//	Affectation de la source
		 System.out.println("L'option de menu [" + option.getText() + "] a été sélectionnée.");	//	Affichage de l'élément cliqué
	  }
   };

	@Override
	public void start(Stage primaryStage) {

		//Création des options
		MenuItem opOuvrir = new MenuItem("_Ouvrir");
		opOuvrir.setMnemonicParsing(true);								//Attribution du mnémonic
		MenuItem opSauvegarder = new MenuItem("Sauvegarder");
		
		MenuItem opCouper = new MenuItem("Couper");							//
		opCouper.setAccelerator(KeyCombination.keyCombination("CTRL+X"));  	//Attribution de l'accélérateur "CTRL+X"
		MenuItem opColler = new MenuItem("Coller");
		opColler.setAccelerator(KeyCombination.keyCombination("CTRL+V")); 	//Attribution de l'accélérateur "CTRL+V"
		MenuItem opCopier = new MenuItem("Copier");
		opCopier.setAccelerator(KeyCombination.keyCombination("CTRL+C")); 	//Attribution de l'accélérateur "CTRL+C"

		MenuItem opContenu = new MenuItem("Contenu...");	//	Option de contenu pour le menu principal
		MenuItem opAPropos = new MenuItem("À Propos");		//	Option a propos du menu principal

		MenuItem opContenu2 = new MenuItem("Contenu...");	//	Option de conteu pour le menu contextuel
		MenuItem opAPropos2 = new MenuItem("À Propos");		//	Option a propos du menu contextuel
		
		TraiteOption traiteOption = new TraiteOption();		//	Événement de clique droit dans la scene
		
		opOuvrir.setOnAction(traiteOption);			//	Affectation de l'événement pour l'option ouvrir
		opSauvegarder.setOnAction(traiteOption);	//	Affectation de l'événement pour l'option sauvegarder
		opCouper.setOnAction(traiteOption);			//	Affectation de l'événement pour l'option couper
		opColler.setOnAction(traiteOption);			//	Affectation de l'événement pour l'option coller
		opCopier.setOnAction(traiteOption);			//	Affectation de l'événement pour l'option copier
		
		//Création des menus
		Menu menuFichier = new Menu("_Fichier");	//	Menu principal Fichier
		menuFichier.setMnemonicParsing(true);		//	Activation des mnémoniques
		Menu menuEdition = new Menu("Edition");		// 	Menu principal d'édition
		Menu menuAide = new Menu("Aide");			//	Menu principal d'aide
		ContextMenu menuContextuel = new ContextMenu();	//	Menu contextuel



		menuFichier.getItems().addAll(opOuvrir,opSauvegarder);		//	Affectation des options au menu Fichier
		menuEdition.getItems().addAll(opCouper,opColler,opCopier);	//	Affectation des options au menu Edition
		menuAide.getItems().addAll(opContenu, opAPropos);			//	Affectation des options au menu Aide
		menuContextuel.getItems().addAll(opContenu2, opAPropos2);	//	Affectation des options au menu Contextuel
		
		//Création de la barre de menus
		MenuBar barreMenu = new MenuBar();
		barreMenu.getMenus().add(menuFichier);	//	Ajout du menu Fichier a la barre de menu
		barreMenu.getMenus().add(menuEdition);	//	Ajout du menu Edition a la barre de menu
		barreMenu.getMenus().add(menuAide);		//	Ajout du menu Aide a la barre de menu
	
		root = new BorderPane();										//	Creation du panneau principal
		root.setTop(barreMenu);											//	Ajout de la barre de menu au panneau
		Scene scene = new Scene(root,LARGEUR_SCENE, HAUTEUR_SCENE);		//	Creation de la scene

		//	Traitement du clique droit sur le panneau principal
		class TraiteClicDroit implements EventHandler<MouseEvent> {
			public void handle(MouseEvent event) {
				if (event.getButton() == MouseButton.SECONDARY ) {						//	Si clique droit
					menuContextuel.show(root, event.getScreenX(), event.getScreenY());	//	Affiche le menu contextuel
				}
				if (event.getButton() == MouseButton.PRIMARY) {							//	Si clique gauche
					menuContextuel.hide();												//	Cache le menu contextuel
				}
			}
		}

		TraiteClicDroit traiteClicDroit = new TraiteClicDroit();	//	Création d'événement de clique droit
		root.setOnMouseClicked(traiteClicDroit);					//	Affectation au panneau de l'événement
		
		primaryStage.setScene(scene);		//	Affectation de la scene au stage principal
		primaryStage.show();				//	Affichage du stage principal

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
