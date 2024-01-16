import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;

public class LunarLander extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage)
	{
		//get images
		Image lunarSurface = new Image("file:C:\\Users\\Say Chaleon Vang\\eclipse-workspace\\LunarLander\\src\\lunar surface.png");
		Image lunarLander = new Image("file:C:\\Users\\Say Chaleon Vang\\eclipse-workspace\\LunarLander\\src\\lunar lander.png");
		//image viewers
		ImageView lunarSurfaceIV = new ImageView(lunarSurface);
		ImageView lunarLanderIV = new ImageView(lunarLander);

		//moves lunarLander from left to right
		TranslateTransition landerTrans2 =
			new TranslateTransition(new Duration(3000), lunarLanderIV);
		landerTrans2.setFromX(0);
		landerTrans2.setFromY(350);
		landerTrans2.setByX(300);
		landerTrans2.setByY(0);

		//launches lunarLander
		TranslateTransition landerTrans3 =
			new TranslateTransition(new Duration(4000), lunarLanderIV);
		landerTrans3.setFromX(300);
		landerTrans3.setFromY(350);
		landerTrans3.setByX(0);
		landerTrans3.setByY(-500);
		//landerTrans3.setInterpolator(Interpolator.EASE_IN);
		//landerTrans3.setInterpolator(Interpolator.EASE_OUT);



		//add lunarSurfaceIV to a Pane
		Pane pane = new Pane(lunarSurfaceIV, lunarLanderIV);

		//create a scene with VBox as root node
		Scene scene = new Scene (pane);

		//Register Key Event
		scene.setOnKeyPressed(event ->
		{
			if(event.getCode() == KeyCode.SPACE)
			{
				//play the launch animation
				landerTrans3.play();
			}
		});

		//add scene to the stage
		primaryStage.setScene(scene);

		//show the window
		primaryStage.show();

		//play the animation
		landerTrans2.play();
		//landerTrans2.play();

	}

}