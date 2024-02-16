package controllers;

import java.io.IOException;
import java.util.Stack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainController extends Application {
	private static Scene scene;

	public static void initialize(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		scene = new Scene(loadView("Main"));
		stage.setTitle("Calculator");
		stage.setScene(scene);
		stage.show();
	}

	public static void setRoot(String fxml) {
		scene.setRoot(loadView(fxml));
	}

	private static Parent loadView(String fxml) {
		try {
			return (new FXMLLoader(MainController.class.getResource("../views/" + fxml + "Page.fxml"))).load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@FXML
	private TextField textFieldResult;

	@FXML
	void buttonZero(ActionEvent event) {
		textFieldResult.setText(textFieldResult.getText() + "0");
	}

	@FXML
	void buttonOne(ActionEvent event) {
		textFieldResult.setText(textFieldResult.getText() + "1");
	}

	@FXML
	void buttonTwo(ActionEvent event) {
		textFieldResult.setText(textFieldResult.getText() + "2");
	}

	@FXML
	void buttonThree(ActionEvent event) {
		textFieldResult.setText(textFieldResult.getText() + "3");
	}

	@FXML
	void buttonFour(ActionEvent event) {
		textFieldResult.setText(textFieldResult.getText() + "4");
	}

	@FXML
	void buttonFive(ActionEvent event) {
		textFieldResult.setText(textFieldResult.getText() + "5");
	}

	@FXML
	void buttonSix(ActionEvent event) {
		textFieldResult.setText(textFieldResult.getText() + "6");
	}

	@FXML
	void buttonSeven(ActionEvent event) {
		textFieldResult.setText(textFieldResult.getText() + "7");
	}

	@FXML
	void buttonEight(ActionEvent event) {
		textFieldResult.setText(textFieldResult.getText() + "8");
	}

	@FXML
	void buttonNine(ActionEvent event) {
		textFieldResult.setText(textFieldResult.getText() + "9");
	}

	@FXML
	void buttonDot(ActionEvent event) {
		try {
			if (textFieldResult.getText().length() >= 1) {
				if (Character.isDigit(textFieldResult.getText().charAt(textFieldResult.getText().length() - 1))) {
					textFieldResult.setText(textFieldResult.getText() + ".");
				}
			}
		} catch (Error e) {
		}
	}

	@FXML
	void buttonOpenParantheses(ActionEvent event) {
		textFieldResult.setText(textFieldResult.getText() + "(");
	}

	@FXML
	void buttonCloseParantheses(ActionEvent event) {
		textFieldResult.setText(textFieldResult.getText() + ")");
	}

	@FXML
	void buttonClear(ActionEvent event) {
		textFieldResult.setText("");
	}

	@FXML
	void buttonDelete(ActionEvent event) {
		try {
			if(textFieldResult.getText().length() >= 1) {
				if (textFieldResult.getText().length() >= 6 && textFieldResult.getText().substring(textFieldResult.getText().length() - 5).equals(" mod ")) {
					textFieldResult.setText(textFieldResult.getText().substring(0, textFieldResult.getText().length() - 5));
				} else { 
					textFieldResult.setText(textFieldResult.getText().substring(0, textFieldResult.getText().length() - 1));
				}
			}
		} catch (Error e) {
		}
	}

	@FXML
	void buttonAdd(ActionEvent event) {
		try {
			if (textFieldResult.getText().length() >= 1) {
				if (Character.isDigit(textFieldResult.getText().charAt(textFieldResult.getText().length() - 1))) {
					textFieldResult.setText(textFieldResult.getText() + "+");
				}
			}
		} catch (Error e) { }
	}

	@FXML
	void buttonSubtract(ActionEvent event) {
		try {
			if (textFieldResult.getText().length() >= 1) {
				if (Character.isDigit(textFieldResult.getText().charAt(textFieldResult.getText().length() - 1))) {
					textFieldResult.setText(textFieldResult.getText() + "-");
				}
			}
		} catch (Error e) { }
	}

	@FXML
	void buttonMultiply(ActionEvent event) {
		try {
			if (textFieldResult.getText().length() >= 1) {
				if (Character.isDigit(textFieldResult.getText().charAt(textFieldResult.getText().length() - 1))) {
					textFieldResult.setText(textFieldResult.getText() + "×");
				}
			}
		} catch (Error e) { }
	}

	@FXML
	void buttonDivide(ActionEvent event) {
		try {
			if (textFieldResult.getText().length() >= 1) {
				if (Character.isDigit(textFieldResult.getText().charAt(textFieldResult.getText().length() - 1))) {
					textFieldResult.setText(textFieldResult.getText() + ":");
				}
			}
		} catch (Error e) { }
	}

	@FXML
	void buttonMod(ActionEvent event) {
		try {
			if (textFieldResult.getText().length() >= 1) {
				if (Character.isDigit(textFieldResult.getText().charAt(textFieldResult.getText().length() - 1))) {
					textFieldResult.setText(textFieldResult.getText() + " mod ");
				}
			}
		} catch (Error e) { }
	}

	@FXML
	void buttonExponent(ActionEvent event) {
		try {
			if (textFieldResult.getText().length() >= 1) {
				if (Character.isDigit(textFieldResult.getText().charAt(textFieldResult.getText().length() - 1))) {
					textFieldResult.setText(textFieldResult.getText() + "^");
				}
			}
		} catch (Error e) { }
	}

	@FXML
	void buttonRoot(ActionEvent event) {
		try {
			if (textFieldResult.getText().length() == 0 || (textFieldResult.getText().charAt(textFieldResult.getText().length() - 1) != '√' && !Character.isDigit(textFieldResult.getText().charAt(textFieldResult.getText().length() - 1)))) {
				textFieldResult.setText(textFieldResult.getText() + "√");
			}
		} catch (Error e) { }
	}

	@FXML
	void buttonLog(ActionEvent event) {
		textFieldResult.setText(textFieldResult.getText() + " log ");
	}

	@FXML
	void buttonEqual(ActionEvent event) {
		try {
			textFieldResult.setText(Double.toString((double) calculate(textFieldResult.getText())));
		} catch (Exception e) {
			if (e instanceof ArithmeticException || e instanceof IllegalArgumentException)
				textFieldResult.setText(e.getMessage());

			else {
				textFieldResult.setText("Invalid Syntax");
			}
		}
	}

	public static double calculate(String expression) {
		try {
			Stack<Double> numbers = new Stack<>();
			Stack<Character> operators = new Stack<>();

			expression = expression.replaceAll("\\s", "");
			expression = expression.replaceAll("×", "*");
			expression = expression.replaceAll(":", "/");
			expression = expression.replaceAll("mod", "%");

			for (int expressionIndex = 0; expressionIndex < expression.length(); expressionIndex++) {
				char currentCharacter = expression.charAt(expressionIndex);

				if (Character.isDigit(currentCharacter) || currentCharacter == '.') {
					StringBuilder number = new StringBuilder();
					number.append(currentCharacter);

					while (expressionIndex + 1 < expression.length() && (Character.isDigit(expression.charAt(expressionIndex + 1)) || expression.charAt(expressionIndex + 1) == '.')) {
						number.append(expression.charAt(++expressionIndex));
					}

					numbers.push(Double.parseDouble(number.toString()));
				} else if (currentCharacter == '(') {
					operators.push(currentCharacter);
				} else if (currentCharacter == ')') {
					while (operators.peek() != '(') {
						char operator = operators.pop();
						double firstNumber = numbers.pop();

						if (operator == '√') {
							numbers.push(executeOperation(operator, firstNumber, firstNumber));
						} else{
							numbers.push(executeOperation(operator, firstNumber, numbers.pop()));
						}
					}

					operators.pop();
				} else if (isOperator(currentCharacter)) {
					while (!operators.isEmpty() && expressionValidation(currentCharacter, operators.peek())) {
						char operator = operators.pop();
						double firstNumber = numbers.pop();

						if (operator == '√') {
							numbers.push(executeOperation(operator, firstNumber, firstNumber));
						} else{
							numbers.push(executeOperation(operator, firstNumber, numbers.pop()));
						}
					}

					operators.push(currentCharacter);
				}
			}

			while (!operators.isEmpty()) {
				char operator = operators.pop();
				double firstNumber = numbers.pop();

				if (operator == '√') {
					numbers.push(executeOperation(operator, firstNumber, firstNumber));
				} else{
					numbers.push(executeOperation(operator, firstNumber, numbers.pop()));
				}
			}

			return numbers.pop();
		} catch (Exception e) {
			throw e;
		}
	}

	private static boolean isOperator(char operator) {
		return operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '^' || operator == '%' || operator == '√' || operator == 'l';
	}

	private static boolean expressionValidation(char firstOperator, char secondOperator) {
		if (secondOperator == '(' || secondOperator == ')')
			return false;
		if ((firstOperator == '*' || firstOperator == '/') && (secondOperator == '+' || secondOperator == '-'))
			return false;
		if ((firstOperator == '^') && (secondOperator == '+' || secondOperator == '-' || secondOperator == '*' || secondOperator == '/'))
			return false;
		if ((firstOperator == '√' || firstOperator == '%') && (secondOperator == '+' || secondOperator == '-' || secondOperator == '*' || secondOperator == '/' || secondOperator == '^'))
			return false;
		if ((firstOperator == 'l') && (secondOperator == '+' || secondOperator == '-' || secondOperator == '*' || secondOperator == '/' || secondOperator == '^' || secondOperator == '%' || secondOperator == '√'))
			return false;

		return true;
	}

	private static double executeOperation(char operator, double firstNumber, double secondNumber) {
		try {
			switch (operator) {
				case '+':
					return secondNumber + firstNumber;

				case '-':
					return secondNumber - firstNumber;

				case '*':
					return secondNumber * firstNumber;

				case '/':
					if (firstNumber == 0) {
						throw new ArithmeticException("Division by zero!");
					}

					return secondNumber / firstNumber;

				case '^':
					return Math.pow(secondNumber, firstNumber);

				case '%':
					return secondNumber % firstNumber;

				case '√':
					return Math.sqrt(firstNumber);

				case 'l':
					return Math.log(secondNumber);

				default:
					throw new IllegalArgumentException("Invalid Syntax");
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
