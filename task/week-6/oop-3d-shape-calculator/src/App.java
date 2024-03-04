import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int length = 80;

    private static int menuOption;

    public static void main(String[] args) throws Exception {
        printBorder();
        printTitle("3D Shape Calculator");
        
        while (true) {      
            getMenuOption();
            
            if (menuOption == 1) {
                menuCube();
            } else if (menuOption == 2) {
                menuCuboid();
            } else if (menuOption == 3) {
                menuCone();
            } else if (menuOption == 4) {
                menuCylinder();
            } else if (menuOption == 5) {
                menuSphere();
            } else if (menuOption == 6) {
                menuHistory();
            } else if (menuOption == 7) {
                printBorder();
                printTitle("Thank You For Using 3D Shape Calculator");
                printBorder();

                break;
            }
        }
    }

    private static void printBorder() {
        for (int i = 0; i < length; i++) {
            System.out.print("=");
        }

        System.out.println();
    }

    private static void printTitle(String title) {
        final int padding = (length - title.length()) / 2;

        for (int i = 0; i < padding; i++) {
            System.out.print("-");
        }

        System.out.print(title);

        for (int i = 0; i < (title.length() % 2 == 0 ? padding : padding +  1); i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    private static void getMenuOption() {
        printBorder();
        printTitle("Menu");

        while (true) {
            printBorder();
            System.out.println("1. Cube");
            System.out.println("2. Cuboid");
            System.out.println("3. Cone");
            System.out.println("4. Cylinder");
            System.out.println("5. Sphere");
            System.out.println("6. History");
            System.out.println("7. Exit");

            printBorder();
            System.out.print("Choose a menu option: ");            

            try {
                menuOption = scanner.nextInt();

                if (menuOption < 1 || menuOption > 7) {
                    throw new IllegalArgumentException("Input can only accept a number between 1 to 7");
                }

                break;
            } catch (InputMismatchException e) {
                printBorder();
                System.out.println("Input can only accept a number");
                scanner.next();
            } catch (IllegalArgumentException e) {
                printBorder();
                System.out.println(e.getMessage());
                scanner.reset();
            } catch (Exception e) {
                printBorder();
                System.out.println("Invalid input, please try again.");
                scanner.next();
            }
        }
    }

    private static void menuCube() {
        printBorder();
        printTitle("Cube");
        
        float length = 0;
        while (true) {
            printBorder();
            System.out.print("Insert length: ");

            try {
                length = scanner.nextFloat();

                break;
            } catch (InputMismatchException e) {
                printBorder();
                System.out.println("Input can only accept a number");
                scanner.next();
            } catch (Exception e) {
                printBorder();
                System.out.println("Invalid input, please try again.");
                scanner.next();
            }
        }
        
        final Cube cube = new Cube(length);
           
        printBorder();
        printTitle("Result");
        printBorder();

        System.out.println("Length: " + cube.getLength());
        
        printBorder();

        System.out.println("Volume: " + cube.getVolume());
        System.out.println("Surface Area: " + cube.getSurfaceArea());
    }

    private static void menuCuboid() {
        printBorder();
        printTitle("Cuboid");
        
        float length = 0;
        float width = 0;
        float height = 0;
        while (true) {
            printBorder();
            System.out.print("Insert length: ");

            try {
                length = scanner.nextFloat();

                break;
            } catch (InputMismatchException e) {
                printBorder();
                System.out.println("Input can only accept a number");
                scanner.next();
            } catch (Exception e) {
                printBorder();
                System.out.println("Invalid input, please try again.");
                scanner.next();
            }
        }
        
        while (true) {
            printBorder();
            System.out.print("Insert width: ");

            try {
                width = scanner.nextFloat();

                break;
            } catch (InputMismatchException e) {
                printBorder();
                System.out.println("Input can only accept a number");
                scanner.next();
            } catch (Exception e) {
                printBorder();
                System.out.println("Invalid input, please try again.");
                scanner.next();
            }
        }
        
        while (true) {
            printBorder();
            System.out.print("Insert height: ");

            try {
                height = scanner.nextFloat();

                break;
            } catch (InputMismatchException e) {
                printBorder();
                System.out.println("Input can only accept a number");
                scanner.next();
            } catch (Exception e) {
                printBorder();
                System.out.println("Invalid input, please try again.");
                scanner.next();
            }
        }
        
        final Cuboid cuboid = new Cuboid(length, width, height);
           
        printBorder();
        printTitle("Result");
        printBorder();

        System.out.println("Length: " + cuboid.getLength());
        System.out.println("Width: " + cuboid.getWidth());
        System.out.println("Height: " + cuboid.getHeight());
        
        printBorder();

        System.out.println("Volume: " + cuboid.getVolume());
        System.out.println("Surface Area: " + cuboid.getSurfaceArea());
    }
    
    private static void menuCone() {
        printBorder();
        printTitle("Cone");
        
        float radius = 0;
        float height = 0;
        while (true) {
            printBorder();
            System.out.print("Insert radius: ");

            try {
                radius = scanner.nextFloat();

                break;
            } catch (InputMismatchException e) {
                printBorder();
                System.out.println("Input can only accept a number");
                scanner.next();
            } catch (Exception e) {
                printBorder();
                System.out.println("Invalid input, please try again.");
                scanner.next();
            }
        }
        
        while (true) {
            printBorder();
            System.out.print("Insert height: ");

            try {
                height = scanner.nextFloat();

                break;
            } catch (InputMismatchException e) {
                printBorder();
                System.out.println("Input can only accept a number");
                scanner.next();
            } catch (Exception e) {
                printBorder();
                System.out.println("Invalid input, please try again.");
                scanner.next();
            }
        }
        
        final Cone cone = new Cone(radius, height);
           
        printBorder();
        printTitle("Result");
        printBorder();

        System.out.println("Radius: " + cone.getRadius());
        System.out.println("Height: " + cone.getHeight());
        
        printBorder();

        System.out.println("Volume: " + cone.getVolume());
        System.out.println("Surface Area: " + cone.getSurfaceArea());
    }

    private static void menuCylinder() {
        printBorder();
        printTitle("Cylinder");
        
        float radius = 0;
        float height = 0;
        while (true) {
            printBorder();
            System.out.print("Insert radius: ");

            try {
                radius = scanner.nextFloat();

                break;
            } catch (InputMismatchException e) {
                printBorder();
                System.out.println("Input can only accept a number");
                scanner.next();
            } catch (Exception e) {
                printBorder();
                System.out.println("Invalid input, please try again.");
                scanner.next();
            }
        }
        
        while (true) {
            printBorder();
            System.out.print("Insert height: ");

            try {
                height = scanner.nextFloat();

                break;
            } catch (InputMismatchException e) {
                printBorder();
                System.out.println("Input can only accept a number");
                scanner.next();
            } catch (Exception e) {
                printBorder();
                System.out.println("Invalid input, please try again.");
                scanner.next();
            }
        }
        
        final Cylinder cylinder = new Cylinder(radius, height);
           
        printBorder();
        printTitle("Result");
        printBorder();

        System.out.println("Radius: " + cylinder.getRadius());
        System.out.println("Height: " + cylinder.getHeight());
        
        printBorder();

        System.out.println("Volume: " + cylinder.getVolume());
        System.out.println("Surface Area: " + cylinder.getSurfaceArea());
    }

    private static void menuSphere() {
        printBorder();
        printTitle("Sphere");
        
        float radius = 0;
        while (true) {
            printBorder();
            System.out.print("Insert radius: ");

            try {
                radius = scanner.nextFloat();

                break;
            } catch (InputMismatchException e) {
                printBorder();
                System.out.println("Input can only accept a number");
                scanner.next();
            } catch (Exception e) {
                printBorder();
                System.out.println("Invalid input, please try again.");
                scanner.next();
            }
        }
        
        final Sphere sphere = new Sphere(radius);
           
        printBorder();
        printTitle("Result");
        printBorder();

        System.out.println("Radius: " + sphere.getRadius());
        
        printBorder();

        System.out.println("Volume: " + sphere.getVolume());
        System.out.println("Surface Area: " + sphere.getSurfaceArea());
    }

    private static void menuHistory() {
        printBorder();
        printTitle("History");
        
        printBorder();
        printTitle("Cube");
        
        printBorder();
        if (Cube.history.size() == 0) {
            System.out.println("No history");
        } else {
            for (final Cube cube : Cube.history) {
                System.out.println(cube.getId() + ". " + cube.toString());
            }
        }

        printBorder();
        printTitle("Cuboid");

        printBorder();
        if (Cuboid.history.size() == 0) {
            System.out.println("No history");
        } else {
            for (final Cuboid cuboid : Cuboid.history) {
                System.out.println(cuboid.getId() + ". " + cuboid.toString());
            }
        }

        printBorder();
        printTitle("Cone");

        printBorder();
        if (Cone.history.size() == 0) {
            System.out.println("No history");
        } else {
            for (final Cone cone : Cone.history) {
                System.out.println(cone.getId() + ". " + cone.toString());
            }
        }

        printBorder();
        printTitle("Cylinder");

        printBorder();
        if (Cylinder.history.size() == 0) {
            System.out.println("No history");
        } else {
            for (final Cylinder cylinder : Cylinder.history) {
                System.out.println(cylinder.getId() + ". " + cylinder.toString());
            }
        }

        printBorder();
        printTitle("Sphere");

        printBorder();
        if (Sphere.history.size() == 0) {
            System.out.println("No history");
        } else {
            for (final Sphere sphere : Sphere.history) {
                System.out.println(sphere.getId() + ". " + sphere.toString());
            }
        }
    }
}
