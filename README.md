# 🚗 新加坡停车场一张图 - GitHub Projects 使用说明
 
项目目标是基于 LTA CarparkAvailability API 构建一个 **实时、交互式的停车位可视化地图**。

---

## 📌 项目概述
本项目主要包括：
- **数据采集**：实时获取新加坡停车场可用车位数据（LTA API）。
- **数据处理**：数据清洗、格式化，并存储到 **PostGIS 空间数据库**。
- **后端 API**：提供 GeoJSON 数据接口供前端调用。
- **前端可视化**：在地图上动态展示停车位信息。
  
## 📚 项目简介
本项目通过调用 LTA 提供的 **CarParkAvailability** 接口，实时获取新加坡各停车场的空位信息，并在地图上进行可视化展示。用户可以直观查看停车位分布、数量和类型，从而更方便地选择合适的停车位置。  

适用于：
- 个人快速查找停车位
- 城市管理者进行停车资源监控
- 停车数据分析与研究

## ✨ 功能特性
- **实时数据获取**：定时从 LTA API 拉取最新停车场信息
- **空间数据库管理**：基于 PostGIS 存储与查询地理数据
- **可交互地图**：支持缩放、点击、查看停车场详情
- **数据清洗与标准化**：保证数据准确性与可用性
- **可扩展性**：支持历史数据积累，便于后续分析与预测

## 🛠 技术栈
- **后端**：Python (Requests, Psycopg2)
- **数据库**：PostgreSQL + PostGIS
- **可视化**：Leaflet.js / OpenStreetMap
- **数据来源**：LTA DataMall - CarParkAvailability API

## 📂 项目结构
project/
├── backend/ # 数据获取与入库脚本
├── db/ # 数据库建表与配置文件
├── frontend/ # 地图可视化前端
├── README.md # 项目说明文档
└── requirements.txt # Python 依赖

## 🚀 快速开始
1. **克隆仓库**
```bash
git clone https://github.com/yourusername/sg-carpark-map.git
cd sg-carpark-map
```
2. **安装依赖**
```bash
pip install -r requirements.txt
```
3. **配置数据库**
安装并配置 PostgreSQL 与 PostGIS

创建数据库：
```bash
CREATE DATABASE carparkdb;
CREATE EXTENSION postgis;
```
4、**运行数据获取脚本**
```bash
python backend/lta_carpark_import.py
```
5. **启动前端**
```bash
cd frontend
npm install
npm run dev
```
##📊 数据来源
LTA DataMall: CarParkAvailability API

##📸 项目截图
<img width="2542" height="1194" alt="54afe1b30c8c2385702c03faa115229e" src="https://github.com/user-attachments/assets/344b415a-7ac4-4064-b426-438de5b21cbc" />
<img width="2559" height="1187" alt="aa1539babb6b1e7c8939dddeb30bfa6a" src="https://github.com/user-attachments/assets/09268e39-c4e2-43c7-8254-539529fabf57" />
<img width="2559" height="1190" alt="fdcdbd14364c1d1a32814998d32eaab2" src="https://github.com/user-attachments/assets/833101f1-d1b0-458a-9bdd-cae434f310a7" />
<img width="2556" height="1200" alt="06b3f7246c271e15612b186623647656" src="https://github.com/user-attachments/assets/aad3abfe-85d8-4c84-ab5b-f57d3321f2c2" />
<img width="748" height="1010" alt="103e3116527919ebd5a097e8389f5521" src="https://github.com/user-attachments/assets/e7fbcd16-507d-4836-a01f-853ceae15670" />
<img width="749" height="672" alt="21f3636ffa767c68a2058b917e0a83d9" src="https://github.com/user-attachments/assets/22f5ebb7-c35f-450f-921f-7a455348ccfe" />

##📄 许可证
本项目遵循 MIT License。
