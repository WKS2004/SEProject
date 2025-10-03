"use server"

import { cookies } from "next/headers"
import { authenticateUser } from "@/lib/auth"

export async function login(email: string, password: string) {
  const user = authenticateUser(email, password)

  if (!user) {
    return { success: false, error: "Invalid credentials" }
  }

  // In production, use proper session management (JWT, etc.)
  const cookieStore = await cookies()
  cookieStore.set("user_id", user.id, {
    httpOnly: true,
    secure: process.env.NODE_ENV === "production",
    sameSite: "lax",
    maxAge: 60 * 60 * 24 * 7, // 1 week
  })

  cookieStore.set("user_role", user.role, {
    httpOnly: true,
    secure: process.env.NODE_ENV === "production",
    sameSite: "lax",
    maxAge: 60 * 60 * 24 * 7,
  })

  return { success: true, user: { id: user.id, email: user.email, name: user.name, role: user.role } }
}

export async function logout() {
  const cookieStore = await cookies()
  cookieStore.delete("user_id")
  cookieStore.delete("user_role")
  return { success: true }
}

export async function getCurrentUser() {
  const cookieStore = await cookies()
  const userId = cookieStore.get("user_id")?.value
  const userRole = cookieStore.get("user_role")?.value

  if (!userId || !userRole) {
    return null
  }

  return { id: userId, role: userRole as "admin" | "user" }
}
