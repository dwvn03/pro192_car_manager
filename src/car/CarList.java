package car;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

import brand.*;
import my_lib.file_io.FileUtils;

public class CarList extends ArrayList<Car> {
    static Scanner sc = new Scanner(System.in);
    BrandList brandList;

    public CarList(BrandList brandList) {
        this.brandList = brandList;
    }

    public boolean loadFromFile(String path) {
        String[] lines = FileUtils.readFileAsLinesArray(path);

        if (lines == null) {
            return false;
        }

        for (String line : lines) {
            StringTokenizer stk = new StringTokenizer(line, ", ");

            String carID = stk.nextElement().toString();
            String brandID = stk.nextElement().toString();
            int pos = brandList.searchID(brandID);
            Brand b = brandList.get(pos);
            String colour = stk.nextElement().toString();
            String frameID = stk.nextElement().toString();
            String engineID = stk.nextElement().toString();

            Car car = new Car(carID, b, colour, frameID, engineID);
            this.add(car);
        }

        return true;
    }

    public boolean saveToFile(String path) {
        return FileUtils.writeArrayToFile(path, this.toArray());
    }

    public void listCars() {
        Collections.sort(this);

        for (Car car : this) {
            System.out.println(car.screenString());
        }
        System.out.println("\n\n");
    }
    
    public int searchID(String carID) {
        for (int i = 0; i < this.size(); i++) {
            if (carID.equals(this.get(i).carID)) {
                return i;
            }
        }
        return -1;
    }
    
    public int searchFrame(String fID) {
        for (int i = 0; i < this.size(); i++) {
            if (fID.equals(this.get(i).frameID)) {
                return i;
            }
        }
        return -1;
    }
    
    public int searchEngine(String eID) {
        for (int i = 0; i < this.size(); i++) {
            if (eID.equals(this.get(i).engineID)) {
                return i;
            }
        }
        return -1;
    }
    
    public void addCar() {
        String carID = null;
        Brand newBrand;
        String colour = null;
        String frameID = null;
        String engineID = null;
        while (true) {
            System.out.print("Enter car ID: ");
            carID = sc.nextLine();
            if (searchID(carID) == -1) {
                break;
            }
            System.out.println("Car ID already exist, please enter again !!!");
        }

        newBrand = brandList.getUserChoice();

        while (true) {
            System.out.print("Enter colour: ");
            colour = sc.nextLine();
            String c = colour.trim();
            if (!c.isEmpty()) {
                break;
            } else {
                System.out.println("Colour brand can't be blank, please enter again!!!");
            }
        }

        while (true) {
            System.out.print("Enter frame ID: ");
            frameID = sc.nextLine();
            char c1 = frameID.charAt(0);
            int count = 0;
            for (int i = 0; i < frameID.length(); i++) {
                char c2 = frameID.charAt(i);
                if ((c2 < 48) || (c2 > 57)) {
                    count++;
                }
            }
            if ((c1 == 'F') && (count == 0) && (frameID.length() == 5)) {
                if (searchFrame(frameID) == -1) {
                    break;
                } else {
                    System.out.println("Frame ID already exist, please enter again !!!");
                }
            }
        }

        while (true) {
            System.out.print("Enter engine ID: ");
            engineID = sc.nextLine();
            char c1 = engineID.charAt(0);
            int count = 0;
            for (int i = 0; i < engineID.length(); i++) {
                char c2 = engineID.charAt(i);
                if ((c2 < 48) || (c2 > 57)) {
                    count++;
                }
            }
            if ((c1 == 'E') && (count == 0) && (engineID.length() == 5)) {
                if (searchEngine(engineID) == -1) {
                    break;
                } else {
                    System.out.println("Engine ID already exist, please enter again !!!");
                }
            }
        }

        Car t = new Car(carID, newBrand, colour, frameID, engineID);
        this.add(t);
    }
    
    public boolean removeCar() {
        String removedID = null;
        System.out.print("Enter car ID: ");
        removedID = sc.nextLine();
        if (searchID(removedID) == -1) {
            System.out.println("Not found!!!");
            return false;
        }
        int pos = searchID(removedID);
        this.remove(pos);
        System.out.println("Remove successfully.");
        return true;
    }
    
    public void updateCar() {
        String carID = null;
        String newCarID = null;
        Brand newBrand;
        String newColour = null;
        String newFrameID = null;
        String newEngineID = null;
        System.out.print("Enter car ID: ");
        carID = sc.nextLine();
        if (searchID(carID) == -1) {
            System.out.println("Not found!");
        } else {
            Car CarUpdate = this.get(searchID(carID));
            while (true) {
                System.out.print("Enter new ID: ");
                newCarID = sc.nextLine();
                if (searchID(newCarID) == -1) {
                    break;
                }
                System.out.println("ID already exist, please enter again !!!");
            }

            newBrand = brandList.getUserChoice();

            while (true) {
                System.out.print("Enter new colour: ");
                newColour = sc.nextLine();
                String c = newColour.trim();
                if (!c.isEmpty()) {
                    break;
                } else {
                    System.out.println("Colour can't be blank, please enter again!!!");
                }
            }

            while (true) {
                System.out.print("Enter new frame ID: ");
                newFrameID = sc.nextLine();
                char c = newFrameID.charAt(0);
                int count = 0;
                for (int i = 0; i < newFrameID.length(); i++) {
                    char c2 = newFrameID.charAt(i);
                    if ((c2 < 48) || (c2 > 57)) {
                        count++;
                    }
                }
                if ((c == 'F') && (count == 0) && (newFrameID.length() == 5)) {
                    if (searchFrame(newFrameID) == -1) {
                        break;
                    } else {
                        System.out.println("Frame ID already exist, please enter again !!!");
                    }
                }
            }

            while (true) {
                System.out.print("Enter new engine ID: ");
                newEngineID = sc.nextLine();
                char c = newEngineID.charAt(0);
                int count = 0;
                for (int i = 0; i < newEngineID.length(); i++) {
                    char c2 = newEngineID.charAt(i);
                    if ((c2 < 48) || (c2 > 57)) {
                        count++;
                    }
                }
                if ((c == 'E') && (count == 0) && (newEngineID.length() == 5)) {
                    if (searchEngine(newEngineID) == -1) {
                        break;
                    } else {
                        System.out.println("Frame ID already exist, please enter again !!!");
                    }
                }
            }

            CarUpdate.setCarID(newCarID);
            CarUpdate.setBrand(newBrand);
            CarUpdate.setColor(newColour);
            CarUpdate.setFrameID(newFrameID);
            CarUpdate.setEngineID(newEngineID);
        }
    }
    
    public void printBasedBrandName() {
        System.out.print("Input: ");
        String aPartOfBrandName = sc.nextLine();
        int count = 0;
        for (int i = 0; i < this.size(); i++) {
            Car c = this.get(i);
            if (c.brand.getBrandName().contains(aPartOfBrandName)) {
                System.out.println(c.screenString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No car is detected!");
        }
    }
}
