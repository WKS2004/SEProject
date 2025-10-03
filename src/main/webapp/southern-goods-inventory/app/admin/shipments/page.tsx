"use client"

import { useState } from "react"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "@/components/ui/table"
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog"
import { Badge } from "@/components/ui/badge"
import { Search, Eye, TruckIcon } from "lucide-react"
import { mockShipments } from "@/lib/mock-data"

export default function ShipmentsPage() {
  const [shipments, setShipments] = useState(mockShipments)

  function getStatusBadge(status: string) {
    const variants: Record<string, { variant: any; className: string }> = {
      pending: { variant: "outline", className: "bg-yellow-50 text-yellow-700 border-yellow-200" },
      received: { variant: "outline", className: "bg-blue-50 text-blue-700 border-blue-200" },
      verified: { variant: "outline", className: "bg-green-50 text-green-700 border-green-200" },
    }
    return variants[status] || variants.pending
  }

  return (
    <div className="space-y-6">
      <div className="flex items-center justify-between">
        <div>
          <h1 className="text-3xl font-bold">Supplier Shipments</h1>
          <p className="text-muted-foreground">Receive and verify incoming shipments</p>
        </div>
      </div>

      {/* Stats */}
      <div className="grid gap-4 md:grid-cols-3">
        <Card>
          <CardHeader className="flex flex-row items-center justify-between pb-2">
            <CardTitle className="text-sm font-medium">Total Shipments</CardTitle>
            <TruckIcon className="h-4 w-4 text-muted-foreground" />
          </CardHeader>
          <CardContent>
            <div className="text-2xl font-bold">{shipments.length}</div>
          </CardContent>
        </Card>
        <Card>
          <CardHeader className="flex flex-row items-center justify-between pb-2">
            <CardTitle className="text-sm font-medium">Pending Verification</CardTitle>
            <TruckIcon className="h-4 w-4 text-yellow-600" />
          </CardHeader>
          <CardContent>
            <div className="text-2xl font-bold">{shipments.filter((s) => s.status === "received").length}</div>
          </CardContent>
        </Card>
        <Card>
          <CardHeader className="flex flex-row items-center justify-between pb-2">
            <CardTitle className="text-sm font-medium">Verified</CardTitle>
            <TruckIcon className="h-4 w-4 text-green-600" />
          </CardHeader>
          <CardContent>
            <div className="text-2xl font-bold">{shipments.filter((s) => s.status === "verified").length}</div>
          </CardContent>
        </Card>
      </div>

      {/* Shipments Table */}
      <Card>
        <CardHeader>
          <div className="flex items-center justify-between">
            <CardTitle>All Shipments</CardTitle>
            <div className="relative w-64">
              <Search className="absolute left-3 top-1/2 h-4 w-4 -translate-y-1/2 text-muted-foreground" />
              <Input placeholder="Search shipments..." className="pl-9" />
            </div>
          </div>
        </CardHeader>
        <CardContent>
          <Table>
            <TableHeader>
              <TableRow>
                <TableHead>Shipment ID</TableHead>
                <TableHead>Supplier</TableHead>
                <TableHead>PO Number</TableHead>
                <TableHead>Received Date</TableHead>
                <TableHead>Items</TableHead>
                <TableHead>Status</TableHead>
                <TableHead className="text-right">Actions</TableHead>
              </TableRow>
            </TableHeader>
            <TableBody>
              {shipments.map((shipment) => {
                const statusStyle = getStatusBadge(shipment.status)
                return (
                  <TableRow key={shipment.id}>
                    <TableCell className="font-mono text-sm">{shipment.id}</TableCell>
                    <TableCell className="font-medium">{shipment.supplierName}</TableCell>
                    <TableCell className="font-mono text-sm">{shipment.purchaseOrderId}</TableCell>
                    <TableCell>{new Date(shipment.receivedDate).toLocaleDateString()}</TableCell>
                    <TableCell>{shipment.items.length} items</TableCell>
                    <TableCell>
                      <Badge variant={statusStyle.variant} className={statusStyle.className}>
                        {shipment.status}
                      </Badge>
                    </TableCell>
                    <TableCell className="text-right">
                      <Dialog>
                        <DialogTrigger asChild>
                          <Button variant="outline" size="sm">
                            <Eye className="mr-1 h-3 w-3" />
                            View Details
                          </Button>
                        </DialogTrigger>
                        <DialogContent className="max-w-3xl">
                          <DialogHeader>
                            <DialogTitle>Shipment Details - {shipment.id}</DialogTitle>
                            <DialogDescription>Verify received items and quantities</DialogDescription>
                          </DialogHeader>
                          <div className="space-y-4">
                            <div className="grid grid-cols-2 gap-4">
                              <div>
                                <p className="text-sm font-medium text-muted-foreground">Supplier</p>
                                <p className="text-base font-medium">{shipment.supplierName}</p>
                              </div>
                              <div>
                                <p className="text-sm font-medium text-muted-foreground">Purchase Order</p>
                                <p className="text-base font-mono">{shipment.purchaseOrderId}</p>
                              </div>
                              <div>
                                <p className="text-sm font-medium text-muted-foreground">Received Date</p>
                                <p className="text-base">{new Date(shipment.receivedDate).toLocaleDateString()}</p>
                              </div>
                              <div>
                                <p className="text-sm font-medium text-muted-foreground">Status</p>
                                <Badge variant={statusStyle.variant} className={statusStyle.className}>
                                  {shipment.status}
                                </Badge>
                              </div>
                            </div>

                            <div>
                              <p className="text-sm font-medium text-muted-foreground mb-2">Shipment Items</p>
                              <Table>
                                <TableHeader>
                                  <TableRow>
                                    <TableHead>Product</TableHead>
                                    <TableHead>Expected</TableHead>
                                    <TableHead>Received</TableHead>
                                    <TableHead>Damaged</TableHead>
                                    <TableHead>Status</TableHead>
                                  </TableRow>
                                </TableHeader>
                                <TableBody>
                                  {shipment.items.map((item, idx) => {
                                    const isMatch =
                                      item.expectedQuantity === item.receivedQuantity && item.damaged === 0
                                    return (
                                      <TableRow key={idx}>
                                        <TableCell>{item.productName}</TableCell>
                                        <TableCell>{item.expectedQuantity}</TableCell>
                                        <TableCell className="font-medium">{item.receivedQuantity}</TableCell>
                                        <TableCell className={item.damaged > 0 ? "text-red-600 font-medium" : ""}>
                                          {item.damaged}
                                        </TableCell>
                                        <TableCell>
                                          {isMatch ? (
                                            <Badge
                                              variant="outline"
                                              className="bg-green-50 text-green-700 border-green-200"
                                            >
                                              Match
                                            </Badge>
                                          ) : (
                                            <Badge
                                              variant="outline"
                                              className="bg-yellow-50 text-yellow-700 border-yellow-200"
                                            >
                                              Mismatch
                                            </Badge>
                                          )}
                                        </TableCell>
                                      </TableRow>
                                    )
                                  })}
                                </TableBody>
                              </Table>
                            </div>

                            <div>
                              <p className="text-sm font-medium text-muted-foreground mb-2">Notes</p>
                              <p className="text-base">{shipment.notes}</p>
                            </div>

                            {shipment.status === "received" && (
                              <div className="flex gap-2 pt-4">
                                <Button className="flex-1">Verify & Update Stock</Button>
                                <Button variant="outline" className="flex-1 bg-transparent">
                                  Report Issue
                                </Button>
                              </div>
                            )}
                          </div>
                        </DialogContent>
                      </Dialog>
                    </TableCell>
                  </TableRow>
                )
              })}
            </TableBody>
          </Table>
        </CardContent>
      </Card>
    </div>
  )
}
