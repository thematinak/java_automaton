module org.example.anoita {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens org.example.anoita to javafx.fxml;
    exports org.example.anoita;
    exports org.example.anoita.materials.abst;
    exports org.example.anoita.materials.liquids;
    exports org.example.anoita.materials.particles;
    exports org.example.anoita.materials.solid;
    exports org.example.anoita.materials.ables;
    exports org.example.anoita.controler;
    opens org.example.anoita.controler to javafx.fxml;
    exports org.example.anoita.model;
    opens org.example.anoita.model to javafx.fxml;
    exports org.example.anoita.util;
    opens org.example.anoita.util to javafx.fxml;
}