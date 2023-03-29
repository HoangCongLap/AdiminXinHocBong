package xinhocbong.function;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import xinhocbong.alertbox.StudentForm;
import xinhocbong.mySql.MysqlAllStudentInformation;
import xinhocbong.users.User;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentsViewController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private AnchorPane anchorPane;
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
        listM = MysqlAllStudentInformation.getDataAllUsers();
        tableV_inforAca.setItems(listM);



        tableV_inforAca.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                FXMLLoader Loader = new FXMLLoader();
//                Loader.setLocation(getClass().getClassLoader().getResource("AlertBox.fxml"));
//                try {
//                    Loader.load();
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//
//                    Logger.getLogger(StatisticalController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//                AlertBox_StudentInformation alertBoxController = Loader.getController();
//                if (tableV_inforAca.getSelectionModel().getSelectedItem() != null) {
//                    alertBoxController.setData(tableV_inforAca.getSelectionModel().getSelectedItem().getMssv(),
//                            tableV_inforAca.getSelectionModel().getSelectedItem().getName(),
//                            tableV_inforAca.getSelectionModel().getSelectedItem().getGender(),
//                            tableV_inforAca.getSelectionModel().getSelectedItem().getBrithDate(),
//                            tableV_inforAca.getSelectionModel().getSelectedItem().getOverallScore(),
//                            tableV_inforAca.getSelectionModel().getSelectedItem().getFamilySituation());
//                    Parent p = Loader.getRoot();
//                    Stage stage = new Stage();
//                    stage.setScene(new Scene(p));
//                    stage.show();
//                }
            }
        });
    }

    public void exitAllStudentInformationAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Statistical.fxml"));
        root = loader.load();
        StatisticalController scene1Controller = loader.getController();
//        FXMLDocumentController scene1Controller = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleEditClick(MouseEvent event) {
        anchorPane.getScene().getWindow().focusedProperty().addListener(observable -> {
            listM = MysqlAllStudentInformation.getDataAllUsers();
            tableV_inforAca.setItems(listM);
        });
        TableView.TableViewSelectionModel<User> selectionModel = tableV_inforAca.getSelectionModel();
        User selectedUser = selectionModel.getSelectedItem();
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("StudentForm.fxml"));
        if (tableV_inforAca.getSelectionModel().getSelectedItem() != null) {
            try {
                Loader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
                Logger.getLogger(StudentsViewController.class.getName()).log(Level.SEVERE, null, ex);
            }

            StudentForm controller = Loader.getController();
            controller.initForm(selectedUser);
            Parent p = Loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
        }
    }
}