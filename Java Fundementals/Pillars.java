public class Pillars {

    public static void main(String[] args) {


        Array[] int arrayList = new int[5];

        public interface Shape {
            double area();   // no 'method' keyword — just return type + name
        }

        public class Circle implements Shape {
            private double radius;

            public Circle(double radius) {
                this.radius = radius;
            }

            @Override
            public double area() {
                return Math.PI * radius * radius;
            }
        }

        public class Rectangle implements Shape {
            private double width, height;

            public Rectangle(double width, double height) {
                this.width = width;
                this.height = height;
            }

            @Override
            public double area() {
                return width * height;
            }
        }

// And to run it:
        public class Main {
            public static void main(String[] args) {
                Shape circle = new Circle(5);
                Shape rectangle = new Rectangle(4, 6);

                System.out.println("Circle area: " + circle.area());       // 78.53...
                System.out.println("Rectangle area: " + rectangle.area()); // 24.0
            }
        }


    }
}
