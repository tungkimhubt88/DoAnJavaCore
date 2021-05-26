
    import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class ProductRepository {
        List<Product> productList;
        List<Product> listByCategory;
        static String MYFILE = "Product.txt";

        public ProductRepository() {
            productList = new ArrayList<>();
            File myFile = new File(MYFILE);

            try {
                Scanner myReader = new Scanner(myFile);
                while (myReader.hasNextLine()){
                    String s = myReader.nextLine();
                    String str[] = s.split(" - ");
                    String id = str[0];
                    String name = str[1];
                    String describe = str[2];
                    long importPrice = Long.parseLong(str[3]);
                    long salePrice = Long.parseLong(str[4]);
                    int amount = Integer.parseInt(str[5]);
                    int amountSale = Integer.parseInt(str[6]);
                    String brand = str[7];
                    Category catr = null;
                    if (str[8].equals("Điện thoại")){
                        catr = Category.PHONE;
                    }else if(str[8].equals("Laptop")){
                        catr = Category.LAPTOP;
                    }else if(str[8].equals("Apple")){
                        catr = Category.APPLE;
                    }else if(str[8].equals("Phụ kiện")){
                        catr = Category.ACCESSORIES;
                    }
                    productList.add(new Product(id, name,describe, importPrice,salePrice,amount,amountSale,brand,catr));

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            productList.forEach(System.out::println);

        }
        public List<Product> getProductByCategory(Category category){
            listByCategory = new ArrayList<>();
            for (int i = 0; i <productList.size(); i++){
                if(productList.get(i).getCategory().equals(category)){
                    listByCategory.add(productList.get(i));
                }
            }
            return listByCategory;
        }
        public void getListByCategory(){
            listByCategory.forEach(System.out::println);
        }

        public void getProductByBrand(String brand){
            int count = 0;
            for (int i = 0; i < productList.size(); i++){
                if (productList.get(i).getBrand().equalsIgnoreCase(brand)){
                    System.out.println(productList.get(i).toString());
                    count++;
                }
            }
            System.out.println((count == 0) ? "Không có sản phẩm này": "");

        }
        public void getProductByCategoryAndPrice(Category category){
            Scanner sc = new Scanner(System.in);
            Menu.choosePrice();
            System.out.print("Lựa chọn của bạn: ");
            int choose = sc.nextInt();
            sc.nextLine();
            int count = 0;
            switch (choose){
                case 1:
                    for (int i = 0; i < listByCategory.size(); i++){
                        if (listByCategory.get(i).getSalePrice() < 2000000){
                            System.out.println(listByCategory.get(i).toString());
                            count++;
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < listByCategory.size(); i++){
                        if (listByCategory.get(i).getSalePrice() >= 2000000 && listByCategory.get(i).getSalePrice() < 4000000){
                            System.out.println(listByCategory.get(i).toString());
                            count++;
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < listByCategory.size(); i++){
                        if (listByCategory.get(i).getSalePrice() >= 4000000 && listByCategory.get(i).getSalePrice() < 7000000){
                            System.out.println(listByCategory.get(i).toString());
                            count++;
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < listByCategory.size(); i++){
                        if (listByCategory.get(i).getSalePrice() >= 7000000 && listByCategory.get(i).getSalePrice() < 13000000){
                            System.out.println(listByCategory.get(i).toString());
                            count++;
                        }
                    }
                    break;
                case 5:
                    for (int i = 0; i < listByCategory.size(); i++){
                        if (listByCategory.get(i).getSalePrice() > 13000000){
                            System.out.println(listByCategory.get(i).toString());
                            count++;
                        }
                    }
                    break;
            }
            System.out.println((count == 0) ? "Không có sản phẩm này": "");

        }

        public void search(String name){
            int count = 0;
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getName().contains(name)) {
                    System.out.println(productList.get(i).toString());
                    count++;
                }
            }
            System.out.println((count == 0) ? "Không có sản phẩm này" : "");

        }

        public void addProduct(Category category){
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã sản phẩm: ");
            String id = sc.nextLine();
            System.out.print("Nhập tên sản phẩm: ");
            String name = sc.nextLine();
            System.out.print("Nhập mô tả: ");
            String describe = sc.nextLine();
            System.out.print("Nhập giá nhập: ");
            long importPrice = sc.nextLong();
            System.out.print("Nhập giá bán: ");
            long salePrice = sc.nextLong();
            System.out.print("Nhập số lượng: ");
            int amount = sc.nextInt();
            System.out.print("Nhập số lượng bán: ");
            int amountSale = sc.nextInt();
            sc.nextLine();
            System.out.print("Nhập nhãn hiệu: ");
            String brand = sc.nextLine();
            productList.add(new Product(id, name, describe, importPrice, salePrice, amount, amountSale, brand, category));
            System.out.println("Danh sách sau khi thêm: ");
            productList.forEach(System.out::println);
            writeFile();
        }

        public void editProduct(String nameProduct){
            int count = 0;
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getName().contains(nameProduct)) {
                    System.out.println(productList.get(i).toString());
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Nhập tên mới: ");
                    String name = sc.nextLine();
                    productList.get(i).setName(name);
                    System.out.print("Nhập mô tả mới: ");
                    String describe = sc.nextLine();
                    productList.get(i).setDescribe(describe);
                    System.out.print("Nhập giá nhập mới: ");
                    long importPrice = sc.nextLong();
                    productList.get(i).setImportPrice(importPrice);
                    System.out.print("Nhập giá bán mới: ");
                    long salePrice = sc.nextLong();
                    productList.get(i).setSalePrice(salePrice);
                    System.out.print("Nhập số lượng mới: ");
                    int amount = sc.nextInt();
                    productList.get(i).setAmount(amount);
                    System.out.print("Nhập số lượng bán mới: ");
                    int amountSale = sc.nextInt();
                    productList.get(i).setAmountSale(amountSale);
                    sc.nextLine();
                    System.out.print("Nhập nhãn hiệu mới: ");
                    String brand = sc.nextLine();
                    productList.get(i).setBrand(brand);
                    count++;
                    System.out.println("Sản phẩm sau khi sửa là: ");
                    System.out.println(productList.get(i).toString());
                }
            }

            if (count == 0) {
                System.out.println("Không tìm thấy sản phẩm");
            }
            writeFile();
        }

        public void deleteProduct(String name){
            for (int i = 0; i < productList.size(); i++){
                if (productList.get(i).getName().contains(name)){
                    System.out.println(productList.get(i).toString());
                    productList.remove(productList.get(i));
                }
            }
            System.out.println("Xóa thành công!!!");
            System.out.println("Danh sách sau khi xóa: ");
            productList.forEach(System.out::println);
            writeFile();
        }

        public void writeFile(){
            try {
                FileWriter fileWriter = new FileWriter(MYFILE);
                for (Product p: productList) {
                    fileWriter.write(p.toString()+"\n");
                }
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

