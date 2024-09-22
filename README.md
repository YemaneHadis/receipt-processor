# Receipt Processor 

## Description 
Java Spring boot application to process point in receipt

## Prerequisites
- Docker installed in Your machine 

## Get started 
### Clone Repository
```bash
  git clone git@github.com:YemaneHadis/receipt-processor.git
  cd receipt-processor
```

### Build the Project
```bash
   mvn clean install

```
### Build the Docker image
```bash
   docker build -t receipt-processor .
```

### Run the application 
```bash
 docker run -p 8080:8080 receipt-processor
```


### API Endpoints
1. #### Create Receipt
   ### 1. Create Receipt

* **URL:** `http://localhost:8080/receipts`
* **Method:** `POST`
* **Request Body:**
```json
{
  "retailer": "Target",
  "purchaseDate": "2022-01-01",
  "purchaseTime": "13:01",
  "items": [
    {
      "shortDescription": "Mountain Dew 12PK",
      "price": "6.49"
    },
    {
      "shortDescription": "Emils Cheese Pizza",
      "price": "12.25"
    },
    {
      "shortDescription": "Knorr Creamy Chicken",
      "price": "1.26"
    },
    {
      "shortDescription": "Doritos Nacho Cheese",
      "price": "3.35"
    },
    {
      "shortDescription": "Klarbrunn 12-PK 12 FL OZ",
      "price": "12"
    }
  ]
}
```
* **Response:**
 ``` json
        "id": "{{uuid}}"
```
2. #### Get Points for Receipt
* **URL:** `http://localhost:8080/receipts/{id}/points`
* **Method:** `GET`
* **Path Parameters:**
* * **id:** The ID of the receipt
* **Response:**
 ``` json
        "points": "{{points}}"
```

