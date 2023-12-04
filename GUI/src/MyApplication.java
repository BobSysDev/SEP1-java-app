import javafx.application.Application;
import javafx.stage.Stage;
import model.ProjectListModel;
import model.ConstructionCompanyModelManager;
import view.ViewHandler;

public class MyApplication extends Application
{

  public void start(Stage primaryStage)
  {
    ProjectListModel model = new model.ConstructionCompanyModelManager();
    ViewHandler viewHandler = new ViewHandler(model);
    viewHandler.start(primaryStage);
  }
}
