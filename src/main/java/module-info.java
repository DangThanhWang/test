module application.demo3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires language.en;
    requires languagetool.core;

    opens application.demo3 to javafx.fxml;
    exports application.demo3;
}