package xinhocbong.alertbox;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import xinhocbong.database.ConnectionUtil;
import xinhocbong.mySql.MysqlOrganizetion;
import xinhocbong.users.User;
import javafx.scene.control.TextField;
import xinhocbong.users.Organizetion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Math.random;

public class StudentForm {
    public TextFlow text;
    public Text textData;
    @FXML
    public TextField textFieldReceivedDate;
    @FXML
    public TextField textFieldMoney;
    @FXML
    public ComboBox<Organizetion> comboBoxOrganizaName;
    private User user;
    private Organizetion selectedOrganization;

    public void initForm(User user) {
        this.user = user;
        textData.setText("\n" + "   \tMSSV : " + user.getMssv() + "\n" + "   \tNAME : " + user.getName() + "\n" + "   \tGENDER: " + user.getGender() + "\n"
                + "   \tBRITHDATE : " + user.getBrithDate() + "\n" + "   \tOVERALLSCORE : " + user.getOverallScore() + "\n" + "   \tFAMILYSITUATUON : " + user.getFamilySituation());
        textFieldReceivedDate.setText(user.getNgayNhan());
        textFieldMoney.setText(user.getSoTien());
        ObservableList<Organizetion> orranizetions = MysqlOrganizetion.getOrranizetions();
        comboBoxOrganizaName.getItems().addAll(orranizetions);
        comboBoxOrganizaName.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            selectedOrganization = newValue;
        });
        if (user.getTenToChuc() != null && !user.getTenToChuc().isEmpty()) {

            for (Organizetion o : orranizetions) {
                if (o.getTenToChuc().equals(user.getTenToChuc())) {
                    selectedOrganization = o;
                }
            }

            comboBoxOrganizaName.setValue(selectedOrganization);
        }
    }

    public void addOrInsert() {
        if (user.getIdHocBong() == null || user.getIdHocBong().isEmpty()) {
            Add_Users();
        } else {
            Edit_Users(user.getIdHocBong());
        }
    }

    public void Add_Users() {
        user.setSoTien(textFieldMoney.getText());
        Connection conn = ConnectionUtil.connectdb();
        String sql = "INSERT INTO THONGTINHOCBONG(IDHocBong,IDSinhVien,IDToChuc, NGAYNHAN, SOTIEN) VALUES(?,?,?,?,?);";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, String.valueOf((int) (random() * 10000000)));
            pst.setString(2, user.getMssv());
            pst.setString(3, selectedOrganization.getId());
            pst.setString(4, textFieldReceivedDate.getText());
            pst.setString(5, textFieldMoney.getText());

            pst.execute();
            JOptionPane.showConfirmDialog(null, "user add succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Edit_Users(String id) {
        user.setSoTien(textFieldMoney.getText());
        Connection conn = ConnectionUtil.connectdb();
        String sql = "UPDATE THONGTINHOCBONG\n" +
                "SET NGAYNHAN = ?, SOTIEN= ?, IDToChuc= ?\n" +
                "WHERE IDHocBong = ?;\n";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, textFieldReceivedDate.getText());
            pst.setString(2, textFieldMoney.getText());
            pst.setString(3, selectedOrganization.getId());
            pst.setString(4, id);
            pst.execute();
            JOptionPane.showConfirmDialog(null, "user editedit succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
