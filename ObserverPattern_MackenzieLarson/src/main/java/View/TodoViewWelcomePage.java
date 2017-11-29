/**
 * Mackenzie Larson
 * 11/29/2017
 * TodoViewWelcomePage.java
 */
package View;

import Controller.TodoController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Mackenzie Larson
 * @version 1.0
 *
 * UI for the welcome page
 */
public class TodoViewWelcomePage extends Application
{
    private static final int WIN_WIDTH = 300;
    private static final int WIN_HEIGHT = 300;
    private static final int BTN_WIDTH = 90;
    public static final int PANEL_PADING = 10;
    public static Stage stage;
    private TodoController controller;

    /**
     * initializes the stage
     * @return stage
     */
    public static Stage getStage()
    {
        return stage;
    }

    /**
     * starts up the stage for the scene
     * @param theStage
     */
    @Override
    public void start(Stage theStage)
    {
        controller = new TodoController();
        stage = theStage;
        theStage.setTitle("Task List");
        theStage.setScene(TodoViewWelcomePage.getScene());
        theStage.show();
    }

    /**
     * The UI for the welcome page
     * @return
     */
    public static Scene getScene()
    {
        VBox welcome = new VBox();

        welcome.setAlignment(Pos.CENTER);
        welcome.setPadding(new Insets(PANEL_PADING));
        welcome.setSpacing(10);

        welcome.setStyle("-fx-background-color: lightpink");

        Text title = new Text("Welcome");
        Text reminder = new Text("You have " + TodoController.getTodo().size() + " unfinished tasks");

        reminder.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 25));

        Button viewBtn = new Button("View");
        viewBtn.setStyle("-fx-focus-color: transparent;");
        viewBtn.setPrefWidth(BTN_WIDTH);

        viewBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                TodoController.switchScenes(viewBtn.getText());
            }
        });

        Image image = new Image("images/todo.png");
        ImageView imageControl = new ImageView(image);
        imageControl.setFitWidth(100);
        imageControl.setFitHeight(100);

        welcome.getChildren().addAll(title, reminder, viewBtn, imageControl);

        return new Scene(welcome, WIN_WIDTH, WIN_HEIGHT);
    }
}
