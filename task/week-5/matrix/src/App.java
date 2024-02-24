import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final boolean isRunning = true;
    private static final int length = 65;

    private static final ArrayList<int[][]> matrices = new ArrayList<int[][]>(); 

    private static int menuOption;
    private static int manageOption;

    public static void main(String[] args) throws Exception {
        matrices.add(new int[][] {
            {1, 2},
            {3, 4}
        });

        matrices.add(new int[][] {
            {5, 6},
            {7, 8}
        });

        matrices.add(new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        });

        matrices.add(new int[][] {
            {10, 11, 12},
            {13, 14, 15},
            {16, 17, 18}
        });

        printBorder();
        printTitle("Matrix Operation");
        
        while (isRunning) {      
            getMenuOption();
            
            if (menuOption == 1) {
                getManageOption();

                if (manageOption == 1) {
                    manageView();
                } else if (manageOption == 2) {
                    manageAdd();
                } else if (manageOption == 3) {
                    manageChange();
                } else if (manageOption == 4) {
                    manageRemove();
                } else if (manageOption == 5) {
                    continue;
                }
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

    private static void printMatrix(int[][] matrix) {
        System.out.print("[");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (matrix[i].length -1 != j) {
                    System.out.print(", ");
                }
            }

            System.out.print("]");
            if (matrix.length -1 != i) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    private static void getMenuOption() {
        printBorder();
        printTitle("Menu");

        while (true) {
            printBorder();
            System.out.println("1. Manage");
            System.out.println("2. Operate");
            System.out.println("3. Exit");

            printBorder();
            System.out.print("Choose a menu option: ");            

            try {
                menuOption = scanner.nextInt();

                if (menuOption < 1 || menuOption > 3) {
                    throw new IllegalArgumentException("Input can only accept a number between 1 to 3");
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

    private static void getManageOption() {
        printBorder();
        printTitle("Manage");

        while (true) {
            printBorder();
            System.out.println("1. View");
            System.out.println("2. Add");
            System.out.println("3. Change");
            System.out.println("4. Remove");
            System.out.println("5. Back");

            printBorder();
            System.out.print("Choose a manage option: ");  

            try {
                manageOption = scanner.nextInt();

                if (manageOption < 1 || manageOption > 5) {
                    throw new IllegalArgumentException("Input can only accept a number between 1 to 5");
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

    private static void manageAdd() {
        printBorder();
        printTitle("Add");
        
        int rowSize = 0;
        while (true) {
            printBorder();
            System.out.print("Insert row size: ");

            try {
                rowSize = scanner.nextInt();

                if (rowSize < 2) {
                    throw new IllegalArgumentException("Row size must be greater than 1");
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
    
        
        int columnSize = 0;
        while (true) {
            printBorder();
            System.out.print("Insert column size: ");

            try {
                columnSize = scanner.nextInt();

                if (columnSize < 2) {
                    throw new IllegalArgumentException("Column size must be greater than 1");
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
            
        int[][] newMatrix = new int[rowSize][columnSize];
        printBorder();
        printTitle("Input New Matrix Value");

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                while (true) {
                    printBorder();
                    System.out.print("Insert value [" + i + "][" + j + "]: ");

                    try {
                        newMatrix[i][j] = scanner.nextInt();

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
            }
        }

        matrices.add(newMatrix);

        printBorder();
        printTitle("New Matrix Added");
        
        printBorder();
        System.out.print("Added Matrix: ");
        printMatrix(newMatrix);
    }

    private static void manageView() {
        printBorder();
        printTitle("View");
        
        printBorder();
        
        if( matrices.size() == 0) {
            System.out.println("No matrix available");
        } else {
            for (int i = 0; i < matrices.size(); i++) {
                System.out.print((i + 1) + ". size(" + matrices.get(i).length + ", " + matrices.get(i)[0].length + "), ");
                printMatrix(matrices.get(i));
            }
        }

    }

    private static void manageChange() {
        printBorder();
        printTitle("Change");

        printBorder();
        if (matrices.size() == 0) {
            System.out.println("No matrix available");
        } else {
            for (int i = 0; i < matrices.size(); i++) {
                System.out.print((i + 1) + ". size(" + matrices.get(i).length + ", " + matrices.get(i)[0].length + "), ");
                printMatrix(matrices.get(i));
            }

            int matrixIndex = 0;
            while (true) {
                printBorder();
                System.out.print("Choose a matrix to change: ");

                try {
                    matrixIndex = scanner.nextInt();

                    if (matrixIndex < 1 || matrixIndex > matrices.size()) {
                        throw new IllegalArgumentException("Input can only accept a number between 1 to " + matrices.size());
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

            int matrixRowIndex = 0;
            while (true) {
                printBorder();
                System.out.print("Insert row position to change: ");

                try {
                    matrixRowIndex = scanner.nextInt();

                    if (matrixRowIndex < 1 || matrixRowIndex > matrices.get(matrixIndex - 1).length) {
                        throw new IllegalArgumentException("Input can only accept a number between 1 to " + matrices.get(matrixIndex - 1).length);
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
        
            int matrixColumnIndex = 0;
            while (true) {
                printBorder();
                System.out.print("Insert column position to change: ");

                try {
                    matrixColumnIndex = scanner.nextInt();

                    if (matrixColumnIndex < 1 || matrixColumnIndex > matrices.get(matrixIndex - 1)[0].length) {
                        throw new IllegalArgumentException("Input can only accept a number between 1 to " + matrices.get(matrixIndex - 1)[0].length);
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
        
            int matrixValue = 0;
            while (true) {
                printBorder();
                System.out.print("Insert new value [" + matrixRowIndex + "][" + matrixColumnIndex + "]: ");

                try {
                    matrixValue = scanner.nextInt();

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

            printBorder();
            printTitle("Matrix Changed");

            printBorder();
            System.out.print("Previous Matrix: ");
            printMatrix(matrices.get(matrixIndex - 1));

            matrices.get(matrixIndex - 1)[matrixRowIndex - 1][matrixColumnIndex - 1] = matrixValue;
            
            printBorder();
            System.out.print("Changed Matrix: ");
            printMatrix(matrices.get(matrixIndex - 1));
        }
    }

    private static void manageRemove() {
        printBorder();
        printTitle("Remove");

        printBorder();
        if (matrices.size() == 0) {
            System.out.println("No matrix available");
        } else {    
            for (int i = 0; i < matrices.size(); i++) {
                System.out.print((i + 1) + ". size(" + matrices.get(i).length + ", " + matrices.get(i)[0].length + "), ");
                printMatrix(matrices.get(i));
            }

            int matrixIndex = 0;
            while (true) {
                printBorder();
                System.out.print("Choose a matrix to remove: ");

                try {
                    matrixIndex = scanner.nextInt();

                    if (matrixIndex < 1 || matrixIndex > matrices.size()) {
                        throw new IllegalArgumentException("Input can only accept a number between 1 to " + matrices.size());
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

            printBorder();
            printTitle("Matrix Removed");

            printBorder();
            System.out.print("Removed Matrix: ");
            printMatrix(matrices.get(matrixIndex - 1));

            matrices.remove(matrixIndex - 1);
        }
    }
}
