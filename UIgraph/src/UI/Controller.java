package UI;


import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import math.Curve;
import math.Ellipse;
import math.Hyperbola;
import math.Parabola;

public class Controller<actionEvent> {

	@FXML
	private Button butb;

	@FXML
	private AnchorPane pane;

	@FXML
	private ComboBox<Curve> curveBox;


	@FXML
	private Pane curvePane;

	@FXML
	private Button but;


	private MyCanvas myCanvas;
	@FXML
	void initialize() {
		myCanvas = new MyCanvas(curvePane);
		pane.getChildren().add(myCanvas);

		ArrayList<Curve> options = new ArrayList<>();
		options.add(new Ellipse(1,1, myCanvas));
		options.add(new Ellipse(0.5d, 1d, myCanvas));
		options.add(new Ellipse(1, 0.5d,myCanvas));
		options.add(new Parabola(0.5d, myCanvas));
		options.add(new Parabola(-10d, myCanvas));
		options.add(new Hyperbola(-2, 3, myCanvas));
		options.add(new Hyperbola(4.5, -5, myCanvas));
		curveBox.setItems(FXCollections.observableArrayList(options));

		curveBox.setOnAction(actionEvent -> {
			myCanvas.qDraw(curveBox.getValue());
		});

		but.setOnAction(actionEvent -> {
			myCanvas.zoomIn();
			if (myCanvas.cureveHavePrinted) {
				myCanvas.drawAll(curveBox.getValue());
			} else {
				myCanvas.drawPreAll();
			}
		});

		butb.setOnAction(actionEvent -> {
			myCanvas.zoomOut();
			if (myCanvas.cureveHavePrinted) {
				myCanvas.drawAll(curveBox.getValue());
			} else {
				myCanvas.drawPreAll();
			}
		});
	}
}
