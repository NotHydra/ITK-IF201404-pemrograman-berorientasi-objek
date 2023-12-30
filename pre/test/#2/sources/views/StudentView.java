package views;

public class StudentView {
    public void display(String text) {
        try {
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
