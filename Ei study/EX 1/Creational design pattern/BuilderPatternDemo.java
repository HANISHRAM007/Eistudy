// Product class
class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private boolean graphicsCard;

    private Computer(ComputerBuilder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + ", graphicsCard=" + graphicsCard + "]";
    }

    // Builder class
    public static class ComputerBuilder {
        private String CPU;
        private String RAM;
        private String storage;
        private boolean graphicsCard;

        public ComputerBuilder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public ComputerBuilder addStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder addGraphicsCard(boolean graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

// Client
public class BuilderPatternDemo {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder("Intel i7", "16GB")
            .addStorage("1TB SSD")
            .addGraphicsCard(true)
            .build();

        System.out.println(computer);

        Computer anotherComputer = new Computer.ComputerBuilder("AMD Ryzen 5", "8GB")
            .addStorage("512GB SSD")
            .addGraphicsCard(false)
            .build();

        System.out.println(anotherComputer);
    }
}
