import { NextResponse } from "next/server"
import type { NextRequest } from "next/server"

export function middleware(request: NextRequest) {
  const userId = request.cookies.get("user_id")?.value
  const userRole = request.cookies.get("user_role")?.value

  const isAdminRoute = request.nextUrl.pathname.startsWith("/admin")
  const isUserRoute = request.nextUrl.pathname.startsWith("/dashboard")
  const isAuthRoute = request.nextUrl.pathname === "/login"

  // Redirect to login if not authenticated
  if ((isAdminRoute || isUserRoute) && !userId) {
    return NextResponse.redirect(new URL("/login", request.url))
  }

  // Redirect admin to admin dashboard if trying to access user dashboard
  if (isUserRoute && userRole === "admin") {
    return NextResponse.redirect(new URL("/admin", request.url))
  }

  // Redirect user to user dashboard if trying to access admin dashboard
  if (isAdminRoute && userRole === "user") {
    return NextResponse.redirect(new URL("/dashboard", request.url))
  }

  // Redirect authenticated users away from login page
  if (isAuthRoute && userId) {
    if (userRole === "admin") {
      return NextResponse.redirect(new URL("/admin", request.url))
    }
    return NextResponse.redirect(new URL("/dashboard", request.url))
  }

  return NextResponse.next()
}

export const config = {
  matcher: ["/admin/:path*", "/dashboard/:path*", "/login"],
}
