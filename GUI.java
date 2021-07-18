package sample;

import javafx.stage.Stage;

import java.io.IOException;

public interface GUI {
    void showOpeningStage(Stage openingStage);

    void showWhatIsBSTScene(Stage openingStage);

    void showBSTRulesScene(Stage openingStage);

    void showNowImageScene(Stage openingStage);

    void showUserNameStage();

    void loadUserData(String name) throws IOException, ClassNotFoundException;

    void showMainMenuStage();

    void showNewGameStage();

    void showLevelStage(int levelNumber);

    void showCongoMessageStage(int levelNumber);

    void showTryAgainStage();

    void exitGameHandles(Stage mainMenuStage) throws IOException, ClassNotFoundException;
}
