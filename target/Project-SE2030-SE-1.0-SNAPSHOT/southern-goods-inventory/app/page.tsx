import Link from "next/link"
import { Button } from "@/components/ui/button"
import { SiteHeader } from "@/components/site-header"
import { Package, TrendingUp, Clock } from "lucide-react"

export default function HomePage() {
  return (
    <div className="min-h-screen">
      <SiteHeader />

      {/* Hero Section */}
      <section className="relative min-h-[calc(100vh-4rem)] flex items-center">
        {/* Background Image with Overlay */}
        <div className="absolute inset-0 z-0">
          <img src="/warehouse-bg.jpg" alt="Warehouse" className="w-full h-full object-cover" />
          <div className="absolute inset-0 bg-gradient-to-r from-primary/95 via-primary/85 to-primary/70" />
        </div>

        {/* Content */}
        <div className="container relative z-10 py-20">
          <div className="max-w-3xl">
            <h1 className="text-5xl md:text-6xl lg:text-7xl font-bold text-white mb-6 leading-tight">
              Smart Inventory{" "}
              <span className="text-accent-foreground bg-accent/20 px-3 py-1 rounded-lg">Management System</span>
            </h1>

            <p className="text-lg md:text-xl text-white/90 mb-8 leading-relaxed max-w-2xl">
              Streamline your warehouse operations with real-time tracking, automated alerts, and comprehensive
              analytics for Southern Goods Pvt Ltd.
            </p>

            <div className="flex flex-col sm:flex-row gap-4 mb-12">
              <Button asChild size="lg" className="bg-white text-primary hover:bg-white/90 text-base px-8">
                <Link href="/login">Get Started Now</Link>
              </Button>
              <Button
                asChild
                size="lg"
                variant="outline"
                className="border-white text-white hover:bg-white/10 text-base px-8 bg-transparent"
              >
                <Link href="#features">Watch Demo</Link>
              </Button>
            </div>

            {/* Stats */}
            <div className="grid grid-cols-3 gap-6 max-w-2xl">
              <div className="text-center">
                <div className="flex items-center justify-center gap-2 mb-2">
                  <Package className="w-5 h-5 text-accent-foreground" />
                  <div className="text-3xl md:text-4xl font-bold text-white">10,000+</div>
                </div>
                <div className="text-sm text-white/80">Products Managed</div>
              </div>

              <div className="text-center">
                <div className="flex items-center justify-center gap-2 mb-2">
                  <TrendingUp className="w-5 h-5 text-accent-foreground" />
                  <div className="text-3xl md:text-4xl font-bold text-white">99.9%</div>
                </div>
                <div className="text-sm text-white/80">Uptime</div>
              </div>

              <div className="text-center">
                <div className="flex items-center justify-center gap-2 mb-2">
                  <Clock className="w-5 h-5 text-accent-foreground" />
                  <div className="text-3xl md:text-4xl font-bold text-white">24/7</div>
                </div>
                <div className="text-sm text-white/80">Support</div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  )
}
