# Southern Goods Inventory Management System

A comprehensive inventory and order management system for warehouse operations, built with Next.js and designed for MySQL database integration.

## Features

### Admin Dashboard
- **User Management** - Create, edit, and manage user accounts with role-based permissions
- **Inventory Management** - Track stock levels, adjust quantities, and monitor low stock alerts
- **Order Management** - Process customer orders, approve/cancel orders, and track order status
- **Supplier Shipments** - Receive and verify incoming shipments with GRN (Goods Received Note)
- **Business Reports** - Generate comprehensive reports for sales, inventory, orders, and shipments
- **Real-time Alerts** - Get notified about low stock, delayed shipments, and pending approvals

### User Dashboard
- **Product Browsing** - View available products with search and category filtering
- **Order History** - Track previous orders and view order details
- **Order Placement** - Add products to cart and place new orders
- **Order Tracking** - Monitor order status from pending to completed

## Tech Stack

- **Framework**: Next.js 15 with App Router
- **Styling**: Tailwind CSS v4
- **UI Components**: shadcn/ui
- **Database**: MySQL (ready for integration)
- **Authentication**: Cookie-based sessions (ready for JWT/OAuth)
- **TypeScript**: Full type safety

## Getting Started

### Prerequisites

- Node.js 18+ 
- MySQL 8.0+ (for production)

### Installation

1. Clone or download the project
2. Install dependencies:
   \`\`\`bash
   npm install
   \`\`\`

3. Run the development server:
   \`\`\`bash
   npm run dev
   \`\`\`

4. Open [http://localhost:3000](http://localhost:3000)

### Demo Credentials

**Admin Account:**
- Email: admin@southerngoods.com
- Password: admin123

**User Account:**
- Email: user@southerngoods.com
- Password: user123

## Database Integration

The application currently uses mock data for development. To integrate with MySQL:

1. Follow the instructions in \`DATABASE_SETUP.md\`
2. Set up your MySQL database and run the schema migrations
3. Configure environment variables in \`.env.local\`
4. Replace mock data imports with database queries using \`lib/db.example.ts\` as reference

## Project Structure

\`\`\`
├── app/
│   ├── admin/              # Admin dashboard pages
│   │   ├── inventory/      # Inventory management
│   │   ├── orders/         # Order management
│   │   ├── reports/        # Business reports
│   │   ├── shipments/      # Supplier shipments
│   │   └── users/          # User management
│   ├── dashboard/          # User dashboard pages
│   │   └── orders/         # User order history
│   ├── login/              # Authentication page
│   └── actions/            # Server actions
├── components/
│   ├── ui/                 # shadcn/ui components
│   ├── admin-sidebar.tsx   # Admin navigation
│   ├── admin-header.tsx    # Admin header
│   ├── user-header.tsx     # User navigation
│   └── site-header.tsx     # Landing page header
├── lib/
│   ├── auth.ts             # Authentication utilities
│   ├── db-types.ts         # TypeScript interfaces
│   ├── mock-data.ts        # Development mock data
│   └── db.example.ts       # MySQL integration example
├── middleware.ts           # Route protection
└── DATABASE_SETUP.md       # Database setup guide
\`\`\`

## Use Case Implementation

This system implements the following use cases from your specifications:

- **UC-01**: Business Report Generation
- **UC-02**: Update Company Stock (Inventory Management)
- **UC-03**: Process Customer Order & Payment
- **UC-04**: Assign Course & Track Completion (adaptable for training)
- **UC-05**: Manage Users
- **UC-06**: Receive Supplier Shipment

## Deployment

### Deploy to Vercel

1. Click the "Publish" button in the v0 interface
2. Connect your GitHub repository
3. Configure environment variables
4. Deploy

### Manual Deployment

1. Build the project:
   \`\`\`bash
   npm run build
   \`\`\`

2. Start the production server:
   \`\`\`bash
   npm start
   \`\`\`

## IntelliJ IDEA Setup

1. Open the project folder in IntelliJ IDEA
2. Install the JavaScript and TypeScript plugin
3. Configure Node.js interpreter
4. Set up MySQL data source in Database tool window
5. Use the built-in terminal to run npm commands

## Security Considerations

- Passwords should be hashed using bcrypt in production
- Implement proper JWT or session-based authentication
- Use HTTPS in production
- Enable CORS protection
- Implement rate limiting
- Regular security audits
- Database connection pooling
- Input validation and sanitization

## Future Enhancements

- Real-time notifications with WebSockets
- Advanced analytics and charts
- Barcode scanning integration
- Mobile app version
- Multi-warehouse support
- Automated reordering
- Integration with accounting systems
- Email notifications
- PDF invoice generation

## Support

For issues or questions, refer to the documentation or contact the development team.

## License

Proprietary - Southern Goods Pvt Ltd
\`\`\`

```json file="" isHidden
