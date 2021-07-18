package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.WindowEvent;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;


public class BSTGUI extends Application implements GUI {

    User currentUser = new User();

    @Override // Override the start method in the Application class
    public void start(Stage openingStage) {
        showOpeningStage(openingStage);
    }

    @Override
    public void showOpeningStage(Stage openingStage) {
        // Stage not resizable
        openingStage.setResizable(false);
        // Insert Stage Icon Logo
        openingStage.getIcons().add(new Image("/sample/images/stage_logo.png"));
        // Creates a StackPane to insert video
        StackPane videoPane = new StackPane();
        // Creates a File
        File mediaFile = new File("src/sample/videos/ths_games.mp4");
        // Add video to the Stage
        Media video = new Media(mediaFile.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(video);
        // Video Plays Automatically
        mediaPlayer.setAutoPlay(true);
        // Creates MediaView Object
        MediaView mediaView = new MediaView(mediaPlayer);
        // Adjust Aspect Ratio of the Video to the Scene
        mediaView.setFitHeight(395);
        mediaView.setFitWidth(700);

        // Creates a Next Button
        ImageView nextButtonImageView = new ImageView(new Image("/sample/images/next_button.jpg"));
        nextButtonImageView.setFitWidth(100);
        nextButtonImageView.setFitHeight(35);
        Button nextButton = new Button("", nextButtonImageView);
        nextButton.setStyle("-fx-background-color: transparent");
        // Adjust Button Location on the Pane
        nextButton.setTranslateY(-170);
        nextButton.setTranslateX(270);
        // Add Video and Button to the Pane
        videoPane.getChildren().addAll(mediaView, nextButton);
        // Creates the Scene with the Pane
        Scene scene = new Scene(videoPane, 700, 395);
        openingStage.setTitle("Binary Tree Game");
        // Set the Scene and show the Stage
        openingStage.setScene(scene);
        openingStage.show();
        // If button is clicked, then control goes to showWhatIsBSTScene()
        nextButton.setOnAction((ActionEvent e) -> showWhatIsBSTScene(openingStage));

    }

    @Override
    public void showWhatIsBSTScene(Stage openingStage) {
        // Creates a Stack Pane to show Image
        StackPane imagePane = new StackPane();
        // Create an ImageView
        Image whatIsBST = new Image("/sample/images/what_is_BST.png");
        ImageView imageView1 = new ImageView(whatIsBST);
        // Set Image Size
        imageView1.setFitHeight(500);
        imageView1.setFitWidth(700);
        // Creates a Next Button
        ImageView nextButtonImageView = new ImageView(new Image("/sample/images/next_button.jpg"));
        nextButtonImageView.setFitWidth(100);
        nextButtonImageView.setFitHeight(35);
        Button nextButton = new Button("", nextButtonImageView);
        nextButton.setStyle("-fx-background-color: transparent");
        // Set Button Location
        nextButton.setTranslateY(-220);
        nextButton.setTranslateX(280);
        // Add Image and Button to the Pane
        imagePane.getChildren().addAll(imageView1, nextButton);
        // Add the pane to a Scene
        Scene image1Scene = new Scene(imagePane, 700, 500);
        // Set the Scene to the Stage
        openingStage.setScene(image1Scene);
        // If button is clicked, then control goes to showBSTRulesScene()
        nextButton.setOnAction((ActionEvent e) -> showBSTRulesScene(openingStage));

    }

    @Override
    public void showBSTRulesScene(Stage openingStage) {
        // Creates a Stack Pane to show Image
        StackPane imagePane = new StackPane();
        // Creates an ImageView
        ImageView imageView3 = new ImageView(new Image("/sample/images/bst_rules.png"));
        imageView3.setFitHeight(500);
        imageView3.setFitWidth(700);
        // Creates a Next Button
        ImageView nextButtonImageView = new ImageView(new Image("/sample/images/next_button.jpg"));
        nextButtonImageView.setFitWidth(100);
        nextButtonImageView.setFitHeight(35);
        Button nextButton = new Button("", nextButtonImageView);
        nextButton.setStyle("-fx-background-color: transparent");
        // Set Button Location
        nextButton.setTranslateY(-220);
        nextButton.setTranslateX(280);
        // Add image and button to the pane
        imagePane.getChildren().addAll(imageView3, nextButton);
        // Add pane to the Scene
        Scene image3Scene = new Scene(imagePane, 700, 500);
        // Set the Scene
        openingStage.setScene(image3Scene);
        // If button is clicked, then control goes to showNowImageScene()
        nextButton.setOnAction((ActionEvent e) -> showNowImageScene(openingStage));
    }

    @Override
    public void showNowImageScene(Stage openingStage) {
        // Creates a Stack Pane to show Image
        StackPane imagePane = new StackPane();
        // Create an ImageView
        ImageView imageView2 = new ImageView(new Image("/sample/images/now.png"));
        imageView2.setFitHeight(500);
        imageView2.setFitWidth(700);
        // Creates a Next Button
        ImageView nextButtonImageView = new ImageView(new Image("/sample/images/next_button.jpg"));
        nextButtonImageView.setFitWidth(100);
        nextButtonImageView.setFitHeight(35);
        Button nextButton = new Button("", nextButtonImageView);
        nextButton.setStyle("-fx-background-color: transparent");
        // Set Button Location
        nextButton.setTranslateY(-220);
        nextButton.setTranslateX(280);
        // Add Image and Button to the Pane
        imagePane.getChildren().addAll(imageView2, nextButton);
        // Add the pane to the Scene
        Scene image2Scene = new Scene(imagePane, 700, 500);
        // Set the Scene
        openingStage.setScene(image2Scene);
        // If next button is clicked,
        // Opening Stage Closes and Shows the Username Stage
        nextButton.setOnAction((ActionEvent e) -> {
            showUserNameStage();
            openingStage.close();
        });
    }

    @Override
    public void showUserNameStage() {
        // Creates a Stage
        Stage userNameStage = new Stage();
        // Stage resizable disabled
        userNameStage.setResizable(false);
        // Creates a StackPane
        StackPane pane = new StackPane();
        // Insert Stage Icon logo
        userNameStage.getIcons().add(new Image("/sample/images/stage_logo.png"));
        userNameStage.initModality(Modality.APPLICATION_MODAL);
        // Creates an Image View
        ImageView lockImageView = new ImageView(new Image("/sample/images/lock_image.jpg"));
        lockImageView.setFitHeight(300);
        lockImageView.setFitWidth(300);
        // Creates new Text Field
        TextField userNameTextField = new TextField();
        // Sets TextField properties
        userNameTextField.setAlignment(Pos.BASELINE_LEFT);
        userNameTextField.setMaxWidth(200);
        // Creates Label for the TextField
        Label userNameLabel = new Label("Enter Name ");
        // Set label properties
        userNameLabel.setTranslateY(-30);
        userNameLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
        userNameLabel.setTextFill(Color.web("#ffdf09"));
        // Add ImageView, Label and TextField to the Pane
        pane.getChildren().addAll(lockImageView, userNameLabel, userNameTextField);
        // Add the pane to the Scene
        Scene scene = new Scene(pane, 300, 300);
        // Set Stage Title
        userNameStage.setTitle("Enter Name");
        // Set the Scene
        userNameStage.setScene(scene);
        // Show the Stage
        userNameStage.show();
        // When Enter is Pressed
        userNameTextField.setOnAction((ActionEvent e) -> {
            // Name entered in the text field is assigned to variable
            String name = userNameTextField.getText();
            // Control goes to loadUserData()
            try {
                loadUserData(name);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            // Shows the main menu Stage
            showMainMenuStage();
            // Closes the Username Stage
            userNameStage.close();
        });
    }


    // To Load User's previous data
    @Override
    public void loadUserData(String name) throws IOException, ClassNotFoundException {

        // If the file is empty, then
        if ((new File("userData.ser")).length() == 0) {
            currentUser.setUserName(name);
            currentUser.setScore(0);
        }
        // If the file is not empty, then
        else {
            // Create a new Object Input Stream to read Objects
            ObjectInputStream readFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("userData.ser")));
            // Create an Array List of User Objects
            ArrayList<User> userList = new ArrayList<>();
            // Read the Objects from the readFile and Cast to ArrayList of Users
            userList = (ArrayList<User>) readFile.readObject();
            // Iterating through the userList
            for (int i = 0; i < userList.size(); i++) {
                // Check for NullPointerException
                if (userList.get(i).getUserName() != null) {
                    // If Entered name is the Same as the File records
                    if (userList.get(i).getUserName().equals(name)) {
                        // Assign the Current User Object the Score of the Object stored in the file
                        currentUser.setScore(userList.get(i).getScore());
                        break;
                    }
                    // Other wise set Score to 0 and name to entered name
                    currentUser.setUserName(name);
                    currentUser.setScore(0);

                }
            }
            // CLose the Object Output Stream
            readFile.close();
        }
    }

