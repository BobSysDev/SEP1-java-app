import javafx.application.Application;
import javafx.stage.Stage;
import model.ConstructionCompanyModel;
import model.ConstructionCompanyManager;
import view.ViewHandler;

public class MyApplication extends Application
{

  public void start(Stage primaryStage)
  {
    model.ConstructionCompanyModel model = new model.ConstructionCompanyManager();
    ViewHandler viewHandler = new ViewHandler(model);
    viewHandler.start(primaryStage);
  }
}
