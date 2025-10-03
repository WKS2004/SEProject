import type React from "react"
import { UserHeader } from "@/components/user-header"

export default function DashboardLayout({ children }: { children: React.ReactNode }) {
  return (
    <div className="min-h-screen flex flex-col">
      <UserHeader />
      <main className="flex-1 bg-muted/30">{children}</main>
    </div>
  )
}
