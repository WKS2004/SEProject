"use client"

import Link from "next/link"
import { usePathname } from "next/navigation"
import { cn } from "@/lib/utils"
import { Button } from "@/components/ui/button"
import { Avatar, AvatarFallback } from "@/components/ui/avatar"
import { ShoppingCart, Package, LogOut } from "lucide-react"
import { logout } from "@/app/actions/auth"
import { useRouter } from "next/navigation"

export function UserHeader() {
  const pathname = usePathname()
  const router = useRouter()

  async function handleLogout() {
    await logout()
    router.push("/login")
  }

  return (
    <header className="sticky top-0 z-50 w-full border-b bg-background">
      <div className="container flex h-16 items-center justify-between">
        <Link href="/dashboard" className="flex flex-col">
          <span className="text-xl font-bold text-primary" style={{ fontFamily: "cursive" }}>
            Southern Goods
          </span>
          <span className="text-xs text-muted-foreground">Customer Portal</span>
        </Link>

        <nav className="hidden md:flex items-center gap-6">
          <Link
            href="/dashboard"
            className={cn(
              "text-sm font-medium transition-colors hover:text-primary",
              pathname === "/dashboard" ? "text-primary" : "text-muted-foreground",
            )}
          >
            <Package className="inline-block mr-1 h-4 w-4" />
            Products
          </Link>
          <Link
            href="/dashboard/orders"
            className={cn(
              "text-sm font-medium transition-colors hover:text-primary",
              pathname === "/dashboard/orders" ? "text-primary" : "text-muted-foreground",
            )}
          >
            <ShoppingCart className="inline-block mr-1 h-4 w-4" />
            My Orders
          </Link>
        </nav>

        <div className="flex items-center gap-4">
          <Button variant="ghost" size="icon" className="relative">
            <ShoppingCart className="h-5 w-5" />
            <span className="absolute -top-1 -right-1 h-5 w-5 rounded-full bg-primary text-xs text-primary-foreground flex items-center justify-center">
              0
            </span>
          </Button>

          <div className="flex items-center gap-3">
            <Avatar>
              <AvatarFallback className="bg-primary text-primary-foreground">U</AvatarFallback>
            </Avatar>
            <div className="hidden md:block">
              <p className="text-sm font-medium">Regular User</p>
              <p className="text-xs text-muted-foreground">Customer</p>
            </div>
          </div>

          <Button variant="ghost" size="icon" onClick={handleLogout}>
            <LogOut className="h-5 w-5" />
          </Button>
        </div>
      </div>
    </header>
  )
}
