module org.finalproject.loginregisterfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.finalproject.loginregisterfx to javafx.fxml;
    exports org.finalproject.loginregisterfx;
}