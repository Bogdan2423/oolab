package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import static java.lang.System.out;

public class App extends Application {
    AbstractWorldMap map;
    int columnWidth=40;
    int rowHeight=40;
    GridPane grid;
    Vector2d lowBoundary;
    Vector2d upBoundary;

    public void start(Stage primaryStage){
        try {
            Vector2d[] animalPositions={new Vector2d(3,2),new Vector2d(4,5)};
            grid = new GridPane();
            TextField textField=new TextField();
            Button button=new Button("Start");
            VBox vbox=new VBox(textField,button);
            HBox hbox=new HBox(vbox,grid);
            Scene scene = new Scene(hbox,1000,600);
            grid.setAlignment(Pos.TOP_RIGHT);
            primaryStage.setScene(scene);
            primaryStage.show();
            button.setOnAction((event -> {
                map = new GrassField(15);
                String args=textField.getText();
                lowBoundary= map.getLowBoundary();
                upBoundary=map.getUpBoundary();
                SimulationEngine engine =
                      new SimulationEngine(
                              new OptionsParser().parse(new StringToArray().convert(textField.getText())),
                              map,animalPositions,this);
                Thread engineThread=new Thread(engine);
                engineThread.start();
            }));
        }
        catch(IllegalArgumentException ex){
            out.print(ex);
            return;
        }
    }


    public void showMap(){
        grid.setGridLinesVisible(false);
        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();
        grid.getChildren().clear();
        grid.setGridLinesVisible(true);
        makeGrid(grid,lowBoundary,upBoundary);
        addElements(grid,lowBoundary,upBoundary);
    }

    private void makeGrid(GridPane grid, Vector2d lowBoundary, Vector2d upBoundary){

        Label label;
        grid.getColumnConstraints().add(new ColumnConstraints(columnWidth));
        label=new Label("y\\x");
        grid.addColumn(0,label);
        GridPane.setHalignment(label, HPos.CENTER);

        int index=1;
        int range=upBoundary.x-lowBoundary.x+2;
        while (index<range){
            label=new Label(String.valueOf(lowBoundary.x+index-1));
            grid.getColumnConstraints().add(new ColumnConstraints(columnWidth));
            grid.addColumn(index,label);
            GridPane.setHalignment(label, HPos.CENTER);
            index++;
        }

        int verticalRange=upBoundary.y-lowBoundary.y+2;
        int verticalIndex=1;
        while (verticalIndex<verticalRange){
            grid.addRow(verticalIndex);
            grid.getRowConstraints().add(new RowConstraints(rowHeight));
            label=new Label(String.valueOf(upBoundary.y-verticalIndex+1));
            grid.add(label,0,verticalIndex);
            GridPane.setHalignment(label, HPos.CENTER);
            verticalIndex++;
        }
    }

    private void addElements(GridPane grid, Vector2d lowBoundary, Vector2d upBoundary){

        int range=upBoundary.x-lowBoundary.x+2;
        int verticalRange=upBoundary.y-lowBoundary.y+2;
        int verticalIndex=1;
        while (verticalIndex<verticalRange) {
            int index = 1;
            VBox vBox;
            while (index < range) {
                Vector2d actualPosition = new Vector2d(lowBoundary.x + index - 1, upBoundary.y - verticalIndex + 1);
                if (map.isOccupied(actualPosition)) {
                    vBox = new GuiElementBox((IMapElement) map.objectAt(actualPosition)).getvBox();
                    GridPane.setHalignment(vBox, HPos.CENTER);
                    grid.add(vBox, index, verticalIndex);
                }
                index++;
            }
            verticalIndex++;
        }
    }

}
