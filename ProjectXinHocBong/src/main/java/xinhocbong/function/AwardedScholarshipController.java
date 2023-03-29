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

public class AwardedScholarshipController {
    @FXML
    private TextField idUp;
    @FXML
    private TextField ngayNhan;
    @FXML
    private TextField toChucChosoTien;
    @FXML
    private TextField toChuc;


    @FXML
    protected void IdUpDateAction(ActionEvent event) {
        String IdUp = idUp.getText();
    }

    @FXML
    protected void ngayNhanUpDateAction(ActionEvent event) {
        String NgayNhan = ngayNhan.getText();
    }

    @FXML
    protected void soTienUpDateAction(ActionEvent event) {
        String ToChucChoSoTienUp = toChucChosoTien.getText();
    }

    @FXML
    protected void toChucUpDateAction(ActionEvent event) {
        String ToChuc = toChuc.getText();
    }


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void exitUpDate(ActionEvent event) throws IOException {
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
