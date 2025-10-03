// Mock data for development
// Replace with actual MySQL queries in production

import type { Product, Order, SupplierShipment } from "./db-types"

export const mockProducts: Product[] = [
  {
    id: "P001",
    name: "Industrial Shelving Unit",
    sku: "ISU-2024-001",
    category: "Storage",
    quantity: 150,
    threshold: 50,
    price: 299.99,
    supplier: "MetalWorks Inc",
    lastUpdated: new Date("2024-01-15"),
  },
  {
    id: "P002",
    name: "Pallet Jack",
    sku: "PJ-2024-002",
    category: "Equipment",
    quantity: 25,
    threshold: 10,
    price: 899.99,
    supplier: "Warehouse Solutions",
    lastUpdated: new Date("2024-01-20"),
  },
  {
    id: "P003",
    name: "Safety Vest",
    sku: "SV-2024-003",
    category: "Safety",
    quantity: 500,
    threshold: 100,
    price: 12.99,
    supplier: "SafetyFirst Co",
    lastUpdated: new Date("2024-01-18"),
  },
  {
    id: "P004",
    name: "Barcode Scanner",
    sku: "BS-2024-004",
    category: "Technology",
    quantity: 45,
    threshold: 15,
    price: 249.99,
    supplier: "TechSupply Ltd",
    lastUpdated: new Date("2024-01-22"),
  },
  {
    id: "P005",
    name: "Cardboard Boxes (Pack of 50)",
    sku: "CB-2024-005",
    category: "Packaging",
    quantity: 800,
    threshold: 200,
    price: 45.99,
    supplier: "PackagePro",
    lastUpdated: new Date("2024-01-19"),
  },
]

export const mockOrders: Order[] = [
  {
    id: "ORD-001",
    userId: "2",
    customerName: "Regular User",
    orderDate: new Date("2024-01-20"),
    status: "completed",
    items: [
      { productId: "P003", productName: "Safety Vest", quantity: 10, price: 12.99 },
      { productId: "P005", productName: "Cardboard Boxes", quantity: 5, price: 45.99 },
    ],
    totalAmount: 359.85,
    paymentMethod: "Credit Card",
    shippingAddress: "123 Warehouse St, Industrial Park",
  },
  {
    id: "ORD-002",
    userId: "2",
    customerName: "Regular User",
    orderDate: new Date("2024-01-25"),
    status: "processing",
    items: [{ productId: "P001", productName: "Industrial Shelving Unit", quantity: 2, price: 299.99 }],
    totalAmount: 599.98,
    paymentMethod: "Bank Transfer",
    shippingAddress: "123 Warehouse St, Industrial Park",
  },
]

export const mockShipments: SupplierShipment[] = [
  {
    id: "SHP-001",
    supplierId: "SUP-001",
    supplierName: "MetalWorks Inc",
    purchaseOrderId: "PO-2024-001",
    receivedDate: new Date("2024-01-15"),
    status: "verified",
    items: [
      {
        productId: "P001",
        productName: "Industrial Shelving Unit",
        expectedQuantity: 100,
        receivedQuantity: 100,
        damaged: 0,
      },
    ],
    notes: "All items received in good condition",
  },
  {
    id: "SHP-002",
    supplierId: "SUP-002",
    supplierName: "SafetyFirst Co",
    purchaseOrderId: "PO-2024-002",
    receivedDate: new Date("2024-01-18"),
    status: "received",
    items: [
      {
        productId: "P003",
        productName: "Safety Vest",
        expectedQuantity: 500,
        receivedQuantity: 495,
        damaged: 5,
      },
    ],
    notes: "5 items damaged during shipping",
  },
]
