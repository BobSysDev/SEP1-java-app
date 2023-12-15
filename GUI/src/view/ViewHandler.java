package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.application.Application;

/**
 * The class ViewHandler is the responsible for displaying and loading all the windows.
 *
 * @author Samuel Knieza
 * @version 1.0 - December 2023
 */
public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private model.ConstructionCompanyModel model;
  private ProjectViewController projectViewController;
  private DetailsViewController detailsViewController;
  private EditDetailsViewController editDetailsViewController;
  private NewProjectViewController newProjectViewController;
  private SelectNewProjectViewController selectNewProjectViewController;
  private ProjectListViewModel viewModel;

  /**
   * One argument constructor initiating current scene and model Interface.
   *
   * @param model
   *      model interface
   */
  public ViewHandler(model.ConstructionCompanyModel model)
  {
    this.currentScene = new Scene(new Region());
    this.model = model;
  }

  /**
   * Initializing primary stage and opening the main projectView window.
   *
   * @param primaryStage
   *      primary stage
   */
  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("projects");
  }

  /**
   * Using different loader methods based on string input.
   *
   * @param id
   *      a string describing name of a window that should be opened.
   */
  public void openView(String id)
  {
    Region root = null;
    switch (id){
      case("projects"):
        root = loadProjectView("ProjectView.fxml");
        break;
      case("details"):
        root = loadDetailsView("DetailsView.fxml");
        break;
      case("edit details"):
        root = loadEditDetailsView("EditDetailsView.fxml");
        break;
      case("select new"):
        root = loadSelectNewProjectView("SelectNewProjectView.fxml");
        break;
      case("new"):
        root = loadNewProjectView("NewProjectView.fxml");
        break;

    }
    currentScene.setRoot(root);
    String title = id;
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  /**
   * Closing primary stage
   */
  public void closeView()
  {
    primaryStage.close();
  }

  /**
   * Loader method opening the projectView window.
   * Initiating properties in this window with init() method.
   * Selecting the ongoing tab with selectDefaultTab() method.
   * Catching an error in case of occurring.
   *
   * @param fxmlFile
   *      full name of fxml file representing projectView window.
   *
   * @return root
   */
  private Region loadProjectView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      projectViewController = loader.getController();
      projectViewController.init(root, model, this);
      projectViewController.selectDefaultTab();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return root;
  }

  /**
   * Loader method opening the selectNewProjectView window.
   * Initiating properties in this window with init() method.
   * Catching an error in case of occurring.
   *
   * @param fxmlFile
   *      full name of fxml file representing selectNewProjectView window.
   *
   * @return root
   */
  private Region loadSelectNewProjectView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      selectNewProjectViewController = loader.getController();
      selectNewProjectViewController.init(root, model, this);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return root;
  }

  /**
   * Loader method opening the newProjectView window.
   * Initiating properties in this window with init() method.
   * Setting default values for project.
   * Showing only relevant tabs.
   * Catching an error in case of occurring.
   *
   * @param fxmlFile
   *      full name of fxml file representing newProjectView window.
   *
   * @return root
   */
  private Region loadNewProjectView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      newProjectViewController = loader.getController();
      newProjectViewController.init(root, model, this);
      newProjectViewController.setDefaults(selectNewProjectViewController.getTypeSelected());
      newProjectViewController.tabAppearance(selectNewProjectViewController.getTypeSelected());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return root;
  }

  /**
   * Loader method opening the detailsView window.
   * Initiating properties in this window with init() method.
   * Catching an error in case of occurring.
   *
   * @param fxmlFile
   *      full name of fxml file representing detailsView window.
   *
   * @return root
   */
  private Region loadDetailsView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      detailsViewController = loader.getController();
      detailsViewController.init(root, model, this, projectViewController, viewModel);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return root;
  }

  /**
   * Loader method opening the editDetailsView window.
   * Initiating properties in this window with init() method.
   * Catching an error in case of occurring.
   *
   * @param fxmlFile
   *      full name of fxml file representing editDetailsView window.
   *
   * @return root
   */
  private Region loadEditDetailsView(String fxmlFile)
  {
    Region root = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root = loader.load();
      editDetailsViewController = loader.getController();
      editDetailsViewController.init(root, model, this, projectViewController, viewModel);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return root;
  }




}
