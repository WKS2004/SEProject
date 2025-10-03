// Database type definitions for MySQL integration
// These interfaces match the use case specifications

export interface Product {
  id: string
  name: string
  sku: string
  category: string
  quantity: number
  threshold: number
  price: number
  supplier: string
  lastUpdated: Date
}

export interface Order {
  id: string
  userId: string
  customerName: string
  orderDate: Date
  status: "pending" | "processing" | "completed" | "cancelled"
  items: OrderItem[]
  totalAmount: number
  paymentMethod: string
  shippingAddress: string
}

export interface OrderItem {
  productId: string
  productName: string
  quantity: number
  price: number
}

export interface SupplierShipment {
  id: string
  supplierId: string
  supplierName: string
  purchaseOrderId: string
  receivedDate: Date
  status: "pending" | "received" | "verified"
  items: ShipmentItem[]
  notes: string
}

export interface ShipmentItem {
  productId: string
  productName: string
  expectedQuantity: number
  receivedQuantity: number
  damaged: number
}

export interface StockAdjustment {
  id: string
  productId: string
  adjustmentType: "add" | "remove" | "recount" | "damage" | "return"
  quantity: number
  reason: string
  performedBy: string
  timestamp: Date
}

export interface Report {
  id: string
  type: "sales" | "inventory" | "orders" | "shipments"
  generatedBy: string
  generatedAt: Date
  filters: Record<string, any>
  data: any
}
