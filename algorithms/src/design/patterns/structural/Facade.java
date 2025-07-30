package design.patterns.structural;

import java.lang.management.MemoryManagerMXBean;

public class Facade {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startComputer();
    }
}

class CPU{
    void startCPU(){
        System.out.println("CPU started");
    }
}

class Memory{
    void loadMemory(){
        System.out.println("Memory Loaded");
    }
}

class HDD{
    void read(){
        System.out.println("Read HDD");
    }
}

class Computer{
    CPU cpu = new CPU();
    Memory memory = new Memory();
    HDD hdd = new HDD();

    void startComputer(){
        cpu.startCPU();;
        memory.loadMemory();
        hdd.read();
    }

}
