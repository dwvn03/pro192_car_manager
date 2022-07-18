import brand.BrandList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Menu {

    public void menu() {
        BrandList brandlist = new BrandList();
        while (true) {
            System.out.println("========= Minh Trang BMW =========");
            System.out.println(""
                    + "1- List all brands\n"
                    + "2- Add a new brand\n"
                    + "3- Search a brand based on its ID\n"
                    + "4- Update a brand\n"
                    + "5- Save brands to the file, named brands.txt\n"
                    + "6- List all cars in ascending order of brand names\n"
                    + "7- List cars based on a part of an input brand name\n"
                    + "8- Add a car\n"
                    + "9- Remove a car based on its ID\n"
                    + "10- Update a car based on its ID\n"
                    + "11- Save cars to file, named cars.txt\n\n");
            int choice = MyLibs.getInt("Enter your choice: ", "Invalid choice.", 1, 11, null);
            switch (choice) {
                case 1:
                    brandlist.loadFromFile("brands.txt");
                    brandlist.listBrand();
                    break;
                case 2:
                    brandlist.addBrand();
                    break;
                case 3:
                    brandlist.searchBrand();
                    break;
                case 4:
                    brandlist.updateBrand();
                    break;
                case 5:
                    brandlist.saveToFile("brands.txt");
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:

                    break;
            }
        }
    }
}
