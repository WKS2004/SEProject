// Authentication utilities and mock user data
// In production, replace with actual database queries

export type UserRole = "admin" | "user"

export interface User {
  id: string
  email: string
  name: string
  role: UserRole
  password: string // In production, this should be hashed
}

// Mock user database
const users: User[] = [
  {
    id: "1",
    email: "admin@southerngoods.com",
    name: "Admin User",
    role: "admin",
    password: "admin123", // In production, use hashed passwords
  },
  {
    id: "2",
    email: "user@southerngoods.com",
    name: "Regular User",
    role: "user",
    password: "user123",
  },
]

export function authenticateUser(email: string, password: string): User | null {
  const user = users.find((u) => u.email === email && u.password === password)
  return user || null
}

export function getUserById(id: string): User | null {
  return users.find((u) => u.id === id) || null
}

export function getAllUsers(): Omit<User, "password">[] {
  return users.map(({ password, ...user }) => user)
}
