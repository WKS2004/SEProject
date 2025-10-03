import Link from "next/link"
import { Button } from "@/components/ui/button"

export function SiteHeader() {
  return (
    <header className="sticky top-0 z-50 w-full border-b border-white/10 bg-primary/95 backdrop-blur supports-[backdrop-filter]:bg-primary/80">
      <div className="container flex h-16 items-center justify-between">
        <Link href="/southern-goods-inventory/public" className="flex items-center space-x-2">
          <div className="flex flex-col">
            <span className="text-2xl font-bold text-white" style={{ fontFamily: "cursive" }}>
              Southern Goods
            </span>
            <span className="text-xs text-white/80">Pvt Ltd</span>
          </div>
        </Link>

        <nav className="hidden md:flex items-center gap-6">
          <Link href="#dashboard" className="text-sm font-medium text-white hover:text-white/80 transition-colors">
            Dashboard
          </Link>
          <Link href="#inventory" className="text-sm font-medium text-white hover:text-white/80 transition-colors">
            Inventory
          </Link>
          <Link href="#orders" className="text-sm font-medium text-white hover:text-white/80 transition-colors">
            Orders
          </Link>
          <Link href="#reports" className="text-sm font-medium text-white hover:text-white/80 transition-colors">
            Reports
          </Link>
        </nav>

        <Button asChild className="bg-white text-primary hover:bg-white/90">
          <Link href="/login">Login</Link>
        </Button>
      </div>
    </header>
  )
}
