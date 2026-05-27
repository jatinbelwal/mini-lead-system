# Mini Lead Distribution System

A backend-based lead distribution system built using Spring Boot and MongoDB.

## Features

- Lead creation API
- Automatic provider assignment
- Mandatory provider allocation rules
- Fair provider distribution
- Monthly quota handling
- Dashboard API
- Webhook simulation APIs
- Test lead generation
- MongoDB persistence

---

# Tech Stack

## Backend
- Java
- Spring Boot
- Maven

## Database
- MongoDB

## API Testing
- Talend API Tester / Hoppscotch

---

# Business Rules

## Mandatory Assignment Rules

- Service 1 → Provider 1 always assigned
- Service 2 → Provider 5 always assigned
- Service 3 → Provider 1 and Provider 4 always assigned

Each lead is assigned to exactly 3 providers.

---

# Fair Allocation Logic

After assigning mandatory providers, remaining providers are selected fairly from predefined pools while respecting monthly quotas.

---

# APIs

## Create Lead

POST `/api/leads`

Example Request:

```json
{
  "name": "Rahul",
  "phone": "9999999999",
  "city": "Delhi",
  "serviceType": "Service 1",
  "description": "Pipe leakage"
}
