package controllers;

import classes.Items;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import classes.Transactions;
import classes.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    public Label HelloLabel;
    @FXML
    private TableView<Transactions> TransactionTable;
    @FXML
    private TableColumn<Transactions, Integer> Tnumm;

    @FXML
    private TableColumn<Transactions, String> User1Col;

    @FXML
    private TableColumn<Transactions, String> Type;

    @FXML
    private TableColumn<Transactions, String> User2Col;
    @FXML
    private TableColumn<Transactions, Integer> Amount;


    private Stage stage;
    private Scene scene;
    private Parent root;
    public static   User x;
    private List<Transactions> table=new ArrayList<>() ;
    //copy
    public void TransactionTableView(ObservableList<Transactions> table) {
        TransactionTable.getItems().clear();
        Tnumm.setCellValueFactory(new PropertyValueFactory<Transactions,Integer>("Tnum"));
        User1Col.setCellValueFactory(new PropertyValueFactory<Transactions,String>("firstName"));
        Type.setCellValueFactory(new PropertyValueFactory<Transactions,String>("Type"));
        User2Col.setCellValueFactory(new PropertyValueFactory<Transactions,String>("secondName"));
        Amount.setCellValueFactory(new PropertyValueFactory<Transactions,Integer>("amount"));
        TransactionTable.setItems(table);
    }
    public void switchToBuyItems(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../fxml_fill/BuyItemsPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToTransfer(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/TransferPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToPayBills(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/PayBillPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void initialize (URL url, ResourceBundle resourceBundle)  {
        try {
            Transactions Y=new Transactions();
            Y.setFirstName(x.getName());
            TransactionTableView(FXCollections.observableList(Y.ShowRecords()));
        }
        catch (Exception e) {
            System.out.println("not working");
        }
    }
    public void switchToStatement(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/StatementPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToMainPage(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/MainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
        public void Buymac(ActionEvent a) {
        try {
            int amount= Items.getPrice("Mackbook");
            if (x.getBalance() <amount) throw new ArithmeticException();
            else {
                Transactions.TransferBank(x,amount);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Congratulations");
                alert.setContentText("Item bought successfully");
                alert.show();
            }
        }
        catch (ArithmeticException | SQLException al) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Insufficient Funds");
            alert.setContentText("Check Balance");
            alert.show();
        }
    }
        public void Buyiphone(ActionEvent a){
            try {
                int amount= Items.getPrice("Iphone");
                if (x.getBalance() <amount) throw new ArithmeticException();
                else {
                    Transactions.TransferBank(x,amount);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Congratulations");
                    alert.setContentText("Item bought successfully");
                    alert.show();
                }
            }
            catch (ArithmeticException | SQLException al) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Insufficient Funds");
                alert.setContentText("Check Balance");
                alert.show();
            }
        }
        public void BuyPS5(ActionEvent a){
            try {
                int amount= Items.getPrice("Ps5");
                if (x.getBalance() <amount) throw new ArithmeticException();
                else {
                    Transactions.TransferBank(x,amount);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Congratulations");
                    alert.setContentText("Item bought successfully");
                    alert.show();
                }
            }
            catch (ArithmeticException | SQLException al) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Insufficient Funds");
                alert.setContentText("Check Balance");
                alert.show();
            }

    }
        public void BuyTv(ActionEvent a){
        try {
            int amount= Items.getPrice("Apple Tv");
            if (x.getBalance() <amount) throw new ArithmeticException();
            else {
                Transactions.TransferBank(x,amount);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Congratulations");
                alert.setContentText("Item bought successfully");
                alert.show();
            }
        }
        catch (ArithmeticException | SQLException al) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Insufficient Funds");
            alert.setContentText("Check Balance");
            alert.show();
        }
    }
        public int gRand(){
        Random rand = new Random();
        int n = rand.nextInt(1000);
        return n;
    }
        public void PayLoans(ActionEvent a){
            int am=gRand();
        try
        {if (x.getBalance() <am) throw new ArithmeticException();
        else {
            Transactions.TransferBill(x,am,"pay Loan");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("pay");
            alert.setContentText("please pay "+ am+"EGP");
            alert.show();
        }
        }
        catch (ArithmeticException | SQLException al) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("insufficient fund");
            alert.setContentText("to Pay "+am+" EGP");
            alert.show();
        }
    }
        public void PayGas(ActionEvent a){
            int am=gRand();
            try
            {if (x.getBalance() <am) throw new ArithmeticException();
            else {
                Transactions.TransferBill(x,am,"pay Gas");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("pay");
                alert.setContentText("please pay "+ am+"EGP");
                alert.show();
            }
            }
            catch (ArithmeticException | SQLException al) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("insufficient fund");
                alert.setContentText("to Pay "+am+" EGP");
                alert.show();
            }
    }
        public void PayTrans(ActionEvent a){
            int am=gRand();
            try
            {if (x.getBalance() <am) throw new ArithmeticException();
            else {
                Transactions.TransferBill(x,am,"pay Transportations");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("pay");
                alert.setContentText("please pay "+ am+"EGP");
                alert.show();
            }
            }
            catch (ArithmeticException | SQLException al) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("insufficient fund");
                alert.setContentText("to Pay "+am+" EGP");
                alert.show();
            }
    }
        public void PayWater(ActionEvent a){
            int am=gRand();
            try
            {if (x.getBalance() <am) throw new ArithmeticException();
            else {
                Transactions.TransferBill(x,am,"pay Water");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("pay");
                alert.setContentText("please pay "+ am+"EGP");
                alert.show();
            }
            }
            catch (ArithmeticException | SQLException al) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("insufficient fund");
                alert.setContentText("to Pay "+am+" EGP");
                alert.show();
            }
}
        public void PayElectric(ActionEvent a){
        int am=gRand();
        try
        {if (x.getBalance() <am) throw new ArithmeticException();
        else {
            Transactions.TransferBill(x,am,"pay Electricity");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("pay");
            alert.setContentText("please pay "+ am+"EGP");
            alert.show();
        }
        }
        catch (ArithmeticException | SQLException al) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("insufficient fund");
            alert.setContentText("to Pay "+am+" EGP");
            alert.show();
        }
    }
}