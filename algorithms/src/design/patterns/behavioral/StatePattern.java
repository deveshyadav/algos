package design.patterns.behavioral;

public class StatePattern {
    public static void main(String[] args) {
        Light1 light1 = new Light1();
        light1.setState(new StateOff());
        light1.toggleSwitch();

        light1.setState(new StateOn());
        light1.toggleSwitch();
    }
}

interface State{
    void handle(Light1 light);
}
class StateOn implements State{
    @Override
    public void handle(Light1 light1) {
        System.out.println("Turn On ");
    }
}

class StateOff implements State{
    @Override
    public void handle(Light1 light1) {
        System.out.println("Turn Off");
    }
}

class Light1{
    State state;
    void setState(State state){
        this.state=state;
    }
    void toggleSwitch(){
        state.handle(this);
    }
}


