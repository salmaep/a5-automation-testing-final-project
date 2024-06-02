# API Testing and Web Automation Testing with Selenium with Java + Cucumber (BDD) Framework
Project ini bertujuan untuk melakukan pengujian API Testing pada DummyAPI.io dan Web Automation Testing pada Swag Labs. 
## API Testing User Controller
DummyAPI.io adalah sumber data API yang digunakan untuk pengujian. DummyAPI menyediakan data dummy yang dapat digunakan untuk mengembangkan, menguji, atau mendemonstrasikan fungsionalitas aplikasi tanpa harus terhubung ke sumber data yang sebenarnya. 
## Web Testing Aplikasi Swag Labs
Program pengujian otomatis pada website Swag Labs (https://www.saucedemo.com/) pada fitur login, dashboard, detail product, menu, cart, dan checkout. Pengujian ini menggunakan framework BDD (Behavior Driven Development) yang menggabungkan Selenium dengan Java dan Cucumber. Dengan framework ini, pengujian dilakukan berdasarkan skenario yang ditulis dalam bahasa alami yang mudah dipahami oleh semua pemangku kepentingan.

## Prerequisites
Sebelum memulai, pastikan Anda memiliki perangkat lunak berikut yang terpasang di komputer Anda:
- Java JDK (versi 8 atau lebih baru)
- Maven
- IDE (IntelliJ IDEA, Eclipse, atau lainnya)
- Google Chrome (versi terbaru)
- ChromeDriver yang kompatibel dengan versi Chrome yang terpasang

## Tools dan Libraries
- Selenium WebDriver: Untuk interaksi browser otomatis.
- Cucumber: Untuk mendefinisikan dan menjalankan skenario pengujian dalam format BDD.
- JUnit: Untuk menjalankan dan mengelola pengujian.
- WebDriverManager: Untuk mengelola driver browser secara otomatis.

## Project Structure
```
a5-automation-testing-final-project
├─ .git
├─ .gitignore
├─ .idea
├─ pom.xml
├─ README.md
├─ src
│  ├─ main
│  │  └─ java
│  │     └─ io
│  │        └─ cucumber
│  │           └─ Main.java
│  └─ test
│     ├─ java
│     │  └─ io
│     │     └─ cucumber
│     │        ├─ locators
│     │        │  ├─ api
│     │        │  │  └─ PageLocators.java
│     │        │  └─ web
│     │        │     └─ PageLocators.java
│     │        ├─ pages
│     │        │  ├─ CartPage.java
│     │        │  ├─ CheckoutPage.java
│     │        │  ├─ DashboardPage.java
│     │        │  ├─ DetailProductPage.java
│     │        │  ├─ LoginPage.java
│     │        │  ├─ MenuPage.java
│     │        │  └─ ProductDetailPage.java
│     │        ├─ StepDefinitions
│     │        │  ├─ api
│     │        │  │  └─ StepDefinitions.java
│     │        │  └─ web
│     │        │     └─ StepDefinitions.java
│     │        └─ TestRunner
│     │           └─ TestRunner.java
│     └─ resources
│        ├─ apiFeatures
│        │  ├─ CreateUser.feature
│        │  ├─ DeleteUser.feature
│        │  ├─ GetUser.feature
│        │  └─ UpdateUser.feature
│        ├─ cucumber.properties
│        └─ webFeatures
│           ├─ cart_test.feature
│           ├─ checkout_test.feature
│           ├─ dashboard_test.feature
│           ├─ detailProduct_test.feature
│           ├─ endToEnd_test.feature
│           ├─ login_test.feature
│           └─ menu_test.feature
└─ testreport
   └─ test-reports.html
```

## How to Run the Tests
1. Clone repository ini melalui git bash, dengan menjalankan perintah berikut
   ```
   git clone https://github.com/farizibnu/WebAutomationTesting.git
   ```
3. Buka project di IDE pilihan anda.
4. Jalankan perintah maven untuk memastikan semua dependensi terunduh
   ```
   mvn clean install
   ```
6. Jalankan perintah pengujian berikut
   ```
   mvn clean test
   ```

## Test Report
Test report adalah laporan yang dihasilkan setelah menjalankan serangkaian pengujian pada suatu perangkat lunak. Test report memberikan ringkasan tentang hasil pengujian yang dilakukan. Ini mencakup informasi tentang tes mana yang berhasil, tes mana yang gagal, serta hasilnya dalam berbagai format yang dapat membantu pengembang dalam menganalisis kinerja dan keandalan perangkat lunak mereka.

### How to check Test Report
Hasil report dari test automation yang telah dijalankan akan tersimpan pada file berikut
```
./testreport/test-report.html
```

## Test Cases
### API Testing
#### Get User Test Cases
1. Forbidden - App ID Missing
2. Forbidden - App ID Not Exist
3. Bad Request - Invalid ID
4. Get Users Success
5. Bad Request - Invalid ID Format

#### Create User Test Cases
1. Fill in all fields with all valid data
2. just required
3. Fill in all fields with data that already exists in the system
4. Fill in all fields except title filled with empty string
5. Fill in all fields correctly, but dateOfBirth is set to a date after today
   
#### Delete User Test Cases
1. Forbidden - App ID Missing
2. Forbidden - App ID Not Exist
3. Delete User Success
4. Resource Not Found
5. Path Not Found

#### Update User Test Cases
1. Update valid field title user
2. Update valid field first name user
3. Update valid field last name user
4. Update valid field picture user
5. Update valid field gender user

### Web Testing
#### Login Test Cases
1. Positive Login - Successful Login
2. Negative Login - Negative Login - User does not input username and password
3. Negative Login - Negative Login - User enters registered username with incorrect password

#### Dashboard Test Cases
1. Test click on product details that is 'Sauce Labs Backpack'
2. Test user adds 'Sauce Labs Backpack' to cart
3. Test user removes 'Sauce Labs Backpack' from cart

#### Detail Product Test Cases
1. Add 'Sauce Labs Backpack' to cart
2. Remove 'Sauce Labs Backpack' from cart
3. Interaction with Cart Icon

#### Menu Test Cases
1. Test menu All items in navigation bar menu
2. Test menu About in navigation bar menu
3. Test menu Logout in navigation bar menu

#### Cart Test Cases
1. Test User checks out with 'Sauce Labs Backpack' in cart
2. Test User continues shopping with 'Sauce Labs Backpack' in cart
3. Test User clicks on Cart with no products in cart

#### Checkout Test Cases
1. Test cancel checkout without fills all fields in checkout information page
2. Test continue checkout with fills all fields in checkout information page
3. Test continue checkout without fills all fields in checkout information page

#### End-to-End Test Cases
1. Test the end to end flow of the application


## Author
1. 211524010 | Fariz Muhamad Ibnu Hisyam | [@farizibnu](https://github.com/farizibnu)
2. 211524025 | Salma Edyna Putri | [@salmaep](https://github.com/salmaep)
3. 211524028 | Tabitha Salsabila Permana | [@Tabitha2912](https://github.com/Tabitha2912)
