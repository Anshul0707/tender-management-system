# **Tender Management System**

## **Overview**
The **Tender Management System (TMS)** is a web-based application designed to streamline the process of managing tenders, vendors, and bids. It allows administrators to create tenders, manage vendors, and select bids, while vendors can view tenders, place bids, and track their bid status.

---

## **Features**
### **Administrator Features**
1. **Create a new Vendor**: Add new vendors to the approved vendor list.
2. **View all Vendors**: View a list of all approved vendors.
3. **Create new Tenders**: Create and publish new tenders.
4. **View all Tenders**: View a list of all tenders.
5. **View all Bids of a Tender**: View all bids submitted for a specific tender.
6. **Select a Bid**: Choose the best bid for a tender.

### **Vendor Features**
1. **View all current Tenders**: View a list of all open tenders.
2. **Place a Bid against a Tender**: Submit a bid for a specific tender.
3. **View status of a Bid**: Check whether a bid has been selected or not.
4. **View Bid History**: View a history of all bids submitted by the vendor.

---

## **Technology Stack**
- **Backend**: Spring Boot, Java
- **Database**: PostgreSQL
- **API Testing**: Postman
- **API Documentation**: Swagger
- **Build Tool**: Maven
- **CI/CD**: GitHub Actions (Optional)

---

## **How to Run This Project**

### **Prerequisites**
1. **Java Development Kit (JDK)**: Version 17 or higher.
2. **PostgreSQL**: Install and set up a PostgreSQL database.
3. **Maven**: Install Maven for dependency management.
4. **Postman**: For testing the APIs.

### **Steps to Run the Project**
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-repo/tender-management-system.git
   cd tender-management-system
   ```

2. **Set Up the Database**:
   - Update the database configuration in `src/main/resources/application.properties`:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     ```
   - No need to create tables manually! The application will automatically create them on startup.

3. **Build the Project**:
   ```bash
   mvn clean install
   ```

4. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```

5. **Access the Application**:
   - The application will run on `http://localhost:8080`.
   - Use **Postman** or **Swagger** to test the APIs.

---

## **API Documentation**
The API documentation is available using **Swagger**. After running the application, access the Swagger UI at:
```
http://localhost:8080/swagger-ui.html
```

---

## **Advantages**
1. **No Manual Table Creation**:
   - The application automatically creates the required tables (`vendor`, `tender`, `bid`) on startup.
   - Simply configure your database in `application.properties`, and the system will handle the rest.

2. **Easy Configuration**:
   - Update the `application.properties` file with your database credentials, and you're ready to go.

3. **Scalable and Modular**:
   - The project is built using Spring Boot, making it easy to extend and maintain.

4. **Role-Based Access Control**:
   - Admins and vendors have separate roles and permissions.

5. **Automated Testing and Deployment**:
   - CI/CD pipelines can be set up using GitHub Actions, Jenkins, or GitLab CI/CD.

---

## **API Endpoints**

### **Administrator APIs**
| **Endpoint**                          | **Method** | **Description**                        |
|---------------------------------------|------------|----------------------------------------|
| `/api/admin/vendors`                  | POST       | Create a new vendor.                   |
| `/api/admin/vendors`                  | GET        | Get all vendors.                       |
| `/api/admin/vendors/{vendorId}`       | GET        | Get a vendor by ID.                    |
| `/api/admin/tenders`                  | POST       | Create a new tender.                   |
| `/api/admin/tenders`                  | GET        | Get all tenders.                       |
| `/api/admin/tenders/{tenderId}`       | GET        | Get a tender by ID.                    |
| `/api/admin/tenders/{tenderId}/bids`  | GET        | Get all bids for a tender.             |
| `/api/admin/bids/{bidId}/select`      | PUT        | Select a bid.                          |

### **Vendor APIs**
| **Endpoint**                          | **Method** | **Description**                        |
|---------------------------------------|------------|----------------------------------------|
| `/api/vendor/tenders`                 | GET        | Get all current tenders.               |
| `/api/vendor/bids`                    | POST       | Place a bid for a tender.              |
| `/api/vendor/bids/{bidId}`            | GET        | Get bid details by ID.                 |
| `/api/vendor/bids/vendor/{vendorId}`  | GET        | Get bid history for a vendor.          |

---

## **Future Enhancements**
1. **Authentication and Authorization**:
   - Add role-based access control using Spring Security.
2. **Email Notifications**:
   - Notify vendors when their bid is selected.
3. **Frontend Development**:
   - Build a user-friendly interface using React or Angular.
4. **Dashboard**:
   - Add a dashboard for admins to view analytics.
5. **Pagination and Sorting**:
   - Improve performance for large datasets.

---

## **Contributing**
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature/bugfix.
3. Commit your changes.
4. Submit a pull request.

---

## **License**
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## **Contact**
For any queries or support, please contact:  
- **Name**: Anshul Markwade  
- **Email**: anshul.markwade786@gmail.com
- **GitHub**: https://github.com/Anshul0707/tender-management-system
