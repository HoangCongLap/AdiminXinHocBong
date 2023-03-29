package xinhocbong.function;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class AddController {

    @FXML
    private TextField mssv;
    @FXML
    private TextField hoTen;
    @FXML
    private TextField gioiTinh;
    @FXML
    private TextField ngaySinh;
    @FXML
    private TextField noiSinh;
    @FXML
    private TextField hoanCanh;
    @FXML
    private TextField ngayNhan;
    @FXML
    private TextField soTienAdd;
    @FXML
    private TextField toChucCho;
    @FXML
    private TextField diem;



    @FXML
    protected void newMssv(ActionEvent event) {
        String Mssv = mssv.getText();
    }

    @FXML
    protected void newHoTen(ActionEvent event) {
        String HoTen = hoTen.getText();
    }

    @FXML
    protected void newGioiTinh(ActionEvent event) {
        String GioiTinh = gioiTinh.getText();
    }

    @FXML
    protected void newNgaySinh(ActionEvent event) {
        String NgaySinh = ngaySinh.getText();
    }

    @FXML
    protected void newNoiSinh(ActionEvent event) {
        String NoiSinh = noiSinh.getText();
    }

    @FXML
    protected void newNgayNhan(ActionEvent event) {
        String NgayNhan = ngayNhan.getText();
    }

    @FXML
    protected void newSoTienAdd(ActionEvent event) {
        String SoTienAdd = soTienAdd.getText();
    }
    @FXML
    protected void newHoanCanh(ActionEvent event) {
        String Diem = diem.getText();
    }
    @FXML
    protected void newToChucCho(ActionEvent event) {
        String ToChucCho = toChucCho.getText();
    }

    @FXML
    protected void newDiem(ActionEvent event) {
        String Diem = diem.getText();
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void exit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Menu.fxml"));
        root = loader.load();
        MenuController scene1Controller = loader.getController();
//        FXMLDocumentController scene1Controller = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
