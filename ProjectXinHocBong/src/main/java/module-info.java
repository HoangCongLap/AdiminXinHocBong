module com.example.XinHocBong {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens xinhocbong to javafx.fxml;
    exports xinhocbong.function;
    opens xinhocbong.function to javafx.fxml;
    exports xinhocbong.database;
    exports xinhocbong.users;
    opens xinhocbong.database to javafx.fxml;
    exports xinhocbong.mySql;
    opens xinhocbong.mySql to javafx.fxml;
    exports xinhocbong.alertbox;
    opens xinhocbong.alertbox to javafx.fxml;
//    opens xinhocbong.Main to javafx.fxml;
    exports xinhocbong;
}