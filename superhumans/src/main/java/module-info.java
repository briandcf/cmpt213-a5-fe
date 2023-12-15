module com.example {
    requires transitive javafx.controls;
    requires com.fasterxml.jackson.databind;  // This is for jackson-databind
    requires com.fasterxml.jackson.core;      // This is for jackson-core
    requires com.fasterxml.jackson.annotation;
     opens com.example.superHumanLogic to com.fasterxml.jackson.databind;
    exports com.example.superHumanLogic;
    opens com.example to javafx.fxml;
    exports com.example;
}
