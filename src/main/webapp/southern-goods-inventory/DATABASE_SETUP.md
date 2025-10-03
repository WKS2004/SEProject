# MySQL Database Integration Guide

This document provides instructions for integrating MySQL database with the Southern Goods Inventory Management System.

## Prerequisites

- MySQL Server 8.0 or higher
- Node.js MySQL driver (`mysql2`)

## Installation

Add the MySQL driver to your project:

\`\`\`bash
npm install mysql2
\`\`\`

## Environment Variables

Add these variables to your `.env.local` file:

\`\`\`env
# MySQL Database Configuration
DB_HOST=localhost
DB_PORT=3306
DB_USER=your_username
DB_PASSWORD=your_password
DB_NAME=southern_goods_inventory
\`\`\`

## Database Schema

### 1. Users Table

\`\`\`sql
CREATE TABLE users (
  id VARCHAR(36) PRIMARY KEY,
  email VARCHAR(255) UNIQUE NOT NULL,
  name VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  role ENUM('admin', 'user', 'warehouse', 'inventory') DEFAULT 'user',
  status ENUM('active', 'inactive') DEFAULT 'active',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  INDEX idx_email (email),
  INDEX idx_role (role)
);
\`\`\`

### 2. Products Table

\`\`\`sql
CREATE TABLE products (
  id VARCHAR(36) PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  sku VARCHAR(100) UNIQUE NOT NULL,
  category VARCHAR(100) NOT NULL,
  quantity INT DEFAULT 0,
  threshold INT DEFAULT 0,
  price DECIMAL(10, 2) NOT NULL,
  supplier VARCHAR(255),
  last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  INDEX idx_sku (sku),
  INDEX idx_category (category),
  INDEX idx_quantity (quantity)
);
\`\`\`

### 3. Orders Table

\`\`\`sql
CREATE TABLE orders (
  id VARCHAR(36) PRIMARY KEY,
  user_id VARCHAR(36) NOT NULL,
  customer_name VARCHAR(255) NOT NULL,
  order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  status ENUM('pending', 'processing', 'completed', 'cancelled') DEFAULT 'pending',
  total_amount DECIMAL(10, 2) NOT NULL,
  payment_method VARCHAR(100),
  shipping_address TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id),
  INDEX idx_user_id (user_id),
  INDEX idx_status (status),
  INDEX idx_order_date (order_date)
);
\`\`\`

### 4. Order Items Table

\`\`\`sql
CREATE TABLE order_items (
  id VARCHAR(36) PRIMARY KEY,
  order_id VARCHAR(36) NOT NULL,
  product_id VARCHAR(36) NOT NULL,
  product_name VARCHAR(255) NOT NULL,
  quantity INT NOT NULL,
  price DECIMAL(10, 2) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
  FOREIGN KEY (product_id) REFERENCES products(id),
  INDEX idx_order_id (order_id),
  INDEX idx_product_id (product_id)
);
\`\`\`

### 5. Supplier Shipments Table

\`\`\`sql
CREATE TABLE supplier_shipments (
  id VARCHAR(36) PRIMARY KEY,
  supplier_id VARCHAR(36) NOT NULL,
  supplier_name VARCHAR(255) NOT NULL,
  purchase_order_id VARCHAR(100) NOT NULL,
  received_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  status ENUM('pending', 'received', 'verified') DEFAULT 'pending',
  notes TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  INDEX idx_supplier_id (supplier_id),
  INDEX idx_status (status),
  INDEX idx_received_date (received_date)
);
\`\`\`

### 6. Shipment Items Table

\`\`\`sql
CREATE TABLE shipment_items (
  id VARCHAR(36) PRIMARY KEY,
  shipment_id VARCHAR(36) NOT NULL,
  product_id VARCHAR(36) NOT NULL,
  product_name VARCHAR(255) NOT NULL,
  expected_quantity INT NOT NULL,
  received_quantity INT NOT NULL,
  damaged INT DEFAULT 0,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (shipment_id) REFERENCES supplier_shipments(id) ON DELETE CASCADE,
  FOREIGN KEY (product_id) REFERENCES products(id),
  INDEX idx_shipment_id (shipment_id),
  INDEX idx_product_id (product_id)
);
\`\`\`

### 7. Stock Adjustments Table

\`\`\`sql
CREATE TABLE stock_adjustments (
  id VARCHAR(36) PRIMARY KEY,
  product_id VARCHAR(36) NOT NULL,
  adjustment_type ENUM('add', 'remove', 'recount', 'damage', 'return') NOT NULL,
  quantity INT NOT NULL,
  reason TEXT,
  performed_by VARCHAR(36) NOT NULL,
  timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (product_id) REFERENCES products(id),
  FOREIGN KEY (performed_by) REFERENCES users(id),
  INDEX idx_product_id (product_id),
  INDEX idx_timestamp (timestamp)
);
\`\`\`

### 8. Audit Logs Table

\`\`\`sql
CREATE TABLE audit_logs (
  id VARCHAR(36) PRIMARY KEY,
  user_id VARCHAR(36),
  action VARCHAR(255) NOT NULL,
  entity_type VARCHAR(100) NOT NULL,
  entity_id VARCHAR(36),
  details JSON,
  ip_address VARCHAR(45),
  timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id),
  INDEX idx_user_id (user_id),
  INDEX idx_entity_type (entity_type),
  INDEX idx_timestamp (timestamp)
);
\`\`\`

## Database Connection Setup

Create a database connection file at \`lib/db.ts\`:

\`\`\`typescript
import mysql from 'mysql2/promise'

const pool = mysql.createPool({
  host: process.env.DB_HOST,
  port: parseInt(process.env.DB_PORT || '3306'),
  user: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  database: process.env.DB_NAME,
  waitForConnections: true,
  connectionLimit: 10,
  queueLimit: 0
})

export async function query(sql: string, params?: any[]) {
  const [results] = await pool.execute(sql, params)
  return results
}

export default pool
\`\`\`

## Migration Instructions

1. Create the database:
\`\`\`sql
CREATE DATABASE southern_goods_inventory CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
\`\`\`

2. Run the schema creation scripts in order (users → products → orders → order_items → supplier_shipments → shipment_items → stock_adjustments → audit_logs)

3. Insert initial admin user:
\`\`\`sql
INSERT INTO users (id, email, name, password, role, status)
VALUES (
  UUID(),
  'admin@southerngoods.com',
  'Admin User',
  -- Use bcrypt to hash the password before inserting
  '$2a$10$...',
  'admin',
  'active'
);
\`\`\`

## Replacing Mock Data

After setting up the database, replace the mock data imports in your application:

1. Update \`lib/auth.ts\` to query the users table
2. Update \`lib/mock-data.ts\` functions to query respective tables
3. Update server actions to use database queries instead of mock data

## Example Query Functions

\`\`\`typescript
// Get all products
export async function getProducts() {
  return await query('SELECT * FROM products ORDER BY name')
}

// Get user orders
export async function getUserOrders(userId: string) {
  return await query(
    'SELECT * FROM orders WHERE user_id = ? ORDER BY order_date DESC',
    [userId]
  )
}

// Update stock
export async function updateStock(productId: string, quantity: number) {
  return await query(
    'UPDATE products SET quantity = ? WHERE id = ?',
    [quantity, productId]
  )
}
\`\`\`

## Security Best Practices

1. Always use parameterized queries to prevent SQL injection
2. Hash passwords using bcrypt before storing
3. Implement proper session management
4. Use environment variables for sensitive data
5. Enable SSL/TLS for database connections in production
6. Implement rate limiting on API endpoints
7. Regular database backups

## IntelliJ Integration

1. Open the project in IntelliJ IDEA
2. Configure MySQL data source in Database tool window
3. Use the SQL console to run migration scripts
4. Enable database inspection for query validation
