package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Platform;

import java.util.ArrayList;

import static java.lang.System.out;

public class SimulationEngine implements IEngine,Runnable{
    private ArrayList<MoveDirection> directions;
    private ArrayList<Animal> animals=new ArrayList<Animal>();
    private App app;

    public SimulationEngine(ArrayList<MoveDirection> directions,
                            IWorldMap map, Vector2d[] animalPositions){
        this.app=app;
        this.directions=directions;
        for (Vector2d position:animalPositions) {
            Animal newAnimal=new Animal(map,position);
            map.place(newAnimal);
            this.animals.add(newAnimal);
        }
    }
    public SimulationEngine(ArrayList<MoveDirection> directions,
                            IWorldMap map, Vector2d[] animalPositions, App app){
        this.app=app;
        this.directions=directions;
        for (Vector2d position:animalPositions) {
            Animal newAnimal=new Animal(map,position);
            map.place(newAnimal);
            this.animals.add(newAnimal);
        }
    }
    public SimulationEngine(IWorldMap map,Vector2d[] animalPositions,App app){
        this.app=app;
        for (Vector2d position:animalPositions) {
            Animal newAnimal=new Animal(map,position);
            map.place(newAnimal);
            this.animals.add(newAnimal);
        }
    }

    public void run() {
        int moveDelay=1000;
        int animalCount=animals.size();
        int i=0;
        Animal currAnimal=animals.get(i);
        Platform.runLater(()-> app.showMap());
        for (MoveDirection direction:directions){
            try{Thread.sleep(moveDelay);}
            catch (InterruptedException ex){out.print("Simulation stopped");}
            Platform.runLater(()-> app.showMap());
            currAnimal.move(direction);
            i=(i+1)%animalCount;
            currAnimal=animals.get(i);
        }
    }

    public boolean animalIsAt(int i, Vector2d pos){
        return animals.get(i).isAt(pos);
    }

    public void setDirections(ArrayList<MoveDirection> directions){this.directions=directions;}
}
