import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomCardsFX extends Application {

    private static final String CARD_FOLDER = "cards/";
    private static final String[] CARD_FILES = {
            "ace_of_clubs.png", "2_of_clubs.png", "3_of_clubs.png", "4_of_clubs.png",
            "5_of_clubs.png", "6_of_clubs.png", "7_of_clubs.png", "8_of_clubs.png",
            "9_of_clubs.png", "10_of_clubs.png", "jack_of_clubs.png", "queen_of_clubs.png", "king_of_clubs.png",

            "ace_of_diamonds.png", "2_of_diamonds.png", "3_of_diamonds.png", "4_of_diamonds.png",
            "5_of_diamonds.png", "6_of_diamonds.png", "7_of_diamonds.png", "8_of_diamonds.png",
            "9_of_diamonds.png", "10_of_diamonds.png", "jack_of_diamonds.png", "queen_of_diamonds.png", "king_of_diamonds.png",

            "ace_of_hearts.png", "2_of_hearts.png", "3_of_hearts.png", "4_of_hearts.png",
            "5_of_hearts.png", "6_of_hearts.png", "7_of_hearts.png", "8_of_hearts.png",
            "9_of_hearts.png", "10_of_hearts.png", "jack_of_hearts.png", "queen_of_hearts.png", "king_of_hearts.png",

            "ace_of_spades.png", "2_of_spades.png", "3_of_spades.png", "4_of_spades.png",
            "5_of_spades.png", "6_of_spades.png", "7_of_spades.png", "8_of_spades.png",
            "9_of_spades.png", "10_of_spades.png", "jack_of_spades.png", "queen_of_spades.png", "king_of_spades.png"
    };

    private final ImageView[] cardViews = new ImageView[4];

    @Override
    public void start(Stage primaryStage) {
        HBox cardPane = new HBox(10);
        cardPane.setAlignment(Pos.CENTER);

        for (int i = 0; i < cardViews.length; i++) {
            cardViews[i] = new ImageView();
            cardViews[i].setFitWidth(120);
            cardViews[i].setPreserveRatio(true);
            cardPane.getChildren().add(cardViews[i]);
        }

        Button refreshButton = new Button("Refresh");

        // Lambda expression
        refreshButton.setOnAction(e -> displayRandomCards());

        VBox bottomPane = new VBox(10, refreshButton);
        bottomPane.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(15));
        root.setCenter(cardPane);
        root.setBottom(bottomPane);

        displayRandomCards();

        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("Random Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayRandomCards() {
        List<String> deck = new ArrayList<>(List.of(CARD_FILES));
        Collections.shuffle(deck);

        for (int i = 0; i < 4; i++) {
            try {
                Image image = new Image(new FileInputStream(CARD_FOLDER + deck.get(i)));
                cardViews[i].setImage(image);
            } catch (FileNotFoundException e) {
                System.out.println("Card image not found: " + CARD_FOLDER + deck.get(i));
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}