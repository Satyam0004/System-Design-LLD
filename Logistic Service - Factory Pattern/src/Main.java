// NOTE: Factory Patterns
interface Logistics {
    void send();
}

class Road implements Logistics {
    @Override
    public void send() {
        System.out.println("Sent by Road");
    }
}

class Air implements Logistics {
    @Override
    public void send() {
        System.out.println("Sent by Air");
    }
}

class Train implements Logistics {
    @Override
    public void send() {
        System.out.println("Sent by Train");
    }
}

// NOTE: Here we can make the changes without breaking the Service class.
class LogisticsFactory {
    public static Logistics getLogistics(String mode) {
        if(mode == "road") return new Road();
        else if(mode == "air") return new Air();
        return new Train();
    }
}

class LogisticService {
// IMPORTANT: violating the singleton principle.

//    public void send(String mode) {
//        if(Objects.equals(mode, "Air")) {
//            System.out.println("Sent by Air");
//        } else {
//            if(Objects.equals(mode, "Road")) System.out.println("Sent by Road");
//        }
//    }

// IMPORTANT: Recommended Way. -> Factory Pattern
    public void send(String mode) {
        Logistics logistics = LogisticsFactory.getLogistics(mode);
        logistics.send();
    }
}

public class Main {
    public static void main(String[] args) {
        LogisticService logisticService = new LogisticService();
        logisticService.send("road");
        logisticService.send("air");
        logisticService.send("train");
    }
}