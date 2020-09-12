package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    Controller controller;
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
        Scene scene = new Scene(root, 765, 180);
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(() -> {
            do {
                System.out.println("WAIT");
            } while (controller.firstMark == '_' || controller.firstType == -1 || controller.secondType == -1);
            System.out.println("GAME START");
            controller.startDesktop();
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
