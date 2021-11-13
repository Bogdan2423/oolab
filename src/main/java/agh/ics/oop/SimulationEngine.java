package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine{
    private ArrayList<MoveDirection> directions;
    private ArrayList<Animal> animals=new ArrayList<Animal>();

    SimulationEngine(ArrayList<MoveDirection> directions,
                     IWorldMap map, Vector2d[] animalPositions){
        this.directions=directions;
        for (Vector2d position:animalPositions) {
            Animal newAnimal=new Animal(map,position);
            map.place(newAnimal);
            this.animals.add(newAnimal);
        }
    }
    public boolean animalIsAt(int i, Vector2d pos){
        return animals.get(i).isAt(pos);
    }
    public void run() {
        int animalCount=animals.size();
        int i=0;
        Animal currAnimal=animals.get(i);
        for (MoveDirection direction:directions){
            currAnimal.move(direction);
            i=(i+1)%animalCount;
            currAnimal=animals.get(i);
        }
    }
}
