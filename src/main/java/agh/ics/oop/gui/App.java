package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;

import static java.lang.System.out;

public class App extends Application {

    public void start(Stage primaryStage){
        try {
            ArrayList<MoveDirection> directions = new OptionsParser().parse(getParameters().getRaw().toArray(new String[0]));
            GrassField map = new GrassField(15);
            Animal animal = new Animal(map, new Vector2d(3, 2));
            map.place(animal);
            Animal animal1=new Animal(map,new Vector2d(15,15));
            map.place(animal1);
            out.print(map);

            Vector2d upBoundary=map.getUpBoundary();
            Vector2d lowBoundary=map.getLowBoundary();
            GridPane grid = new GridPane();
            grid.setGridLinesVisible(true);
            Scene scene = new Scene(grid,400,400);
            grid.getColumnConstraints().add(new ColumnConstraints(20));
            grid.addColumn(0,new Label("y\\x"));
            int index=1;
            int range=upBoundary.x-lowBoundary.x+2;
            Label label;
            while (index<range){
                label=new Label(String.valueOf(lowBoundary.x+index-1));
                grid.getColumnConstraints().add(new ColumnConstraints(20));
                grid.addColumn(index,label);
                GridPane.setHalignment(label, HPos.CENTER);
                index++;
            }
            int verticalRange=upBoundary.y-lowBoundary.y+2;
            int verticalIndex=1;
            while (verticalIndex<verticalRange){
                grid.addRow(verticalIndex);
                label=new Label(String.valueOf(upBoundary.y-verticalIndex+1));
                grid.add(label,0,verticalIndex);
                GridPane.setHalignment(label, HPos.CENTER);
                index=1;
                while (index<range){
                    Vector2d actualPosition=new Vector2d(lowBoundary.x+index-1,upBoundary.y-verticalIndex+1);
                    if(map.isOccupied(actualPosition)) {
                        label = new Label(map.objectAt(actualPosition).toString());
                        grid.add(label,index,verticalIndex);
                        GridPane.setHalignment(label, HPos.CENTER);
                    }
                    index++;
                }
                verticalIndex++;
            }

            grid.setAlignment(Pos.CENTER);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(IllegalArgumentException ex){
            out.print(ex);
            return;
        }
    }


}
