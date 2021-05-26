
    public class Product {
        private String id;
        private String name;
        private String describe;
        private long importPrice;
        private long salePrice;
        private int amount;
        private int amountSale;
        private String brand;
        private Category category;

        public Product(String id, String name, String describe, long importPrice, long salePrice, int amount, int amountSale, String brand, Category category) {
            this.id = id;
            this.name = name;
            this.describe = describe;
            this.importPrice = importPrice;
            this.salePrice = salePrice;
            this.amount = amount;
            this.amountSale = amountSale;
            this.brand = brand;
            this.category = category;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public long getImportPrice() {
            return importPrice;
        }

        public void setImportPrice(long importPrice) {
            this.importPrice = importPrice;
        }

        public long getSalePrice() {
            return salePrice;
        }

        public void setSalePrice(long salePrice) {
            this.salePrice = salePrice;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getAmountSale() {
            return amountSale;
        }

        public void setAmountSale(int amountSale) {
            this.amountSale = amountSale;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        @Override
        public String toString() {
            return id + " - " + name + " - " + describe + " - " + importPrice + " - " + salePrice + " - " + amount + " - " + amountSale + " - " + brand + " - " + category.getValue();
        }
    }

