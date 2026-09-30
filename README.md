# webizency-crm-platform
CRM platform for lead management - Webizency

Date: 30th Sep 2026
First Milestone step completed in designing entire CRM from base.

Keycloak JWT                         ✓
        │
        ▼
API Gateway :8080                   ✓
        │
        ▼
Gateway routing                      ✓
        │
        ▼
User Service :8081                  ✓
        │
        ├── JWT validation           ✓
        ├── ADMIN authorization      ✓
        ├── Controller               ✓
        ├── JPA                      ✓
        ├── Flyway                   ✓
        ▼
MySQL                                ✓
        │
        └── Duplicate protection     ✓
