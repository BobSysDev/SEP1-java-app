import javafx.application.Application;
import javafx.stage.Stage;
import model.ConstructionCompanyModel;
import model.ConstructionCompanyManager;
import view.ViewHandler;


/**
 * The class MyApplication sets up interface model,
 * creates new ViewHandler which is responsible for showing every window,
 * and starting primary stage
 *
 * @author Samuel Knieza
 * @version 1.0 - December 2023
 */
public class MyApplication extends Application
{

  /**
   * Starts the stage, creates model interface and view handler.
   *
   * @param primaryStage
   *      primary stage
   */
  public void start(Stage primaryStage)
  {
    model.ConstructionCompanyModel model = new model.ConstructionCompanyManager();
    ViewHandler viewHandler = new ViewHandler(model);
    viewHandler.start(primaryStage);
  }
}
