import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BankAppUI extends Application {
    private BankAccount currentAccount;

    @Override
    public void start(Stage primaryStage) {
        // TextFields for user input
        TextField nameField = new TextField();
        nameField.setPromptText("Enter Name");

        TextField depositField = new TextField();
        depositField.setPromptText("Initial Deposit");

        TextField amountField = new TextField();
        amountField.setPromptText("Enter Amount");

        // ComboBox for selecting account type
        ComboBox<String> accountTypeBox = new ComboBox<>();
        accountTypeBox.getItems().addAll("Savings", "Current", "Fixed Deposit");
        accountTypeBox.setValue("Savings");

        // Buttons for actions
        Button createButton = new Button("Create Account");
        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");
        Button viewBalanceButton = new Button("View Balance");
        Button viewTransactionsButton = new Button("Transaction History");

        // Apply color styles to buttons
        createButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        depositButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        withdrawButton.setStyle("-fx-background-color: #FF5722; -fx-text-fill: white;");
        viewBalanceButton.setStyle("-fx-background-color: #9C27B0; -fx-text-fill: white;");
        viewTransactionsButton.setStyle("-fx-background-color: #795548; -fx-text-fill: white;");

        // Output area for transaction logs and messages
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setStyle("-fx-font-family: 'monospace'; -fx-control-inner-background: #f0f0f0;");

        // Event: Create Account
        createButton.setOnAction(e -> {
            // Validate fields before creating the account
            if (nameField.getText().isEmpty() || depositField.getText().isEmpty()) {
                outputArea.appendText("⚠ Please enter both name and initial deposit.\n");
                return;
            }

            try {
                String name = nameField.getText();
                double deposit = Double.parseDouble(depositField.getText());
                String type = accountTypeBox.getValue();

                switch (type) {
                    case "Savings":
                        currentAccount = new SavingsAccount("SA001", name, deposit);
                        break;
                    case "Current":
                        currentAccount = new CurrentAccount("CA001", name, deposit);
                        break;
                    case "Fixed Deposit":
                        currentAccount = new FixedDepositAccount("FD001", name, deposit);
                        break;
                }
                outputArea.appendText("✔ Created " + type + " account for " + name + " with $" + deposit + "\n");
                nameField.clear(); // Clear input fields
                depositField.clear();
            } catch (NumberFormatException ex) {
                outputArea.appendText("⚠ Please enter a valid initial deposit amount.\n");
            }
        });

        // Event: Deposit Money
        depositButton.setOnAction(e -> {
            if (currentAccount == null) {
                outputArea.appendText("⚠ Please create an account first.\n");
                return;
            }
            try {
                double amount = Double.parseDouble(amountField.getText());
                currentAccount.deposit(amount);
                outputArea.appendText("+ Deposited $" + amount + "\n");
                amountField.clear(); // Clear input field after deposit
            } catch (NumberFormatException ex) {
                outputArea.appendText("⚠ Invalid deposit amount.\n");
            }
        });

        // Event: Withdraw Money
        withdrawButton.setOnAction(e -> {
            if (currentAccount == null) {
                outputArea.appendText("⚠ Please create an account first.\n");
                return;
            }
            try {
                double amount = Double.parseDouble(amountField.getText());
                currentAccount.withdraw(amount);
                outputArea.appendText("- Attempted withdrawal of $" + amount + "\n");
                amountField.clear(); // Clear input field after withdrawal
            } catch (NumberFormatException ex) {
                outputArea.appendText("⚠ Invalid withdrawal amount.\n");
            }
        });

        // Event: View Balance
        viewBalanceButton.setOnAction(e -> {
            if (currentAccount == null) {
                outputArea.appendText("⚠ Please create an account first.\n");
                return;
            }
            outputArea.appendText("💰 Balance: $" + currentAccount.getBalance() + "\n");
        });

        // Event: View Transaction History
        viewTransactionsButton.setOnAction(e -> {
            if (currentAccount == null) {
                outputArea.appendText("⚠ Please create an account first.\n");
                return;
            }
            outputArea.appendText("📄 Transactions:\n");
            for (Transaction t : currentAccount.transactions) {
                outputArea.appendText(" - " + t + "\n");
            }
        });

        // Layout containers
        VBox accountInfoBox = new VBox(10,
            new Label("Account Holder:"), nameField,
            new Label("Initial Deposit:"), depositField,
            new Label("Account Type:"), accountTypeBox,
            createButton
        );
        //accountInfoBox.setAlignment(Pos.CENTER);  // Center the account info box
        VBox transactionBox = new VBox(10,
            new Label("Transaction Amount:"), amountField,
            depositButton, withdrawButton, viewBalanceButton, viewTransactionsButton
        );
        transactionBox.setAlignment(Pos.CENTER_RIGHT);  // Center the transaction box 

        VBox outputBox = new VBox(10, new Label("History:"), outputArea);

        // Main Layout container
        HBox mainBox = new HBox(20, accountInfoBox, transactionBox);

        //mainBox.setAlignment(Pos.CENTER);  // Center the boxes inside the HBox 

        VBox root = new VBox(20, mainBox, outputBox);
        root.setPadding(new Insets(15));
        root.setStyle("-fx-background-color: #fdfdfd;");

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bank Account Manager");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
