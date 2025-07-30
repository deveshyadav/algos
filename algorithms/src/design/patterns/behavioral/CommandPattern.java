package design.patterns.behavioral;

public class CommandPattern {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        Light light = new Light();

        remoteControl.setCommand(new LightOnCommand(light));
        remoteControl.pressButton();

        remoteControl.setCommand(new LightOffCommand(light));
        remoteControl.pressButton();


    }
}
class RemoteControl{
    Command command;

    void pressButton(){
        command.execute();
    }
    void setCommand(Command command){
        this.command=command;
    }
}
interface Command{
    void execute();
}
class Light{
    void turnOn(){
        System.out.println("Turning on lights");
    }

    void turnOff(){
        System.out.println("Turning off lights");
    }
}
class LightOnCommand implements Command{
    Light light;
    LightOnCommand(Light light){
        this.light=light;
    }
    @Override
    public void execute(){
        light.turnOn();
    }
}

class LightOffCommand implements Command{
    Light light;
    LightOffCommand(Light light){
        this.light=light;
    }
    @Override
    public void execute(){
        light.turnOff();
    }
}