---

# Grocery Booking System

This is a Spring Boot application for managing grocery orders.

## Prerequisites

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

## Running the Application

### Using Docker Compose

1. Clone this repository:

    ```bash
    git clone https://github.com/yourusername/grocery-booking.git
    cd grocery-booking
    ```

2. Build the Docker image:

    ```bash
    docker build -t grocery:latest .
    ```

3. Run Docker Compose to start the PostgreSQL database and the Grocery Booking API:

    ```bash
    docker-compose up -d
    ```

   This will start the services defined in `docker-compose.yml`.

4. Access the API at http://localhost:8081/specied-endpoints

### Application Details

- **Exposed Port:** 8081
- **Database:** PostgreSQL (running on port 5432)

## API Endpoints

## Endpoints

### 1. Get All Grocery Items

#### Request

```http
GET /api/admin/items
```

#### Response

```json
[
    {
        "id": 1,
        "name": "Apple",
        "price": 2.5,
        "inventory": 100
    },
    {
        "id": 2,
        "name": "Banana",
        "price": 1.5,
        "inventory": 50
    },
    ...
]
```

### 2. Add Grocery Item

#### Request

```http
POST /api/admin/items
```

#### Payload

```json
{
    "name": "Orange",
    "price": 2.0,
    "inventory": 75
}
```

#### Response

```json
{
    "id": 3,
    "name": "Orange",
    "price": 2.0,
    "inventory": 75
}
```

### 3. Get Grocery Item by ID

#### Request

```http
GET /api/admin/items/{itemId}
```

#### Response

```json
{
    "id": 1,
    "name": "Apple",
    "price": 2.5,
    "inventory": 100
}
```

### 4. Update Grocery Item

#### Request

```http
PUT /api/admin/items/{itemId}
```

#### Payload

```json
{
    "name": "Apple",
    "price": 2.0,
    "inventory": 120
}
```

#### Response

```json
{
    "id": 1,
    "name": "Apple",
    "price": 2.0,
    "inventory": 120
}
```

### 5. Remove Grocery Item

#### Request

```http
DELETE /api/admin/items/{itemId}
```

#### Response

```http
204 No Content
```

### 6. Update Inventory

#### Request

```http
PATCH /api/admin/items/{itemId}/update-inventory/{newInventory}
```

#### Response

```http
204 No Content
```
### 7. Create Order

#### Request

```http
POST /api/orders/create
```

#### Payload

```json
{
    "userID": 1,
    "itemIds": [1, 2, 3],
    "quantities": [2, 3, 1]
}
```
### 8. Create User

#### Request

```http
POST /api/users/create
```

#### Payload

```json
{
  "email": "test@example.com",
  "password": "password123",
  "username": "testuser"
}
```

## Note

- For `POST` and `PUT` requests, ensure the payload includes the necessary fields (`name`, `price`, `inventory`).
- For `PATCH` requests, update the inventory by specifying the `newInventory` in the path.
- For `GET` and `DELETE` requests, replace `{itemId}` with the actual ID of the grocery item.

---