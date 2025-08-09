# 🚗 Singapore Carpark Map - README

The goal of this project is to build a **real-time, interactive carpark availability visualization map** based on the LTA CarparkAvailability API.

---

## 📌 Overview
This project includes:
- **Data Acquisition**: Fetch real-time carpark availability data from the LTA API.
- **Data Processing**: Clean, format, and store data in a **PostGIS spatial database**.
- **Backend API**: Provide GeoJSON endpoints for frontend consumption.
- **Frontend Visualization**: Display carpark information dynamically on a map.

## 📚 Project Description
This project retrieves real-time available parking lot information for Singapore carparks via the LTA **CarParkAvailability** API and visualizes it on a map.  
Users can intuitively view the distribution, number, and types of available parking lots, making it easier to find suitable parking spaces.

Suitable for:
- Individuals looking for available parking quickly
- City managers monitoring parking resources
- Parking data analysis and research

## ✨ Features
- **Real-Time Data**: Periodically fetch the latest carpark availability from the LTA API
- **Spatial Database**: Store and query geographic data with PostGIS
- **Interactive Map**: Support zoom, click, and view carpark details
- **Data Cleaning & Standardization**: Ensure data accuracy and usability
- **Extensibility**: Support historical data storage for future analysis and prediction

## 🛠 Tech Stack
- **Backend**: Python (Requests, Psycopg2)
- **Database**: PostgreSQL + PostGIS
- **Visualization**: Leaflet.js / OpenStreetMap
- **Data Source**: LTA DataMall - CarParkAvailability API

## 📂 Project Structure
```plaintext
project/
├── backend/               # Data fetching and import scripts
├── db/                    # Database schema and configuration files
├── frontend/              # Map visualization frontend
├── README.md              # Project documentation
└── requirements.txt       # Python dependencies
```
## 🚀 Quick Start
1. **Clone the repository**
```bash
git clone https://github.com/yourusername/sg-carpark-map.git
cd sg-carpark-map
```
2. **Install dependencies**
```bash
pip install -r requirements.txt
```
3. **Configure the Database**
Install and configure PostgreSQL with PostGIS extension.

Create the database:
```bash
CREATE DATABASE carparkdb;
CREATE EXTENSION postgis;

```
4. **Run Data Fetch Script**
 ```bash
python backend/lta_carpark_import.py
```
5. **Start the Frontend**
```bash
cd frontend
npm install
npm run dev
```
## 📊 Data Source
LTA DataMall: CarParkAvailability API

## 📸 Screenshots
<img width="2542" height="1194" src="https://github.com/user-attachments/assets/344b415a-7ac4-4064-b426-438de5b21cbc" />
<img width="2559" height="1187" src="https://github.com/user-attachments/assets/09268e39-c4e2-43c7-8254-539529fabf57" />
<img width="2559" height="1190" src="https://github.com/user-attachments/assets/833101f1-d1b0-458a-9bdd-cae434f310a7" />
<img width="2556" height="1200" src="https://github.com/user-attachments/assets/aad3abfe-85d8-4c84-ab5b-f57d3321f2c2" /> 
<img width="748" height="1010" src="https://github.com/user-attachments/assets/e7fbcd16-507d-4836-a01f-853ceae15670" />
<img width="749" height="672" src="https://github.com/user-attachments/assets/22f5ebb7-c35f-450f-921f-7a455348ccfe" />

## 📄 License
This project is licensed under the MIT License.


