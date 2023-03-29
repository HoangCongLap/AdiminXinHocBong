package xinhocbong.function;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import xinhocbong.mySql.ScholarshipStudents;
import xinhocbong.users.User;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ScholarStudentsViewController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<User> tableV_inforAca;
    @FXML
    private TableColumn<User, Float> col_OverallScore;
    @FXML
    private TableColumn<User, String> col_BrithDate;

    @FXML
    private TableColumn<User, String> col_FamilySituation;

    @FXML
    private TableColumn<User, String> col_Gender;

    @FXML
    private TableColumn<User, String> col_Mssv;

    @FXML
    private TableColumn<User, String> col_Name;

    @FXML
    private TableColumn<User, String> col_IDHocBong;

    @FXML
    private TableColumn<User, String> col_NgayNhan;

    @FXML
    private TableColumn<User, String> col_SoTien;

    @FXML
    private TableColumn<User, String> col_TenToChuc;
    ObservableList<User> listM;
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public void initialize(URL url, ResourceBundle rb) {
        col_Mssv.setCellValueFactory(new PropertyValueFactory<User, String>("mssv"));
        col_Name.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        col_Gender.setCellValueFactory(new PropertyValueFactory<User, String>("gender"));
        col_BrithDate.setCellValueFactory(new PropertyValueFactory<User, String>("brithDate"));
        col_OverallScore.setCellValueFactory(new PropertyValueFactory<User, Float>("overallScore"));
        col_FamilySituation.setCellValueFactory(new PropertyValueFactory<User, String>("familySituation"));
        col_IDHocBong.setCellValueFactory(new PropertyValueFactory<User, String>("idHocBong"));
        col_NgayNhan.setCellValueFactory(new PropertyValueFactory<User, String>("ngayNhan"));
        col_SoTien.setCellValueFactory(new PropertyValueFactory<User, String>("soTien"));
        col_TenToChuc.setCellValueFactory(new PropertyValueFactory<User, String>("tenToChuc"));
        listM = ScholarshipStudents.getDataAllUsersReceivedScholarship();
        tableV_inforAca.setItems(listM);
    }
    public void exitStudentReceivedScholarship(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Statistical.fxml"));
        root = loader.load();
        StatisticalController scene1Controller = loader.getController();
//        FXMLDocumentController scene1Controller = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}