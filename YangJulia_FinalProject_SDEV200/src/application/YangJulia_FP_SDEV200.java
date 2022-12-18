package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Random;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

//CheckIn Class. Inherits all methods and data fields from both Guest and Room classes.
class CheckIn extends Room {
  
  //initialize variables
  int guestID;
  int roomID;
  boolean isVacant = true;
  double totalPrice;
  
  //constructor
  public CheckIn () {
  }
  
  //accessor methods
  public boolean getVacancy() {
      return isVacant;
  }
  
  public int getGuestID() {
      return guestID;
  }
  
  public int getRoomID() {
      return roomID;
  }
  
  public double getTotalPrice() {
      totalPrice = guest_price + room_price;
      System.out.println("Total Pricing ($" + this.guest_price + " + $" + room_price + "): $" + this.totalPrice);
      return totalPrice;
  }
  
  public void getCheckInInfo() {
      System.out.println("Guest ID: " + this.getGuestID());
      System.out.println("Room ID: " + this.getRoomID());
      System.out.println("Vacancy: " + this.getVacancy());
  }
  
  //mutator methods
  public void setGuestID(int guestID) {
      this.guestID = guestID;
  }
  
  public void setRoomID(int roomID) {
      this.roomID = roomID;
  }
  
  public void setVacancy(boolean vacancy) {
      this.isVacant = vacancy;
  }
}

//Room class. Inherits all methods and data fields from Guest class
class Room extends Guest {
  
  //initialize variables
  double room_price;
  int width;
  int length;
  int height;
  int room_area;
  int num_beds;
  int bed_price;
  String bed_type;
  
  //constructors
  public Room () {
  }
  
  public Room (int length, int width, int height, int num_beds, 
          String bed_type) {
      this.length = length;
      this.width = width;
      this.height = height;
      this.room_area = this.width * this.length * this.height;
      
      this.num_beds = num_beds;
      this.bed_type = bed_type;
      
      if (this.bed_type.equals("small")) {
          bed_price = 25;
      }
      else if (this.bed_type.equals("medium")) {
          bed_price = 50;
      }
      else if (this.bed_type.equals("king")){
          bed_price = 75;
      }
      else {
          bed_price = 0;
      }
  }
  
  //accessor methods
  public int getWidth() {
      return width;
  }
  
  public int getLength() {
      return length;
  }

  public int getHeight() {
      return height;
  }
  
  public int getArea() {
      room_area = width * length * height;
      return room_area;
  }
  
  public String getBedType() {
      return bed_type;
  }
  
  public void getRoomInfo() {
      System.out.println("Room Width: " + this.getWidth() + " feet");
      System.out.println("Room Length: " + this.getLength() + " feet");
      System.out.println("Room Height " + this.getHeight() + " feet");
      System.out.println("Room Area: " + this.getArea() + " square feet");
      System.out.println("Bed Type: " + this.getBedType());
  }

  public void getRoomPrice() {
      this.room_area = this.width * this.length * this.height;
      this.room_price = this.room_area + (this.bed_price * this.num_beds);
      System.out.println("Room Area Price (" + this.width + " * " + 
              this.length + " * " + this.height + "): $" + this.room_area);
      System.out.println("Bed Pricing (Bed size: " + this.bed_type + " -> $" 
              + this.bed_price + " * " + this.num_beds + " bed(s)): $" 
              + (this.bed_price * this.num_beds));
      System.out.println("Total Room Price: $" + this.room_price);
  }
  
  //mutator methods
  public void setLength(int length) {
      this.length = length;
  }
  
  public void setWidth(int width) {
      this.width = width;
  }

  public void setHeight(int height) {
      this.height = height;
  }
  
  public void setNumOfBeds(int num_beds) {
      this.num_beds = num_beds;
  }
  
  public void setBedType(String bed_type) {
      this.bed_type = bed_type;
      
      if (this.bed_type.equals("small")) {
          bed_price = 25;
      }
      else if (this.bed_type.equals("medium")) {
          bed_price = 50;
      }
      else if (this.bed_type.equals("king")){
          bed_price = 75;
      }
  }   
}

//Guest class
class Guest {
  String name;
  int num_people;
  int days_staying;
  double guest_price;
  
  //constructors
  public Guest () {
  }
  
  public Guest(String name, int num_people, int days_staying) {
      this.name = name;
      this.num_people = num_people;
      this.days_staying = days_staying;
      
      guest_price = (10 * (num_people)) + (25 * days_staying);
  }
  
