/**
 * MySQL Database Connection Example
 *
 * This file demonstrates how to set up MySQL connection for production use.
 * Uncomment and configure after setting up your MySQL database.
 */

/*
import mysql from 'mysql2/promise'

// Create connection pool
const pool = mysql.createPool({
  host: process.env.DB_HOST || 'localhost',
  port: parseInt(process.env.DB_PORT || '3306'),
  user: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  database: process.env.DB_NAME,
  waitForConnections: true,
  connectionLimit: 10,
  queueLimit: 0,
  enableKeepAlive: true,
  keepAliveInitialDelay: 0
})

// Generic query function
export async function query<T = any>(sql: string, params?: any[]): Promise<T> {
  try {
    const [results] = await pool.execute(sql, params)
    return results as T
  } catch (error) {
    console.error('Database query error:', error)
    throw error
  }
}

// Transaction helper
export async function transaction<T>(
  callback: (connection: mysql.PoolConnection) => Promise<T>
): Promise<T> {
  const connection = await pool.getConnection()
  await connection.beginTransaction()

  try {
    const result = await callback(connection)
    await connection.commit()
    return result
  } catch (error) {
    await connection.rollback()
    throw error
  } finally {
    connection.release()
  }
}

// Example: Get all products
export async function getProducts() {
  return await query(
    'SELECT * FROM products ORDER BY name'
  )
}

// Example: Get product by ID
export async function getProductById(id: string) {
  const results = await query(
    'SELECT * FROM products WHERE id = ?',
    [id]
  )
  return results[0]
}

// Example: Create new product
export async function createProduct(product: {
  id: string
  name: string
  sku: string
  category: string
  quantity: number
  threshold: number
  price: number
  supplier: string
}) {
  return await query(
    `INSERT INTO products (id, name, sku, category, quantity, threshold, price, supplier)
     VALUES (?, ?, ?, ?, ?, ?, ?, ?)`,
    [
      product.id,
      product.name,
      product.sku,
      product.category,
      product.quantity,
      product.threshold,
      product.price,
      product.supplier
    ]
  )
}

// Example: Update product stock
export async function updateProductStock(
  productId: string,
  quantity: number,
  adjustmentType: string,
  reason: string,
  userId: string
) {
  return await transaction(async (connection) => {
    // Update product quantity
    await connection.execute(
      'UPDATE products SET quantity = ? WHERE id = ?',
      [quantity, productId]
    )

    // Log the adjustment
    await connection.execute(
      `INSERT INTO stock_adjustments (id, product_id, adjustment_type, quantity, reason, performed_by)
       VALUES (UUID(), ?, ?, ?, ?, ?)`,
      [productId, adjustmentType, quantity, reason, userId]
    )

    return true
  })
}

// Example: Get user orders with items
export async function getUserOrders(userId: string) {
  const orders = await query(
    'SELECT * FROM orders WHERE user_id = ? ORDER BY order_date DESC',
    [userId]
  )

  // Get items for each order
  for (const order of orders) {
    order.items = await query(
      'SELECT * FROM order_items WHERE order_id = ?',
      [order.id]
    )
  }

  return orders
}

// Example: Create order with items
export async function createOrder(order: {
  id: string
  userId: string
  customerName: string
  totalAmount: number
  paymentMethod: string
  shippingAddress: string
  items: Array<{
    id: string
    productId: string
    productName: string
    quantity: number
    price: number
  }>
}) {
  return await transaction(async (connection) => {
    // Insert order
    await connection.execute(
      `INSERT INTO orders (id, user_id, customer_name, total_amount, payment_method, shipping_address, status)
       VALUES (?, ?, ?, ?, ?, ?, 'pending')`,
      [
        order.id,
        order.userId,
        order.customerName,
        order.totalAmount,
        order.paymentMethod,
        order.shippingAddress
      ]
    )

    // Insert order items
    for (const item of order.items) {
      await connection.execute(
        `INSERT INTO order_items (id, order_id, product_id, product_name, quantity, price)
         VALUES (?, ?, ?, ?, ?, ?)`,
        [item.id, order.id, item.productId, item.productName, item.quantity, item.price]
      )
    }

    return order.id
  })
}

// Example: Authenticate user
export async function authenticateUser(email: string, password: string) {
  const results = await query(
    'SELECT * FROM users WHERE email = ? AND status = "active"',
    [email]
  )

  if (results.length === 0) {
    return null
  }

  const user = results[0]
  
  // In production, use bcrypt to compare passwords
  // const isValid = await bcrypt.compare(password, user.password)
  // if (!isValid) return null

  // Remove password from returned user object
  const { password: _, ...userWithoutPassword } = user
  return userWithoutPassword
}

export default pool
*/

// For now, the application uses mock data from lib/mock-data.ts
// Follow the instructions in DATABASE_SETUP.md to integrate MySQL
export {}
