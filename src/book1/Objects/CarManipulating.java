package book1.Objects;

public class CarManipulating {
    static class Car {
        private String registerNumber;
        private String model;
        private String color;
        private int horsePower;
        private int numberOfDoors;

        Car(String registerNumber, String model, String color, int horsePower, int numberOfDoors) {
            this.registerNumber = registerNumber;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
            this.numberOfDoors = numberOfDoors;
        }

        public String getRegisterNumber() {
            return registerNumber;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsePower() {
            return horsePower;
        }

        public int getNumberOfDoors() {
            return numberOfDoors;
        }

        public void setRegisterNumber(String registerNumber) {
            this.registerNumber = registerNumber;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setHorsePower(int horsePower) {
            this.horsePower = horsePower;
        }

        public void setNumberOfDoors(int numberOfDoors) {
            this.numberOfDoors = numberOfDoors;
        }

        public void theCarSound() {
            System.out.println("The sound of my " + model + " is: Wuuuuuuuum.. ! ");
        }

    }

    public static void main(String[] args) {

        Car audi = new Car("X1367KT", "A4", "Grey", 180, 4);

        System.out.println("First values..");
        System.out.println(audi.getModel());
        System.out.println(audi.getRegisterNumber());
        System.out.println(audi.getColor());
        System.out.println(audi.getHorsePower());
        System.out.println(audi.getNumberOfDoors());

        audi.setModel("A6");
        audi.setRegisterNumber("X7669KH");
        audi.setColor("Metalic");
        audi.setHorsePower(210);
        audi.setNumberOfDoors(5);

        System.out.println();
        System.out.println("The changed values..");
        System.out.println(audi.getModel());
        System.out.println(audi.getRegisterNumber());
        System.out.println(audi.getColor());
        System.out.println(audi.getHorsePower());
        System.out.println(audi.getNumberOfDoors());
        audi.theCarSound();

    }

}

