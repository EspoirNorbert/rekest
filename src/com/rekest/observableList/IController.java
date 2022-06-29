package com.rekest.observableList;

import javafx.stage.Stage;

public interface IController {
	
	public default void initAuthLayout(Stage primaryStage) {};
	
	public default void setPrimaryStage(Stage primaryStage) {};
}
