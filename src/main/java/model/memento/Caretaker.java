package model.memento;

import model.Model;

/**
 *
 * @author Martin
 */
public class Caretaker {

    private Model originator;
    private Model.Memento memento;
    
    public Caretaker(Model originator)
    {
        this.originator = originator;
    }
    
    public void save()
    {
        memento = originator.createMemento();
    }
    
    public void load()
    {
        originator.setMemento(memento);
    }
    
}