  //accessor methods
  public String getName() {
      return name;
  }
  
  public int getNumPeople() {
      return num_people;
  }
  
  public int getDaysStaying() {
      return days_staying;
  }
  
  public void getGuestInfo() {
      System.out.println("Guest name: " + this.getName());
      System.out.println("Number of guests: " + this.getNumPeople());
      System.out.println("Days staying: " + this.getDaysStaying());
  }

  public void getGuestPrice() {
      guest_price = (10 * (num_people)) + (25 * days_staying);
      System.out.println("Guest Price ($10 * " + num_people + 
      " guest(s)) + ($25 * " + days_staying + 
      " day(s) staying): $" + this.guest_price);
  }
  
  //mutator methods
  public void setName(String name) {
      this.name = name;
  }
  
  public void setNumPeople(int num_people) {
      this.num_people = num_people;
  }
  
  public void setDaysStaying(int days_staying) {
      this.days_staying = days_staying;
  }  
}

//Main class
public class YangJulia_FP_SDEV200 extends Application {
  
  //initialize customer class, text fields, labels, and buttons
  CheckIn customer = new CheckIn();
  
  TextField tfguestName = new TextField();
  TextField tfnumGuests = new TextField();
  TextField tfdaysStaying = new TextField();
  
  TextField tfroomLength = new TextField();
  TextField tfroomWidth = new TextField();
  TextField tfroomHeight = new TextField();
  TextField tfbedAmount = new TextField();
  TextField tfbedType = new TextField();
  
  Label topText = new Label();
  Label vacancyText = new Label();
  Label roomIDText = new Label();
  
  Button btnCheckIn = new Button ("Check In");
  Button btnGetInfo = new Button("Get Info");
  Button btnCheckPrice = new Button("Check Pricing");
  Button btnReset = new Button("Reset");
  
  //application initializer
  @Override
  public void start(Stage primaryStage) {      
      
      topText.setText("Welcome to the Hotel Check In!" +
              " Make sure to fill in all of the data fields correctly" +
              " before you check in, check info, or check your price!");
      vacancyText.setText("Vacant: True");
      roomIDText.setText("Room ID: " + customer.getRoomID());
      
      //create grid pane
      GridPane pane = new GridPane();
      
      //format grid pane layout
      pane.setPadding(new Insets(10, 10, 10, 10));
      pane.setAlignment(Pos.CENTER);
      pane.setHgap(20);
      pane.setVgap(5);
      
      //place interface objects on the gridpane
      pane.add(new Label("Guest Info:"), 0, 0);
      pane.add(new Label("Guest Name:"), 0, 1);
      pane.add(new Label("Number of Guests:"), 0, 2);
      pane.add(new Label("Days Staying:"), 0, 3);
      pane.add(vacancyText, 0, 4);
      
      pane.add(new Label("Room Specifications"), 2, 0);
      pane.add(new Label("Room Length:"), 2, 1);
      pane.add(new Label("Room Width:"), 2, 2);
      pane.add(new Label("Room Height:"), 2, 3);
      pane.add(roomIDText, 2, 4);
      
      pane.add(new Label("Bed Specifications"), 4, 0);
      pane.add(new Label("Bed Amount:"), 4, 1);
      pane.add(new Label("Bed Type:"), 4, 2);
      pane.add(new Label("Types: small, medium, king"), 4, 3);
      
      pane.add(tfguestName, 1, 1);
      pane.add(tfnumGuests, 1, 2);
      pane.add(tfdaysStaying, 1, 3);
      
      pane.add(tfroomLength, 3, 1);
      pane.add(tfroomWidth, 3, 2);
      pane.add(tfroomHeight, 3, 3);
      pane.add(tfbedAmount, 5, 1);
      pane.add(tfbedType, 5, 2);
      
      //create flow pane for buttons
      FlowPane buttonPane = new FlowPane();
      buttonPane.setPadding(new Insets(10, 10, 10, 10));
      buttonPane.setHgap(5);
      buttonPane.setAlignment(Pos.CENTER);
      buttonPane.getChildren().addAll(btnCheckIn, btnGetInfo, btnCheckPrice,
      btnReset);
      
      //button event handlers
      btnCheckIn.setOnAction(e -> checkIn());
      btnGetInfo.setOnAction(e -> getInfo());
      btnCheckPrice.setOnAction(e -> calcPrice());
      btnReset.setOnAction(e -> reset());
      
      BorderPane border = new BorderPane();
      border.setTop(topText);
      border.setCenter(pane);
      border.setBottom(buttonPane);
      BorderPane.setAlignment(topText, Pos.CENTER);
      
      //Set the scene and run the application.
      Scene scene = new Scene(border);
      primaryStage.setTitle("Hotel Check-In");
      primaryStage.setScene(scene);
      primaryStage.show();     
  }
  