    @Override
    public void showMainMenuStage() {
        // Creates the mainMenuStage Stage
        Stage mainMenuStage = new Stage();
        // Stage resizable is disabled
        mainMenuStage.setResizable(false);
        // Set Stage Icon Logo
        mainMenuStage.getIcons().add(new Image("/sample/images/stage_logo.png"));
        // Creates a Pane
        StackPane pane1 = new StackPane();
        //Creates an Image View for background Image
        ImageView imageView = new ImageView(new Image("/sample/images/treeVector.png"));
        imageView.setFitHeight(550);
        imageView.setFitWidth(400);
        // Add the ImageVIew to the Pane
        pane1.getChildren().add(imageView);
        // Play Button Image
        ImageView btNewGameImageView = new ImageView(new Image("/sample/images/play_button.png"));
        btNewGameImageView.setFitWidth(120);
        btNewGameImageView.setFitHeight(40);
        // Exit Button Image
        ImageView btExitImageView = new ImageView(new Image("/sample/images/exit_button.png"));
        btExitImageView.setFitWidth(120);
        btExitImageView.setFitHeight(40);
        // Add Image to Button
        Button btNewGame = new Button("", btNewGameImageView);
        Button btExit = new Button("", btExitImageView);
        btNewGame.setStyle("-fx-background-color: transparent");
        btExit.setStyle("-fx-background-color: transparent");
        // Button Properties
        btNewGame.setTranslateY(-30);
        btExit.setTranslateY(30);
        // Add Buttons to Pane
        pane1.getChildren().addAll(btNewGame, btExit);
        // Add Pane to Scene and Show
        Scene scene1 = new Scene(pane1, 400, 550);
        mainMenuStage.setTitle("Main Menu");
        mainMenuStage.setScene(scene1);
        mainMenuStage.show();
        // Event Handles
        // Lambda Expression for NewGame Button Event Handling
        btNewGame.setOnAction((ActionEvent e) -> {
            mainMenuStage.close();
            showNewGameStage();
        });
        // Lambda Expression for Exit button Handling
        btExit.setOnAction((ActionEvent e) -> {
            try {
                exitGameHandles(mainMenuStage);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        // If windows is close from X  Button
        mainMenuStage.setOnCloseRequest((WindowEvent e) -> {
            try {
                exitGameHandles(mainMenuStage);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });

    }

    @Override
    public void showNewGameStage() {
        // Creates a Stage
        Stage newGameStage = new Stage();
        // Stage Resizable disabled
        newGameStage.setResizable(false);
        // Add the Stage Icon Logo
        newGameStage.getIcons().add(new Image("/sample/images/stage_logo.png"));
        // Creates a StackPane
        StackPane stPane = new StackPane();
        // Creates an Image View for background Image
        ImageView imageView = new ImageView(new Image("/sample/images/originalTreeBackground.jpg"));
        imageView.setFitHeight(500);
        imageView.setFitWidth(700);
        // Add the Image View to the Pane
        stPane.getChildren().add(imageView);
        // Creates Buttons for different Levels
        // Level 1 Button
        ImageView btLevel1Iv = new ImageView(new Image("/sample/images/level_1.jpg"));
        btLevel1Iv.setFitWidth(120);
        btLevel1Iv.setFitHeight(30);
        Button btLevel1 = new Button("", btLevel1Iv);
        btLevel1.setStyle("-fx-background-color: transparent");
        // Level 2 Button
        ImageView btLevel2Iv = new ImageView(new Image("/sample/images/level_2.jpg"));
        btLevel2Iv.setFitWidth(120);
        btLevel2Iv.setFitHeight(30);
        Button btLevel2 = new Button("", btLevel2Iv);
        btLevel2.setStyle("-fx-background-color: transparent");
        // Level 3 button
        ImageView btLevel3Iv = new ImageView(new Image("/sample/images/level_3.jpg"));
        btLevel3Iv.setFitWidth(120);
        btLevel3Iv.setFitHeight(30);
        Button btLevel3 = new Button("", btLevel3Iv);
        btLevel3.setStyle("-fx-background-color: transparent");
        // Level 4 Button
        ImageView btlevel4iv = new ImageView(new Image("/sample/images/level_4.jpg"));
        btlevel4iv.setFitWidth(120);
        btlevel4iv.setFitHeight(30);
        Button btLevel4 = new Button("", btlevel4iv);
        btLevel4.setStyle("-fx-background-color: transparent");
        // Level 5 Button
        ImageView btlevel5iv = new ImageView(new Image("/sample/images/level_5.jpg"));
        btlevel5iv.setFitWidth(120);
        btlevel5iv.setFitHeight(30);
        Button btLevel5 = new Button("", btlevel5iv);
        btLevel5.setStyle("-fx-background-color: transparent");
        // Level 6 Button
        ImageView btlevel6iv = new ImageView(new Image("/sample/images/level_6.jpg"));
        btlevel6iv.setFitWidth(120);
        btlevel6iv.setFitHeight(30);
        Button btLevel6 = new Button("", btlevel6iv);
        btLevel6.setStyle("-fx-background-color: transparent");
        // Level 7 Button
        ImageView btlevel7iv = new ImageView(new Image("/sample/images/level_7.jpg"));
        btlevel7iv.setFitWidth(120);
        btlevel7iv.setFitHeight(30);
        Button btLevel7 = new Button("", btlevel7iv);
        btLevel7.setStyle("-fx-background-color: transparent");
        // Level 8 Button
        ImageView btlevel8iv = new ImageView(new Image("/sample/images/level_8.jpg"));
        btlevel8iv.setFitWidth(120);
        btlevel8iv.setFitHeight(30);
        Button btLevel8 = new Button("", btlevel8iv);
        btLevel8.setStyle("-fx-background-color: transparent");
        // Set Button Location
        btLevel1.setTranslateY(-150);
        btLevel2.setTranslateY(-100);
        btLevel3.setTranslateY(-50);
        btLevel4.setTranslateY(0);
        btLevel5.setTranslateY(50);
        btLevel6.setTranslateY(100);
        btLevel7.setTranslateY(150);
        btLevel8.setTranslateY(200);
        // Add All Buttons to the Pane
        stPane.getChildren().addAll(btLevel1, btLevel2, btLevel3, btLevel4,
                btLevel5, btLevel6, btLevel7, btLevel8);
        // Set Buttons to be disabled according the the Score
        if (currentUser.getScore() < 140)
            btLevel8.setDisable(true);
        if (currentUser.getScore() < 120)
            btLevel7.setDisable(true);
        if (currentUser.getScore() < 100)
            btLevel6.setDisable(true);
        if (currentUser.getScore() < 80)
            btLevel5.setDisable(true);
        if (currentUser.getScore() < 60)
            btLevel4.setDisable(true);
        if (currentUser.getScore() < 40)
            btLevel3.setDisable(true);
        if (currentUser.getScore() < 20)
            btLevel2.setDisable(true);

        // If window is closed from the X Button
        newGameStage.setOnCloseRequest((WindowEvent e) -> showMainMenuStage());
        // Creates the Scene
        Scene newGameScene = new Scene(stPane);
        // Set the Stage Title
        newGameStage.setTitle("Levels");
        // Set the Scene
        newGameStage.setScene(newGameScene);
        // Show the Stage
        newGameStage.show();
        // Set Events for each Button
        // If level 1 Button is Clicked
        btLevel1.setOnAction((ActionEvent e) -> {
            newGameStage.close();
            showLevelStage(1);
        });
        // If level 2 Button is Clicked
        btLevel2.setOnAction((ActionEvent e) -> {
            newGameStage.close();
            showLevelStage(2);
        });
        // If level 3 Button is Clicked
        btLevel3.setOnAction((ActionEvent e) -> {
            newGameStage.close();
            showLevelStage(3);
        });
        // If level 4 Button is Clicked
        btLevel4.setOnAction((ActionEvent e) -> {
            newGameStage.close();
            showLevelStage(4);
        });
        // If level 5 Button is Clicked
        btLevel5.setOnAction((ActionEvent e) -> {
            newGameStage.close();
            showLevelStage(5);
        });
        // If level 6 Button is Clicked
        btLevel6.setOnAction((ActionEvent e) -> {
            newGameStage.close();
            showLevelStage(6);
        });
        // If level 7 Button is Clicked
        btLevel7.setOnAction((ActionEvent e) -> {
            newGameStage.close();
            showLevelStage(7);
        });
        // If level 8 Button is Clicked
        btLevel8.setOnAction((ActionEvent e) -> {
            newGameStage.close();
            showLevelStage(8);
        });

    }

    @Override
    public void showLevelStage(int levelNumber) {
        // Creates new Stage
        Stage levelStage = new Stage();
        // Stage resizable is disabled
        levelStage.setResizable(false);
        // Set Stage Icon Logo
        levelStage.getIcons().add(new Image("/sample/images/stage_logo.png"));
        // Creates a NumberGenerator Object
        NumberGenerator numberGenerator;
        // Switch Case Statement
        switch (levelNumber) {
            // Level Number is 1
            case (1):
                numberGenerator = new NumberGenerator(5, 5, 30);
                break;
            // Level Number is 2
            case (2):
                numberGenerator = new NumberGenerator(6, 5, 30);
                break;
            // Level Number is 3
            case (3):
                numberGenerator = new NumberGenerator(7, 5, 30);
                break;
            // Level Number is 4
            case (4):
                numberGenerator = new NumberGenerator(8, 5, 30);
                break;
            // Level Number is 5
            case (5):
                numberGenerator = new NumberGenerator(9, 5, 30);
                break;
            // Level Number is 6
            case (6):
                numberGenerator = new NumberGenerator(10, 5, 30);
                break;
            // Level Number is 7
            case (7):
                numberGenerator = new NumberGenerator(11, 5, 30);
                break;
            // Level Number is 8
            case (8):
                numberGenerator = new NumberGenerator(12, 5, 30);
                break;
            // If no case matches
            default:
                numberGenerator = new NumberGenerator(4, 5, 30);
                break;
        }

        // Creates a new BST object
        BST tree = new BST();
        // Creates a Border Pane
        BorderPane pane = new BorderPane();
        // Creates an ImageView for background Image
        ImageView imageView = new ImageView(new Image("/sample/images/plainTreeVector.jpg"));
        imageView.setFitHeight(600);
        imageView.setFitWidth(730);
        // Add Image View to the Pane
        pane.getChildren().add(imageView);
        // Creates new BTVIew Object and Insert the BST object as the parameter
        BTView view = new BTView(tree);
        // Set BTView to the Center of the Pane
        pane.setCenter(view);
        // Iterate through the Number Array
        for (int i = 0; i < numberGenerator.numberArray.length; i++) {

            int key = numberGenerator.numberArray[i];
            // Searches the key and then Display the tree
            if (tree.search(key)) { // key is in the tree already
                view.displayTree();
            }
            // If key is not found, then insert a new key
            else {
                tree.insert(key, i);
                view.displayTree();
            }
        }

        // Creates a new Text Object that contains multiple options
        Text options = new Text("Options: " + (numberGenerator.numberArray[3] + 20) + " " + (numberGenerator.numberArray[3] + 11) +
                " " + numberGenerator.numberArray[3] + " " + (numberGenerator.numberArray[3] + 27));
        // Text object font set to Times New Roman, Bold and Font Size: 15
        options.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
        // Creates a new text Field
        TextField textField = new TextField();
        // Set textField Width
        textField.setPrefColumnCount(3);
        // Number in text field is Right Justified
        textField.setAlignment(Pos.BASELINE_RIGHT);
        // Creates a new Hbox to add Label and Text Field
        HBox hBox = new HBox(5);
        // Creates the label
        Label textFieldLabel = new Label("Enter The Missing Number: ");
        // Set the Font properties of the label
        textFieldLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
        // Add the label and Text Field to the HBox
        hBox.getChildren().addAll(textFieldLabel, textField);
        // Set HBox Alignment to center
        hBox.setAlignment(Pos.CENTER);
        // Creates a Vbox
        VBox vBox = new VBox(5);
        // Add the HBox and Text to the Vbox
        vBox.getChildren().addAll(hBox, options);
        // Set Vbox Alignment to Center
        vBox.setAlignment(Pos.CENTER);
        // Set the Vbox to the Bottom of the Pane
        pane.setBottom(vBox);

        levelStage.initModality(Modality.APPLICATION_MODAL);

        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 730, 600);
        // Set the stage title
        levelStage.setTitle("Game");
        // Place the scene in the stage
        levelStage.setScene(scene);
        // Display the Stage
        levelStage.show();
        // When enter is pressed
        textField.setOnAction(e -> {
            // The text in textField is parsed to integer
            int num = Integer.parseInt(textField.getText());
            // Compare that integer to the element of the number Array
            if (num == numberGenerator.numberArray[3]) {
                // Show the Congraulations Stage
                showCongoMessageStage(levelNumber);
                // Closes the Level Stage
                levelStage.close();
            } else
                // Shows the TryAgain Stage
                showTryAgainStage();
        });

        // If the Stage is Closed, control goes to showNewGameStage()
        levelStage.setOnCloseRequest((WindowEvent e) -> showNewGameStage());
    }

    @Override
    public void showCongoMessageStage(int levelNumber) {

        // If Statement for unlocking and increasing Score for next Levels
        if (levelNumber == 1 && currentUser.getScore() == 0)
            currentUser.setScore(currentUser.getScore() + 20);
        if (levelNumber == 2 && currentUser.getScore() == 20)
            currentUser.setScore(currentUser.getScore() + 20);
        if (levelNumber == 3 && currentUser.getScore() == 40)
            currentUser.setScore(currentUser.getScore() + 20);
        if (levelNumber == 4 && currentUser.getScore() == 60)
            currentUser.setScore(currentUser.getScore() + 20);
        if (levelNumber == 5 && currentUser.getScore() == 80)
            currentUser.setScore(currentUser.getScore() + 20);
        if (levelNumber == 6 && currentUser.getScore() == 100)
            currentUser.setScore(currentUser.getScore() + 20);
        if (levelNumber == 7 && currentUser.getScore() == 120)
            currentUser.setScore(currentUser.getScore() + 20);
        Stage congoStage = new Stage();
        congoStage.setResizable(false);

        congoStage.getIcons().add(new Image("/sample/images/stage_logo.png"));
        StackPane congoPane = new StackPane();

        congoStage.initModality(Modality.APPLICATION_MODAL);

        ImageView congoImageView = new ImageView(new Image("/sample/images/congo_image.jpg"));
        congoImageView.setFitHeight(250);
        congoImageView.setFitWidth(300);

        // Button in Congratulations Stage
        Button btOk = new Button("OK");
        btOk.setMaxWidth(90);
        btOk.setTranslateY(100);

        congoPane.getChildren().addAll(congoImageView, btOk);

        Scene congoScene = new Scene(congoPane, 300, 250);
        congoStage.setTitle("You Won!");
        congoStage.setScene(congoScene);
        congoStage.show();

        btOk.setOnAction((ActionEvent e) -> {
            congoStage.close();
            showNewGameStage();
        });
    }

    @Override
    public void showTryAgainStage() {
        Stage tryAgainStage = new Stage();
        tryAgainStage.setResizable(false);

        tryAgainStage.getIcons().add(new Image("/sample/images/stage_logo.png"));

        StackPane tryAgainPane = new StackPane();

        tryAgainStage.initModality(Modality.APPLICATION_MODAL);

        ImageView tryAgainImageView = new ImageView(new Image("/sample/images/try_again_image.jpg"));
        tryAgainImageView.setFitHeight(250);
        tryAgainImageView.setFitWidth(250);


        Button btOk = new Button("OK");
        btOk.setMaxWidth(90);
        btOk.setTranslateY(110);

        tryAgainPane.getChildren().addAll(tryAgainImageView, btOk);

        Scene tryAgainScene = new Scene(tryAgainPane, 250, 250);
        tryAgainStage.setTitle("You Lost!");
        tryAgainStage.setScene(tryAgainScene);
        tryAgainStage.show();

        btOk.setOnAction((ActionEvent e) -> tryAgainStage.close());
    }

    // File Handling when the application is closed
    @Override
    public void exitGameHandles(Stage mainMenuStage) throws IOException, ClassNotFoundException {
        // Create a Yes Button for the Alert
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        // Create a No Button for the Alert
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        // Create the Alert
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION, "", yes, no);
        // Set the Alert Title
        confirmationAlert.setTitle("Confirmation");
        // Set the Text to display to Alert Header
        confirmationAlert.setHeaderText("Are you sure you want to quit?");
        // Get the Yes or No Action Result in this Object
        Optional<ButtonType> result = confirmationAlert.showAndWait();
        // If the result is yes
        if (result.get() == yes) {
            // Create an ArrayList of Users
            ArrayList<User> userList = new ArrayList<>();
            // If file is Empty
            if ((new File("userData.ser")).length() == 0) {
                // Add the User to the List
                userList.add(currentUser);
                ObjectOutputStream writeFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("userData.ser")));
                // Write the List to the File
                writeFile.writeObject(userList);
                // Close the File
                writeFile.close();
            }
            // If file is not Empty
            else {
                // Create a Object Input Stream to read objects stored in the file
                ObjectInputStream readFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("userData.ser")));
                // Cast the read object to Array list of Users and assign to userList
                userList = (ArrayList<User>) readFile.readObject();
                // Declared a variable to use as a flag
                int flag = 0;
                // Loop to Iterates through the list of Objects
                for (int i = 0; i < userList.size(); i++) {
                    // To Avoid Null Pointer Exceptions
                    if ((currentUser.getUserName() != null) && (userList.get(i).getUserName() != null)) {
                        // If the current User name is same as the name of read Objects
                        if (currentUser.getUserName().equals(userList.get(i).getUserName())) {
                            // Update Score of User
                            userList.get(i).setScore(currentUser.getScore());
                            // Write the object to the file
                            ObjectOutputStream writeFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("userData.ser")));
                            writeFile.writeObject(userList);
                            // Close the file
                            writeFile.close();
                            // Set Flag to 1
                            flag = 1;
                            break;
                        }
                    }
                }
                // If Flag is not 1
                if (flag != 1) {
                    // Add the user to Array List of Users
                    ObjectOutputStream writeFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("userData.ser")));
                    userList.add(currentUser);
                    // Write the userList to the File
                    writeFile.writeObject(userList);
                    // Close the File
                    writeFile.close();
                }
                // Close the file
                readFile.close();
            }
            // Close the Main Menu Stage
            mainMenuStage.close();
        }
    }

}
