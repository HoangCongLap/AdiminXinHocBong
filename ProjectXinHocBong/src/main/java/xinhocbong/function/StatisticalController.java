package xinhocbong.function;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import xinhocbong.alertbox.StudentInformationAlert;
import xinhocbong.mySql.MysqlStatistical;
import xinhocbong.users.UsersStatistical;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StatisticalController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<UsersStatistical> table_users;

    @FXML
    private TableColumn<UsersStatistical, String> col_BrithDate;

//    @FXML
//    private TableColumn<UsersStatistical, String> col_FamilySituation;

//    @FXML
//    private TableColumn<UsersStatistical, String> col_Gender;

    @FXML
    private TableColumn<UsersStatistical, String> col_Mssv;

    @FXML
    private TableColumn<UsersStatistical, String> col_Name;

//    @FXML
//    private TableColumn<UsersStatistical, Float> col_OverallScore;

    ObservableList<UsersStatistical> listM;
    int index = -1;
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;

    public void initialize(URL url, ResourceBundle rb) {
        col_Mssv.setCellValueFactory(new PropertyValueFactory<UsersStatistical, String>("mssv"));
        col_Name.setCellValueFactory(new PropertyValueFactory<UsersStatistical, String>("name"));
//        col_Gender.setCellValueFactory(new PropertyValueFactory<UsersStatistical, String>("gender"));
        col_BrithDate.setCellValueFactory(new PropertyValueFactory<UsersStatistical, String>("brithDate"));
//        col_OverallScore.setCellValueFactory(new PropertyValueFactory<UsersStatistical, Float>("overallScore"));
//        col_FamilySituation.setCellValueFactory(new PropertyValueFactory<UsersStatistical, String>("familySituation"));
        listM = MysqlStatistical.getDataUsersModule1();
        table_users.setItems(listM);

        table_users.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getClassLoader().getResource("AlertBox.fxml"));
                try {
                    Loader.load();
                } catch (IOException ex) {
                    ex.printStackTrace();

                    Logger.getLogger(StatisticalController.class.getName()).log(Level.SEVERE, null, ex);
                }

                StudentInformationAlert alertBoxController = Loader.getController();
                if (table_users.getSelectionModel().getSelectedItem() != null) {
                    alertBoxController.setData(
                            table_users.getSelectionModel().getSelectedItem().getMssv(),
                            table_users.getSelectionModel().getSelectedItem().getName(),
                            table_users.getSelectionModel().getSelectedItem().getGender(),
                            table_users.getSelectionModel().getSelectedItem().getBrithDate(),
                            table_users.getSelectionModel().getSelectedItem().getOverallScore(),
                            table_users.getSelectionModel().getSelectedItem().getFamilySituation());
                    Parent p = Loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(p));
                    stage.show();
                }
            }
        });
    }

    public void exitStatisticalAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Menu.fxml"));
        root = loader.load();
        MenuController scene1Controller = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void removeStatistical(ActionEvent event) {
        int selectedID = table_users.getSelectionModel().getSelectedIndex();
        table_users.getItems().remove(selectedID);
    }

    public void infoAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("StudentsView.fxml"));
        root = loader.load();
        StudentsViewController scene1Controller = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void infoActionRecivedSholar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("ScholarStudentsView.fxml"));
        root = loader.load();
        ScholarStudentsViewController scene1Controller = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
