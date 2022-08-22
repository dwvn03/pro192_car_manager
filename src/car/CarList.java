package car;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

import brand.*;
import my_lib.file_io.FileUtils;
import my_lib.validator.StringValidator;

public class CarList extends ArrayList<Car> {
    static Scanner sc = new Scanner(System.in);
    BrandList brandList;

    public CarList(BrandList brandList) {
        this.brandList = brandList;
    }

    public void listCars() {
        if (this.size() == 0) {
            System.out.println("The list is empty");
        } else {
            Collections.sort(this);

            for (Car car : this) {
                System.out.println(car.screenString());
            }
        }
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
        String carID, colour, frameID, engineID;
        Brand brand;
        
        while (true) {
            System.out.println("Enter car ID");
            carID = sc.nextLine().trim();
            if (searchID(carID) == -1) {
                break;
            }
            System.out.println("Car ID already exist, please enter again !!!\n");
        }

        System.out.println("\nChoose a brand :");
        brand = brandList.getUserChoice();
        System.out.println("Chosen brand : " + brand);

        System.out.println();
        while (true) {
            System.out.println("Enter colour");
            colour = sc.nextLine().trim();
            if (!colour.isEmpty()) {
                break;
            } else {
                System.out.println("Colour brand can't be blank, please enter again!!!\n");
            }
        }

        System.out.println();
        while (true) {
            System.out.println("Enter frame ID");
            frameID = sc.nextLine().trim();

            if (!StringValidator.patternMatcher(frameID, "^F[0-9]{5}$")) {
                System.out.println("Wrong frame ID format, please enter again !!!\n");
            } else if (searchFrame(frameID) != -1) {
                System.out.println("Frame ID already exist, please enter again !!!\n");
            } else {
                break;
            }
        }

        System.out.println();
        while (true) {
            System.out.println("Enter engine ID");
            engineID = sc.nextLine().trim();

            if (!StringValidator.patternMatcher(engineID, "^E[0-9]{5}$")) {
                System.out.println("Wrong engine ID format, please enter again !!!\n");
            } else if (searchEngine(engineID) != -1) {
                System.out.println("Engine ID already exist, please enter again !!!\n");
            } else {
                break;
            }
        }

        Car t = new Car(carID, brand, colour, frameID, engineID);
        this.add(t);
    }
    
    public boolean removeCar() {
        System.out.println("Enter car ID");
        String removedID = sc.nextLine().trim(); 

        int pos = searchID(removedID);

        if (pos == -1) {
            System.out.println("Not found!!!");
            return false;
        }
        
        this.remove(pos);
        System.out.println("Remove successfully.");
        return true;
    }
    
    public boolean updateCar() {
        String carID, newColour, newFrameID, newEngineID;
        Brand newBrand;
        
        System.out.print("Enter car ID: ");
        carID = sc.nextLine();
        int pos = searchID(carID);
        if (pos == -1) {
            System.out.println("Not found!");
            return false;
        } else {
            Car CarUpdate = this.get(pos);

            System.out.println("\nChoose a brand :");
            newBrand = brandList.getUserChoice();
            System.out.println("Chosen brand : " + newBrand);

            System.out.println();
            while (true) {
                System.out.println("Enter colour");
                newColour = sc.nextLine().trim();
                if (!newColour.isEmpty()) {
                    break;
                } else {
                    System.out.println("Colour brand can't be blank, please enter again!!!\n");
                }
            }

            System.out.println();
            while (true) {
                System.out.println("Enter frame ID");
                newFrameID = sc.nextLine().trim();

                if (!StringValidator.patternMatcher(newFrameID, "^F[0-9]{5}$")) {
                    System.out.println("Wrong frame ID format, please enter again !!!\n");
                } else if (searchFrame(newFrameID) != -1) {
                    System.out.println("Frame ID already exist, please enter again !!!\n");
                } else {
                    break;
                }
            }

            System.out.println();
            while (true) {
                System.out.println("Enter engine ID");
                newEngineID = sc.nextLine().trim();

                if (!StringValidator.patternMatcher(newEngineID, "^E[0-9]{5}$")) {
                    System.out.println("Wrong engine ID format, please enter again !!!\n");
                } else if (searchEngine(newEngineID) != -1) {
                    System.out.println("Engine ID already exist, please enter again !!!\n");
                } else {
                    break;
                }
            }

            CarUpdate.setBrand(newBrand);
            CarUpdate.setColor(newColour);
            CarUpdate.setFrameID(newFrameID);
            CarUpdate.setEngineID(newEngineID);
            return true;
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
}