  //main method that launcheds the application
  public static void main(String[] args) {
      launch(args);
  }
  
  //event that runs when the user taps the check in button
  //randomly assigns a guest ID and a room ID and sets vacancy to false.
  private void checkIn () {
      Random rand = new Random();
      try {
      int guestID = rand.nextInt(100);
      int roomID = rand.nextInt(100);
      
      customer.setGuestID(guestID);
      customer.setRoomID(roomID);
      
      if (customer.getVacancy() == true && getInfo() == true) {
      System.out.println("You have successfully been checked-in!");
      
      customer.setVacancy(false);
      vacancyText.setText("Vacant: False");
      roomIDText.setText("Room ID: " + customer.getRoomID());
      }
      else if (customer.getVacancy() == false) {
      System.out.println("You have already checked in.");
      }
      
      }
      catch (Exception ex) {
          System.out.println("Unable to check-in. Please try again.");
      }
  }
  
  //event that runs when the user taps the get info button
  //outputs all information about the guest, their room specifications, guest id, room id, and vacancy
  private boolean getInfo () {
      try {
      
      String guestName = tfguestName.getText();
      int guestAmount = Integer.parseInt(tfnumGuests.getText());
      int daysStaying = Integer.parseInt(tfdaysStaying.getText());
      
      int roomL = Integer.parseInt(tfroomLength.getText());
      int roomW = Integer.parseInt(tfroomWidth.getText());
      int roomH = Integer.parseInt(tfroomHeight.getText());
      int bedAmount = Integer.parseInt(tfbedAmount.getText());
      String bedType = tfbedType.getText().toLowerCase();
      
      customer.setName(guestName);
      customer.setNumPeople(guestAmount);
      customer.setDaysStaying(daysStaying);

      customer.setLength(roomL);
      customer.setWidth(roomW);
      customer.setHeight(roomH);
      customer.setNumOfBeds(bedAmount);
      customer.setBedType(bedType);
      
      customer.getGuestInfo();
      System.out.println("");
      customer.getRoomInfo();
      System.out.println("");
      customer.getCheckInInfo();
      System.out.println("");
      
      return true;
      }
      catch (NumberFormatException ex) {
          System.out.println("Unsuccessful attempt."
          + " Try to make sure that all fields are filled in and that" +
          " the inputted data type is correct.");
          return false;
      }
  }
  
  //calculates total price, including guest and room prices
  private void calcPrice () {
      
      try {
      int guestAmount = Integer.parseInt(tfnumGuests.getText());
      int daysStaying = Integer.parseInt(tfdaysStaying.getText());
      
      int roomL = Integer.parseInt(tfroomLength.getText());
      int roomW = Integer.parseInt(tfroomWidth.getText());
      int roomH = Integer.parseInt(tfroomHeight.getText());
      int bedAmount = Integer.parseInt(tfbedAmount.getText());
      String bedType = tfbedType.getText().toLowerCase();
      
      customer.setNumPeople(guestAmount);
      customer.setDaysStaying(daysStaying);
      
      customer.setLength(roomL);
      customer.setWidth(roomW);
      customer.setHeight(roomH);
      customer.setNumOfBeds(bedAmount);
      customer.setBedType(bedType);
      
      customer.getGuestPrice();
      System.out.println("");
      customer.getRoomPrice();
      System.out.println("");
      customer.getTotalPrice();
      System.out.println("");
      }
      catch (NumberFormatException ex) {
          System.out.println("Unsuccessful attempt."
          + " Try to make sure that all fields are filled in and that" +
          " the inputted data type is correct.");
      }
  }
  
  //resets the current customer data and clears all text fields
  private void reset () {
  customer.setVacancy(true);
  vacancyText.setText("Vacant: True");
  
  customer = new CheckIn();
  tfguestName.setText(null);
  tfnumGuests.setText(null);
  tfdaysStaying.setText(null);

  tfroomLength.setText(null);
  tfroomWidth.setText(null);
  tfroomHeight.setText(null);
  tfbedAmount.setText(null);
  tfbedType.setText(null);
  
  roomIDText.setText("Room ID: " + customer.getRoomID());
  System.out.println("Current data and all fields have been reset!");
  }
  
}


